package controlador;

import modelo.Producto;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import vista.AgregarStockVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AgregarStockController implements ActionListener {

    private AgregarStockVista vista;
    private ProductoDAO productoDAO;

    public AgregarStockController(AgregarStockVista vista) {
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

        if (comando.equals(AgregarStockVista.COMANDO_AGREGAR_STOCK)) {
            agregarStockProducto();
        }
        // Podríamos tener un comando para cancelar o limpiar la vista
    }

    private void agregarStockProducto() {
        String codigoProducto = vista.getTextoCodigoProducto();
        int cantidadAgregar = vista.getCantidadAgregar();

        if (codigoProducto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El código del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidadAgregar <= 0) {
            JOptionPane.showMessageDialog(vista, "La cantidad a agregar debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Producto productoExistente = productoDAO.obtenerProducto(codigoProducto);

        if (productoExistente == null) {
            JOptionPane.showMessageDialog(vista, "No se encontró ningún producto con el código: " + codigoProducto, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nuevoStock = productoExistente.getStock() + cantidadAgregar;
        if (productoDAO.actualizarStock(codigoProducto, nuevoStock)) {
            JOptionPane.showMessageDialog(vista, "Stock del producto " + codigoProducto + " actualizado a " + nuevoStock + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            vista.limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar el stock del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}