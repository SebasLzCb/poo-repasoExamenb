package PrimerEjercicio;

import PrimerEjercicio.controllers.ControllerRegistro;
import PrimerEjercicio.DAO.AsignaturaDAO;
import PrimerEjercicio.DAO.DAOImpl.AsignaturaDAOImpl;
import PrimerEjercicio.views.VentanaRegistro;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // 1. Crear los objetos principales
        JFrame frame = new JFrame("Registro Académico");
        VentanaRegistro vista = new VentanaRegistro(); // La vista creada por el diseñador
        AsignaturaDAO dao = new AsignaturaDAOImpl();  // El DAO que ya teníamos

        // 2. Crear el controlador y pasarle la vista y el DAO
        new ControllerRegistro(vista, dao);

        // 3. Configurar la ventana principal (JFrame)
        // Obtenemos el panel diseñado y lo ponemos dentro del JFrame
        frame.setContentPane(vista.getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta el tamaño de la ventana al contenido
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // ¡Hacer visible la ventana!
    }
}