package SegundoEjercicio.controllers;

import SegundoEjercicio.DAO.TransporteDAO;
import SegundoEjercicio.models.*;
import SegundoEjercicio.views.VentanaRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControllerRegistroTransporte {
    private VentanaRegistro vista;
    private TransporteDAO dao;

    // El constructor es donde se inicializa todo y se añaden los "oyentes".
    public ControllerRegistroTransporte(VentanaRegistro vistaRegistro, TransporteDAO dao) {
        this.vista = vistaRegistro;
        this.dao = dao;

        // --- Listener para el ComboBox (habilita y deshabilita campos) ---
        this.vista.getCbxTipoTransporte().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Se ejecuta solo cuando se selecciona un nuevo ítem
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String tipo = (String) e.getItem();

                    // Primero, apaga todos los campos específicos para limpiar la vista
                    vista.getTxtNumeroRutaBus().setEnabled(false);
                    vista.getTxtTarifaBaseTaxi().setEnabled(false);
                    vista.getTxtIdEstacionBici().setEnabled(false);

                    // También limpia su texto
                    vista.getTxtNumeroRutaBus().setText("");
                    vista.getTxtTarifaBaseTaxi().setText("");
                    vista.getTxtIdEstacionBici().setText("");

                    // Luego, enciende solo el campo que corresponde al tipo seleccionado
                    switch (tipo) {
                        case "Bus":
                            vista.getTxtNumeroRutaBus().setEnabled(true);
                            break;
                        case "Taxi":
                            vista.getTxtTarifaBaseTaxi().setEnabled(true);
                            break;
                        case "Bicicleta Publica": // ¡Ojo! Asegúrate que este texto sea idéntico al del ComboBox
                            vista.getTxtIdEstacionBici().setEnabled(true);
                            break;
                    }
                }
            }
        });

        // --- Listener para el botón "Registrar" ---
        this.vista.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarTransporte();
            }
        });

        // --- Configuración Inicial ---
        // Forzamos el estado inicial para que los campos se configuren para la primera opción ("Bus")
        this.vista.getCbxTipoTransporte().setSelectedIndex(0);
    }

    // --- Métodos de Lógica ---
    private void registrarTransporte() {
        try {
            // 1. Leer datos comunes de la vista
            String codigo = vista.getTxtCodigo().getText();
            String nombre = vista.getTxtNombreComercial().getText();
            double tarifaKm = Double.parseDouble(vista.getTxtTarifaPorKm().getText());
            String tipo = (String) vista.getCbxTipoTransporte().getSelectedItem();

            Transporte nuevoTransporte = null;

            // 2. Crear el objeto correcto según el tipo seleccionado
            switch (tipo) {
                case "Taxi":
                    double tarifaBase = Double.parseDouble(vista.getTxtTarifaBaseTaxi().getText());
                    nuevoTransporte = new Taxi(codigo, nombre, tarifaKm, tarifaBase);
                    break;
                case "Bus":
                    String ruta = vista.getTxtNumeroRutaBus().getText();
                    nuevoTransporte = new Bus(codigo, nombre, tarifaKm, ruta);
                    break;
                case "Bicicleta Publica": // ¡Ojo! También debe coincidir aquí
                    String idEstacion = vista.getTxtIdEstacionBici().getText();
                    nuevoTransporte = new BicicletaPublica(codigo, nombre, tarifaKm, idEstacion);
                    break;
            }

            // 3. Usar el DAO para guardar el objeto y notificar al usuario
            if (nuevoTransporte != null) {
                dao.registrar(nuevoTransporte);
                JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "Transporte '" + nombre + "' registrado con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "Por favor, ingrese valores numéricos válidos para las tarifas.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}