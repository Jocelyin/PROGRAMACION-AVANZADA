package controlador;

import vista.LoginVista;
import vista.MenuPrincipalVista;
import vista.AlmacenMenuView; // Import necesario
import vista.GenerarVentaVista; // Import necesario
import controlador.AlmacenMenuController; // Import necesario
import controlador.GenerarVentaController; // Import necesario
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;

public class LoginController implements ActionListener {

    private LoginVista vista;
    private MenuPrincipalVista menuPrincipalVista;
    private MenuPrincipalController menuPrincipalController;
    private static final Map<String, String> USUARIOS = new HashMap<>();

    static {
        USUARIOS.put("jocelyin", "123");
        USUARIOS.put("mateo", "456");
        USUARIOS.put("saldierna", "789");
    }

    public LoginController(LoginVista vista) {
        this.vista = vista;
        this.vista.getBtnIniciarSesion().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnIniciarSesion()) {
            String usuario = vista.getTxtUsuario().getText();
            char[] contrasenaChars = vista.getTxtContrasena().getPassword();
            String contrasena = new String(contrasenaChars);

            if (verificarCredenciales(usuario, contrasena)) {
                // Inicio de sesión exitoso
                vista.dispose();

                SwingUtilities.invokeLater(() -> {
                    
                    menuPrincipalVista = new MenuPrincipalVista();
                    menuPrincipalController = new MenuPrincipalController(menuPrincipalVista);
                    menuPrincipalVista.setControlador(menuPrincipalController);

                    // Obtener las instancias de las vistas del menú principal
                    AlmacenMenuView almacenMenuView = menuPrincipalVista.getAlmacenMenuView();
                    GenerarVentaVista generarVentaVista = menuPrincipalVista.getGenerarVentaVista();

                    // Crear y asociar los controladores específicos de cada vista
                    new AlmacenMenuController(almacenMenuView);
                    new GenerarVentaController(generarVentaVista);

                    menuPrincipalVista.setVisible(true); // Mostrar la ventana principal después de configurar todo
                });

            } else {
                // Credenciales incorrectas
                vista.mostrarMensajeError("Usuario o contraseña incorrectos");
                vista.limpiarCampos();
            }
        }
    }

    private boolean verificarCredenciales(String usuario, String contrasena) {
        return USUARIOS.containsKey(usuario) && USUARIOS.get(usuario).equals(contrasena);
    }
}