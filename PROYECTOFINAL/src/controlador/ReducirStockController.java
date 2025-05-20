package controlador;

import modelo.Producto;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import vista.ReducirStockVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ReducirStockController implements ActionListener {

    private ReducirStockVista vista;
    private ProductoDAO productoDAO;

    public ReducirStockController(ReducirStockVista vista) {
        this.vista = vista;
        this.productoDAO = new ProductoDAOImpl();
        this.vista.setActionListener(this);
    }

    public void iniciarVista() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals(ReducirStockVista.COMANDO_REDUCIR_STOCK)) {
            reducirStockProducto();
        }
        // Podríamos tener un comando para cancelar o limpiar la vista
    }

    private void reducirStockProducto() {
        String codigoProducto = vista.getTextoCodigoProducto();
        int cantidadReducir = vista.getCantidadReducir();

        if (codigoProducto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El código del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidadReducir <= 0) {
            JOptionPane.showMessageDialog(vista, "La cantidad a reducir debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Producto productoExistente = productoDAO.obtenerProducto(codigoProducto);

        if (productoExistente == null) {
            JOptionPane.showMessageDialog(vista, "No se encontró ningún producto con el código: " + codigoProducto, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidadReducir > productoExistente.getStock()) {
            JOptionPane.showMessageDialog(vista, "No hay suficiente stock para reducir " + cantidadReducir + " unidades del producto " + codigoProducto + ". Stock actual: " + productoExistente.getStock(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nuevoStock = productoExistente.getStock() - cantidadReducir;
        if (productoDAO.actualizarStock(codigoProducto, nuevoStock)) {
            JOptionPane.showMessageDialog(vista, "Stock del producto " + codigoProducto + " reducido a " + nuevoStock + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            vista.limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al reducir el stock del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
