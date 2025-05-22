package controlador;

import modelo.Producto;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import vista.CambiarPrecioVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CambiarPrecioController implements ActionListener {

    private CambiarPrecioVista vista;
    private ProductoDAO productoDAO;

    public CambiarPrecioController(CambiarPrecioVista vista) {
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

        if (comando.equals(CambiarPrecioVista.COMANDO_CAMBIAR_PRECIO)) {
            cambiarPrecioProducto();
        }
        // Podríamos tener un comando para cancelar o limpiar la vista
    }

    private void cambiarPrecioProducto() {
        String codigoProducto = vista.getTextoCodigoProducto();
        double nuevoPrecio = vista.getNuevoPrecio();

        if (codigoProducto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El código del producto es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nuevoPrecio < 0) {
            JOptionPane.showMessageDialog(vista, "El nuevo precio debe ser mayor o igual a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Producto productoExistente = productoDAO.obtenerProducto(codigoProducto);

        if (productoExistente == null) {
            JOptionPane.showMessageDialog(vista, "No se encontró ningún producto con el código: " + codigoProducto, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (productoDAO.actualizarPrecioVenta(codigoProducto, nuevoPrecio)) {
            JOptionPane.showMessageDialog(vista, "Precio del producto " + codigoProducto + " actualizado a " + nuevoPrecio + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            vista.limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar el precio del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}