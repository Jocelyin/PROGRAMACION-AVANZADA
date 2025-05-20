package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CambiarPrecioVista extends JFrame {

    private JTextField txtCodigoProducto;
    private JTextField txtNuevoPrecio;
    private JButton btnCambiarPrecio;

    public static final String COMANDO_CAMBIAR_PRECIO = "cambiar_precio";

    public CambiarPrecioVista() {
        setTitle("Cambiar Precio de Producto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblCodigoProducto = new JLabel("Código del Producto:");
        txtCodigoProducto = new JTextField(20);
        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio de Venta:");
        txtNuevoPrecio = new JTextField(20);
        btnCambiarPrecio = new JButton("Cambiar Precio");
        btnCambiarPrecio.setActionCommand(COMANDO_CAMBIAR_PRECIO);

        add(lblCodigoProducto);
        add(txtCodigoProducto);
        add(lblNuevoPrecio);
        add(txtNuevoPrecio);
        add(new JLabel()); // Espacio en blanco
        add(btnCambiarPrecio);

        pack();
        setLocationRelativeTo(null);
    }

    public String getTextoCodigoProducto() {
        return txtCodigoProducto.getText();
    }

    public double getNuevoPrecio() {
        try {
            return Double.parseDouble(txtNuevoPrecio.getText());
        } catch (NumberFormatException e) {
            return -1; // Indica un error de formato
        }
    }

    public void limpiarCampos() {
        txtCodigoProducto.setText("");
        txtNuevoPrecio.setText("");
    }

    public void setActionListener(ActionListener listener) {
        btnCambiarPrecio.addActionListener(listener);
    }

    // Método main para probar la vista (opcional)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CambiarPrecioVista vista = new CambiarPrecioVista();
            vista.setVisible(true);
        });
    }
}