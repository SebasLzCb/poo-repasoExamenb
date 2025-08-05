package PrimerEjercicio.controllers;

import PrimerEjercicio.DAO.AsignaturaDAO;
import PrimerEjercicio.models.Asignatura;
import PrimerEjercicio.models.AsignaturaMixta;
import PrimerEjercicio.models.AsignaturaPractica;
import PrimerEjercicio.models.AsignaturaTeorica;
import PrimerEjercicio.views.VentanaRegistro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class ControllerRegistro {
    private VentanaRegistro vista;
    private AsignaturaDAO dao;

    public ControllerRegistro(VentanaRegistro vista, AsignaturaDAO dao) {
        this.vista = vista;
        this.dao = dao;

        // --- LISTENERS DE LA INTERFAZ ---

        // 1. Listener para el ComboBox (habilita/deshabilita campos)
        this.vista.getCbxTipo().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    configurarCamposPorTipo((String) e.getItem());
                }
            }
        });

        // 2. Listener para el botón "Registrar"
        this.vista.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAsignatura();
            }
        });

        // 3. Listener para el botón "Calcular Carga Horaria"
        this.vista.getBtnCalcular().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCargaHorariaSeleccionada();
            }
        });

        // --- CONFIGURACIÓN INICIAL ---
        configurarCamposPorTipo((String) this.vista.getCbxTipo().getSelectedItem());
        actualizarTabla();
    }

    private void registrarAsignatura() {
        try {
            // 1. Leer los datos de la vista
            String codigo = vista.getTxtCodigo().getText();
            String nombre = vista.getTxtNombre().getText();
            String tipo = (String) vista.getCbxTipo().getSelectedItem();

            if (codigo.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "El código y el nombre no pueden estar vacíos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Asignatura nuevaAsignatura = null;

            // 2. Crear el objeto del Modelo según el tipo
            switch (tipo) {
                case "Teórica":
                    int horasClase = Integer.parseInt(vista.getTxtHorasClase().getText());
                    nuevaAsignatura = new AsignaturaTeorica(codigo, nombre, horasClase);
                    break;
                case "Práctica":
                    int horasLaboratorio = Integer.parseInt(vista.getTxtHorasLaboratorio().getText());
                    nuevaAsignatura = new AsignaturaPractica(codigo, nombre, horasLaboratorio);
                    break;
                case "Mixta":
                    int hClase = Integer.parseInt(vista.getTxtHorasClase().getText());
                    int hLab = Integer.parseInt(vista.getTxtHorasLaboratorio().getText());
                    nuevaAsignatura = new AsignaturaMixta(codigo, nombre, hClase, hLab);
                    break;
            }

            // 3. Registrar en el DAO y actualizar la interfaz
            if (nuevaAsignatura != null) {
                dao.registrar(nuevaAsignatura);
                actualizarTabla();
                limpiarCampos();
                JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "Asignatura registrada con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // Manejo de error si el usuario pone texto en los campos de horas
            JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "Por favor, ingrese un número válido para las horas.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularCargaHorariaSeleccionada() {
        int filaSeleccionada = vista.getTablaAsignaturas().getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "Por favor, seleccione una asignatura de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigo = (String) vista.getTablaAsignaturas().getValueAt(filaSeleccionada, 0);
        Asignatura asignatura = dao.buscarPorCodigo(codigo);

        if (asignatura != null) {
            double cargaHoraria = asignatura.calcularCargaHorariaSemanal();
            JOptionPane.showMessageDialog(vista.getPanelPrincipal(),
                    "La carga horaria semanal para '" + asignatura.getNombre() + "' es: " + cargaHoraria + " horas.",
                    "Resultado del Cálculo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void configurarCamposPorTipo(String tipo) {
        switch (tipo) {
            case "Teórica":
                vista.getTxtHorasClase().setEnabled(true);
                vista.getTxtHorasLaboratorio().setEnabled(false);
                break;
            case "Práctica":
                vista.getTxtHorasClase().setEnabled(false);
                vista.getTxtHorasLaboratorio().setEnabled(true);
                break;
            case "Mixta":
                vista.getTxtHorasClase().setEnabled(true);
                vista.getTxtHorasLaboratorio().setEnabled(true);
                break;
        }
        // Limpiamos los campos cada vez que se cambia la selección
        vista.getTxtHorasClase().setText("");
        vista.getTxtHorasLaboratorio().setText("");
    }

    public void actualizarTabla() {
        String[] columnas = {"Código", "Nombre", "Tipo"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hace que la tabla no sea editable
                return false;
            }
        };

        List<Asignatura> listaAsignaturas = dao.listarTodas();
        for (Asignatura asignatura : listaAsignaturas) {
            String tipo = asignatura.getClass().getSimpleName().replace("Asignatura", "");
            Object[] fila = {
                    asignatura.getCodigo(),
                    asignatura.getNombre(),
                    tipo
            };
            modeloTabla.addRow(fila);
        }
        vista.getTablaAsignaturas().setModel(modeloTabla);
    }

    public void limpiarCampos() {
        vista.getTxtCodigo().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtHorasClase().setText("");
        vista.getTxtHorasLaboratorio().setText("");
        vista.getCbxTipo().setSelectedIndex(0);
    }
}