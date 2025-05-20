package controlador;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import modelo.Producto;
import vista.GenerarVentaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GenerarVentaController implements ActionListener {

    private GenerarVentaVista vistaGenerarVenta;
    private ProductoDAO productoDAO;
    private Producto productoEncontrado;

    public GenerarVentaController(GenerarVentaVista vistaGenerarVenta) {
        this.vistaGenerarVenta = vistaGenerarVenta;
        this.vistaGenerarVenta.getBtnBuscarProducto().addActionListener(this);
        this.vistaGenerarVenta.getBtnAgregarAlCarrito().addActionListener(this);
        this.vistaGenerarVenta.getBtnEliminarDelCarrito().addActionListener(this);
        this.vistaGenerarVenta.getBtnFinalizarVenta().addActionListener(this);
        this.productoDAO = new ProductoDAOImpl();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case GenerarVentaVista.COMANDO_BUSCAR_PRODUCTO:
                buscarProducto();
                break;
            case GenerarVentaVista.COMANDO_AGREGAR_AL_CARRITO:
                mostrarDialogoCantidad();
                break;
            case "agregar_cantidad": // Comando del botón del diálogo de cantidad
                agregarProductoAlCarrito();
                break;
            case GenerarVentaVista.COMANDO_ELIMINAR_DEL_CARRITO:
                eliminarProductoDelCarrito();
                break;
            case GenerarVentaVista.COMANDO_FINALIZAR_VENTA:
                generarTicket(); // Llamar al método para generar el ticket
                vistaGenerarVenta.limpiarCarrito();
                break;
            default:
                break;
        }
    }

    private void buscarProducto() {
        String codigoProducto = vistaGenerarVenta.getTextoBuscarProducto();
        if (!codigoProducto.isEmpty()) {
            productoEncontrado = productoDAO.obtenerProducto(codigoProducto);
            if (productoEncontrado != null) {
                vistaGenerarVenta.setProductoEncontrado(productoEncontrado);
                vistaGenerarVenta.mostrarDialogoCantidad(productoEncontrado, this); // Pasar el listener al diálogo
            } else {
                JOptionPane.showMessageDialog(vistaGenerarVenta, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                vistaGenerarVenta.setProductoEncontrado(null);
            }
        } else {
            JOptionPane.showMessageDialog(vistaGenerarVenta, "Ingrese el código del producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarDialogoCantidad() {
        if (vistaGenerarVenta.getProductoEncontrado() != null) {
            vistaGenerarVenta.mostrarDialogoCantidad(vistaGenerarVenta.getProductoEncontrado(), this);
        } else {
            JOptionPane.showMessageDialog(vistaGenerarVenta, "Debe buscar un producto primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void agregarProductoAlCarrito() {
        if (vistaGenerarVenta.getProductoEncontrado() != null) {
            int cantidad = vistaGenerarVenta.getCantidadIngresada();
            if (cantidad > 0 && vistaGenerarVenta.getProductoEncontrado().getStock() >= cantidad) {
                vistaGenerarVenta.agregarProductoAlCarrito(
                        vistaGenerarVenta.getProductoEncontrado().getCodigoProducto(),
                        vistaGenerarVenta.getProductoEncontrado().getNombre(),
                        cantidad,
                        vistaGenerarVenta.getProductoEncontrado().getPrecioVenta()
                );
                actualizarTotal();
                vistaGenerarVenta.getDialogoCantidad().dispose(); // Cerrar el diálogo después de agregar
                vistaGenerarVenta.setProductoEncontrado(null); // Resetear el producto encontrado
            } else if (cantidad <= 0) {
                JOptionPane.showMessageDialog(vistaGenerarVenta, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vistaGenerarVenta, "No hay suficiente stock.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vistaGenerarVenta, "No se ha buscado ningún producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarProductoDelCarrito() {
        int filaSeleccionada = vistaGenerarVenta.getTblCarrito().getSelectedRow();
        if (filaSeleccionada >= 0) {
            vistaGenerarVenta.eliminarProductoDelCarrito(filaSeleccionada);
            actualizarTotal();
        } else {
            JOptionPane.showMessageDialog(vistaGenerarVenta, "Seleccione un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void finalizarVenta() {
        if (vistaGenerarVenta.getModeloCarrito().getRowCount() > 0) {
            // Aquí iría la lógica para procesar la venta (actualizar stock, guardar en la base de datos, etc.)
            JOptionPane.showMessageDialog(vistaGenerarVenta, "Venta finalizada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            vistaGenerarVenta.limpiarCarrito();
        } else {
            JOptionPane.showMessageDialog(vistaGenerarVenta, "El carrito está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizarTotal() {
        DefaultTableModel modelo = vistaGenerarVenta.getModeloCarrito();
        double total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total += (double) modelo.getValueAt(i, 4); // Precio Total está en la columna 4
        }
        vistaGenerarVenta.actualizarTotal(total);
    }
    
    private void generarTicket() {
        DefaultTableModel modelo = vistaGenerarVenta.getModeloCarrito();
        if (modelo.getRowCount() > 0) {
            StringBuilder ticket = new StringBuilder();

            // Encabezado del ticket
            ticket.append("=====================\n");
            ticket.append("     Mi Tiendita     \n");
            ticket.append("=====================\n");
            ticket.append("Fecha: ").append(java.time.LocalDateTime.now()).append("\n");
            ticket.append("---------------------\n");
            ticket.append("Cant. | Producto | Precio Unit. | Total\n");
            ticket.append("---------------------\n");

            double totalVenta = 0;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                int cantidad = (int) modelo.getValueAt(i, 2);
                String nombreProducto = (String) modelo.getValueAt(i, 1);
                double precioUnitario = (double) modelo.getValueAt(i, 3);
                double precioTotalProducto = (double) modelo.getValueAt(i, 4);
                totalVenta += precioTotalProducto;

                ticket.append(String.format("%-5d | %-10s | %-12.2f | %.2f\n",
                        cantidad, nombreProducto, precioUnitario, precioTotalProducto));
            }

            ticket.append("---------------------\n");
            ticket.append(String.format("TOTAL: %.2f\n", totalVenta));
            ticket.append("=====================\n");
            ticket.append("¡Gracias por su compra!\n");

            // Mostrar el ticket en un cuadro de diálogo
            JOptionPane.showMessageDialog(vistaGenerarVenta, ticket.toString(), "Ticket de Venta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vistaGenerarVenta, "El carrito está vacío. No se puede generar el ticket.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}