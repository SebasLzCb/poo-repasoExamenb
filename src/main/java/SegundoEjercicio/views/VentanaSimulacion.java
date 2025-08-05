package SegundoEjercicio.views;

import javax.swing.*;

public class VentanaSimulacion {
    // --- Atributos ---
    private JPanel panelPrincipal;
    private JTextField txtCodigoTransporte;
    private JTextField txtKilometros;
    private JButton btnCalcularViaje;

    // --- Getters Públicos ---
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
    public JTextField getTxtCodigoTransporte() {
        return txtCodigoTransporte;
    }
    public JTextField getTxtKilometros() {
        return txtKilometros;
    }
    public JButton getBtnCalcularViaje() {
        return btnCalcularViaje;
    }
}