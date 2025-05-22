package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReducirStockVista extends JFrame {

    private JTextField txtCodigoProducto;
    private JTextField txtCantidadReducir;
    private JButton btnReducirStock;

    public static final String COMANDO_REDUCIR_STOCK = "reducir_stock";

    public ReducirStockVista() {
        setTitle("Reducir Stock");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblCodigoProducto = new JLabel("Código del Producto:");
        txtCodigoProducto = new JTextField(20);
        JLabel lblCantidadReducir = new JLabel("Cantidad a Reducir:");
        txtCantidadReducir = new JTextField(20);
        btnReducirStock = new JButton("Reducir Stock");
        btnReducirStock.setActionCommand(COMANDO_REDUCIR_STOCK);

        add(lblCodigoProducto);
        add(txtCodigoProducto);
        add(lblCantidadReducir);
        add(txtCantidadReducir);
        add(new JLabel()); 
        add(btnReducirStock);

        pack();
        setLocationRelativeTo(null);
    }

    public String getTextoCodigoProducto() {
        return txtCodigoProducto.getText();
    }

    public int getCantidadReducir() {
        try {
            return Integer.parseInt(txtCantidadReducir.getText());
        } catch (NumberFormatException e) {
            return -1; // Indica un error de formato
        }
    }

    public void limpiarCampos() {
        txtCodigoProducto.setText("");
        txtCantidadReducir.setText("");
    }

    public void setActionListener(ActionListener listener) {
        btnReducirStock.addActionListener(listener);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReducirStockVista vista = new ReducirStockVista();
            vista.setVisible(true);
        });
    }
}
