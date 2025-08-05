package PrimerEjercicio.views;

import javax.swing.*;

public class VentanaRegistro {
    private JPanel panelPrincipal;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtHorasClase;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JComboBox cbxTipo;
    private JButton btnRegistrar;
    private JTextField txtHorasLaboratorio;
    private JLabel lblHorasClase;
    private JLabel lblHorasLaboratorios;
    private JTable table1;
    private JLabel tablaAsignaturasLabel;
    private JLabel registroAsignaturasLabel;
    private JButton btnCalcular;

    // Getter para el panel principal (para mostrarlo en la ventana)
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    // Getters para los componentes con los que el controlador necesita interactuar
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtHorasClase() {
        return txtHorasClase;
    }

    public void setTxtHorasClase(JTextField txtHorasClase) {
        this.txtHorasClase = txtHorasClase;
    }

    public JComboBox getCbxTipo() {
        return cbxTipo;
    }

    public JTextField getTxtHorasLaboratorio() {
        return txtHorasLaboratorio;
    }

    public JTable getTablaAsignaturas() {
        return table1;
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }

}
