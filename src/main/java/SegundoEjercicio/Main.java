package SegundoEjercicio;

import SegundoEjercicio.views.VentanaRegistro;
import SegundoEjercicio.controllers.ControllerRegistroTransporte;
import SegundoEjercicio.controllers.ControllerSimulacion;
import SegundoEjercicio.DAO.TransporteDAO;
import SegundoEjercicio.DAO.DAOimpl.TransporteDAOImpl;
import SegundoEjercicio.views.VentanaSimulacion;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 1. Crear el DAO compartido
        TransporteDAO dao = new TransporteDAOImpl();

        // 2. Crear y mostrar la ventana de REGISTRO con su controlador
        VentanaRegistro vistaRegistro = new VentanaRegistro();
        new ControllerRegistroTransporte(vistaRegistro, dao);
        JFrame frameRegistro = new JFrame("Registrar Transporte");
        frameRegistro.setContentPane(vistaRegistro.getPanelPrincipal());
        frameRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistro.pack();
        frameRegistro.setLocationRelativeTo(null);
        frameRegistro.setVisible(true);

        // 3. Crear y mostrar la ventana de SIMULACIÓN con su controlador
        VentanaSimulacion vistaSimulacion = new VentanaSimulacion();
        new ControllerSimulacion(vistaSimulacion, dao);
        JFrame frameSimulacion = new JFrame("Simular Viaje");
        frameSimulacion.setContentPane(vistaSimulacion.getPanelPrincipal());
        // NO cerramos la aplicación al cerrar esta ventana, para poder seguir usando la otra.
        frameSimulacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameSimulacion.pack();
        frameSimulacion.setLocation(frameRegistro.getX() + 50, frameRegistro.getY() + 50);
        frameSimulacion.setVisible(true);
    }
}