package SegundoEjercicio.controllers;

import SegundoEjercicio.DAO.TransporteDAO;
import SegundoEjercicio.models.Transporte;
import SegundoEjercicio.views.VentanaSimulacion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerSimulacion {
    private VentanaSimulacion vista;
    private TransporteDAO dao;

    public ControllerSimulacion(VentanaSimulacion vistaSimulacion, TransporteDAO dao) {
        this.vista = vistaSimulacion;
        this.dao = dao;

        this.vista.getBtnCalcularViaje().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simularViaje();
            }
        });
    }

    private void simularViaje() {
        try {
            // 1. Leer datos de la vista de simulación
            String codigo = vista.getTxtCodigoTransporte().getText();
            double kilometros = Double.parseDouble(vista.getTxtKilometros().getText());

            // 2. Usar el DAO para buscar el transporte
            Transporte transporte = dao.buscarPorCodigo(codigo);

            if (transporte == null) {
                JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "No se encontró ningún transporte con ese código.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. Aplicar Polimorfismo y mostrar el resultado
            double costoTotal = transporte.calcularCostoViaje(kilometros);
            JOptionPane.showMessageDialog(vista.getPanelPrincipal(),
                    "El costo total del viaje en '" + transporte.getNombreComercial() + "' es: $" + String.format("%.2f", costoTotal),
                    "Resultado de la Simulación",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista.getPanelPrincipal(), "Por favor, ingrese un número válido para los kilómetros.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}