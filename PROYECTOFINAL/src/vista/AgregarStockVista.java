package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AgregarStockVista extends JFrame {

    private JTextField txtCodigoProducto;
    private JTextField txtCantidadAgregar;
    private JButton btnAgregarStock;

    public static final String COMANDO_AGREGAR_STOCK = "agregar_stock";

    public AgregarStockVista() {
        setTitle("Agregar Stock");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblCodigoProducto = new JLabel("Código del Producto:");
        txtCodigoProducto = new JTextField(20);
        JLabel lblCantidadAgregar = new JLabel("Cantidad a Agregar:");
        txtCantidadAgregar = new JTextField(20);
        btnAgregarStock = new JButton("Agregar Stock");
        btnAgregarStock.setActionCommand(COMANDO_AGREGAR_STOCK);

        add(lblCodigoProducto);
        add(txtCodigoProducto);
        add(lblCantidadAgregar);
        add(txtCantidadAgregar);
        add(new JLabel()); // Espacio en blanco
        add(btnAgregarStock);

        pack();
        setLocationRelativeTo(null);
    }

    public String getTextoCodigoProducto() {
        return txtCodigoProducto.getText();
    }

    public int getCantidadAgregar() {
        try {
            return Integer.parseInt(txtCantidadAgregar.getText());
        } catch (NumberFormatException e) {
            return -1; // Indica un error de formato
        }
    }

    public void limpiarCampos() {
        txtCodigoProducto.setText("");
        txtCantidadAgregar.setText("");
    }

    public void setActionListener(ActionListener listener) {
        btnAgregarStock.addActionListener(listener);
    }

    // Método main para probar la vista (opcional)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AgregarStockVista vista = new AgregarStockVista();
            vista.setVisible(true);
        });
    }
}
