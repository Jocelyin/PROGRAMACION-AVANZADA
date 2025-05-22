package main;

import vista.LoginVista;
import controlador.LoginController;
import javax.swing.SwingUtilities;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear e iniciar la ventana de inicio de sesión
            LoginVista loginVista = new LoginVista();
            new LoginController(loginVista);
        });
    }
}