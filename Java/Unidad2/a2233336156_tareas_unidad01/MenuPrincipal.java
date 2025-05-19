package a2233336156_tareas_unidad01;

import javax.swing.SwingUtilities;

public class MenuPrincipal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaMenu vistaMenu = new VistaMenu();
            new ControladorMenu(vistaMenu);
        });
    }
}
