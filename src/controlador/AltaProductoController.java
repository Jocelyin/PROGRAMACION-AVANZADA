package controlador;

import modelo.Producto;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import vista.AltaProductoVista; // Aún no creada

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AltaProductoController implements ActionListener {

    private AltaProductoVista vista;
    private ProductoDAO productoDAO;

    public AltaProductoController(AltaProductoVista vista) {
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

        if (comando.equals(AltaProductoVista.COMANDO_GUARDAR)) {
            guardarNuevoProducto();
        }

    }

    private void guardarNuevoProducto() {
        String codigo = vista.getTextoCodigo();
        String nombre = vista.getTextoNombre();
        String precioTexto = vista.getTextoPrecio();
        String stockTexto = vista.getTextoStock();
        String limiteStockTexto = vista.getTextoLimiteStock();

        
        if (codigo.isEmpty() || nombre.isEmpty() || precioTexto.isEmpty() || stockTexto.isEmpty() || limiteStockTexto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double precio = Double.parseDouble(precioTexto);
            int stock = Integer.parseInt(stockTexto);
            int limiteStock = Integer.parseInt(limiteStockTexto);

            Producto nuevoProducto = new Producto(codigo, nombre, precio, stock, limiteStock);

            if (productoDAO.agregarProducto(nuevoProducto)) {
                JOptionPane.showMessageDialog(vista, "Producto guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                vista.limpiarCampos(); // Método a implementar en la vista
            } else {
                JOptionPane.showMessageDialog(vista, "Error al guardar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Error en el formato de precio, stock o límite de stock.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
