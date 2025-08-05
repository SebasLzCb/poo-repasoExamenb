package SegundoEjercicio.views;

import javax.swing.*;

public class VentanaRegistro {
    // --- Atributos ---
    // Cada componente de tu ventana debe tener un atributo aquí.
    private JPanel panelPrincipal; // El panel raíz de tu ventana.
    private JTextField txtCodigo;
    private JTextField txtNombreComercial;
    private JTextField txtTarifaPorKm;
    private JComboBox<String> cbxTipoTransporte; // Especificamos que es de Strings.
    private JButton btnRegistrar;
    // Atributos específicos para cada tipo
    private JTextField txtTarifaBaseTaxi; // Solo para Taxi
    private JTextField txtNumeroRutaBus;  // Solo para Bus
    private JTextField txtIdEstacionBici; // Solo para Bicicleta
    private JLabel lblRuta;
    private JLabel lblCodigo;
    private JLabel lblEstacion;
    private JLabel lblNombreCo;
    private JLabel lblTarifaTaxi;
    private JLabel lblTarifaKm;
    private JLabel lblTipo;
    private JLabel lblRegistrol;

    // --- Getters Públicos ---
    // Estos son los "puentes" para que el Controlador pueda acceder a los componentes.
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }
    public JTextField getTxtNombreComercial() {
        return txtNombreComercial;
    }
    public JTextField getTxtTarifaPorKm() {
        return txtTarifaPorKm;
    }
    public JComboBox<String> getCbxTipoTransporte() {
        return cbxTipoTransporte;
    }
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }
    public JTextField getTxtTarifaBaseTaxi() {
        return txtTarifaBaseTaxi;
    }
    public JTextField getTxtNumeroRutaBus() {
        return txtNumeroRutaBus;
    }
    public JTextField getTxtIdEstacionBici() {
        return txtIdEstacionBici;
    }
}