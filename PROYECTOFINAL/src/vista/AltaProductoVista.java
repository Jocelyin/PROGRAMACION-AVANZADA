package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AltaProductoVista extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JTextField txtLimiteStock;
    private JButton btnGuardar;

    public static final String COMANDO_GUARDAR = "guardar";

    public AltaProductoVista() {
        setTitle("Alta de Producto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setLayout(new GridLayout(6, 2, 5, 5)); // Layout de 6 filas, 2 columnas, con espacios

        JLabel lblCodigo = new JLabel("Código:");
        txtCodigo = new JTextField(20);
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        JLabel lblPrecio = new JLabel("Precio de Venta:");
        txtPrecio = new JTextField(20);
        JLabel lblStock = new JLabel("Stock Inicial:");
        txtStock = new JTextField(20);
        JLabel lblLimiteStock = new JLabel("Límite de Stock:");
        txtLimiteStock = new JTextField(20);
        btnGuardar = new JButton("Guardar Producto");
        btnGuardar.setActionCommand(COMANDO_GUARDAR);

        add(lblCodigo);
        add(txtCodigo);
        add(lblNombre);
        add(txtNombre);
        add(lblPrecio);
        add(txtPrecio);
        add(lblStock);
        add(txtStock);
        add(lblLimiteStock);
        add(txtLimiteStock);
        add(new JLabel()); // Espacio en blanco
        add(btnGuardar);

        pack(); // Ajusta el tamaño de la ventana a sus componentes
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    // Métodos para obtener el texto de los campos
    public String getTextoCodigo() {
        return txtCodigo.getText();
    }

    public String getTextoNombre() {
        return txtNombre.getText();
    }

    public String getTextoPrecio() {
        return txtPrecio.getText();
    }

    public String getTextoStock() {
        return txtStock.getText();
    }

    public String getTextoLimiteStock() {
        return txtLimiteStock.getText();
    }

    // Método para limpiar los campos después de guardar
    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtLimiteStock.setText("");
    }

    // Método para registrar el ActionListener del controlador
    public void setActionListener(ActionListener listener) {
        btnGuardar.addActionListener(listener);
    }

    // Método main para probar la vista (opcional)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AltaProductoVista vista = new AltaProductoVista();
            vista.setVisible(true);
        });
    }
}