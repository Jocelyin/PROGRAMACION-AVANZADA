package vista;

import javax.swing.*;
import java.awt.*;

public class LoginVista extends JFrame {

    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JLabel lblContrasena;
    private JPasswordField txtContrasena;
    private JButton btnIniciarSesion;
    private JLabel lblMensajeError;

    public LoginVista() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new GridLayout(2, 2, 5, 5));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(15, 30, 10, 30));

        lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField(15);
        lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField(15);

        panelCentral.add(lblUsuario);
        panelCentral.add(txtUsuario);
        panelCentral.add(lblContrasena);
        panelCentral.add(txtContrasena);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnIniciarSesion = new JButton("Iniciar Sesión");
        lblMensajeError = new JLabel("");
        lblMensajeError.setForeground(Color.RED);

        panelBotones.add(btnIniciarSesion);
        panelBotones.add(lblMensajeError);

        lblTitulo = new JLabel("Inicio de Sesión");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 15, 0));

        add(lblTitulo, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtContrasena() {
        return txtContrasena;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public JLabel getLblMensajeError() {
        return lblMensajeError;
    }

    public void mostrarMensajeError(String mensaje) {
        lblMensajeError.setText(mensaje);
    }

    public void limpiarCampos() {
        txtUsuario.setText("");
        txtContrasena.setText("");
        lblMensajeError.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginVista());
    }
}