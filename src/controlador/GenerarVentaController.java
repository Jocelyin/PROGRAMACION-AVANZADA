package controlador; 

import dao.ProductoDAO; 
import dao.ProductoDAOImpl; 
import modelo.Producto; 
import vista.GenerarVentaVista; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.table.DefaultTableModel; 


import modelo.DetalleVenta; 
import modelo.Venta; 
import net.sf.jasperreports.engine.JREmptyDataSource; 
import net.sf.jasperreports.engine.JRException; 
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource; 
import net.sf.jasperreports.view.JasperViewer; 
import java.io.InputStream; 
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
import java.time.LocalDateTime; // Para la fecha/hora de la venta 
import java.time.format.DateTimeFormatter; // Para formatear la fecha/hora 

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
            case "agregar_cantidad": // Este comando viene del diálogo de cantidad 
                agregarProductoAlCarrito(); 
                break; 
            case GenerarVentaVista.COMANDO_ELIMINAR_DEL_CARRITO: 
                eliminarProductoDelCarrito(); 
                break; 
            case GenerarVentaVista.COMANDO_FINALIZAR_VENTA: 
                if (vistaGenerarVenta.getModeloCarrito().getRowCount() > 0) { 
                    generarTicketConJasper(); 
                } else { 
                    vistaGenerarVenta.mostrarMensajeAdvertencia("El carrito está vacío. No se puede finalizar la venta."); 
                } 
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
                // Si el producto se encuentra, automáticamente mostramos el diálogo de cantidad 
                vistaGenerarVenta.mostrarDialogoCantidad(productoEncontrado, this); 
            } else { 
                vistaGenerarVenta.mostrarMensajeError("Producto no encontrado."); 
                vistaGenerarVenta.setProductoEncontrado(null); // Limpia el producto encontrado 
            } 
        } else { 
            vistaGenerarVenta.mostrarMensajeAdvertencia("Ingrese el código del producto."); 
        } 
    } 

    private void mostrarDialogoCantidad() { 
        if (vistaGenerarVenta.getProductoEncontrado() != null) { 
            vistaGenerarVenta.mostrarDialogoCantidad(vistaGenerarVenta.getProductoEncontrado(), this); 
        } else { 
            vistaGenerarVenta.mostrarMensajeAdvertencia("Debe buscar un producto primero."); 
        } 
    } 

    private void agregarProductoAlCarrito() { 
        if (vistaGenerarVenta.getProductoEncontrado() != null) { 
            int cantidad = vistaGenerarVenta.getCantidadIngresada(); 
            // Verificar si la cantidad es válida y si hay suficiente stock 
            if (cantidad > 0 && vistaGenerarVenta.getProductoEncontrado().getStock() >= cantidad) { 
                vistaGenerarVenta.agregarProductoAlCarrito( 
                    vistaGenerarVenta.getProductoEncontrado().getCodigoProducto(), 
                    vistaGenerarVenta.getProductoEncontrado().getNombre(), 
                    cantidad, 
                    vistaGenerarVenta.getProductoEncontrado().getPrecioVenta() 
                ); 
                 

                actualizarTotal(); 
                vistaGenerarVenta.getDialogoCantidad().dispose(); // Cerrar el diálogo después de agregar 
                vistaGenerarVenta.setProductoEncontrado(null); // Resetear el producto encontrado para la próxima búsqueda 
            } else if (cantidad <= 0) { 
                vistaGenerarVenta.mostrarMensajeError("Ingrese una cantidad válida (mayor que cero)."); 
            } else { 
                vistaGenerarVenta.mostrarMensajeError("No hay suficiente stock para la cantidad solicitada."); 
            } 
        } else { 
            vistaGenerarVenta.mostrarMensajeAdvertencia("No se ha buscado ningún producto para agregar."); 
        } 
    } 

    private void eliminarProductoDelCarrito() { 
        int filaSeleccionada = vistaGenerarVenta.getTblCarrito().getSelectedRow(); 
        if (filaSeleccionada >= 0) { 
            vistaGenerarVenta.eliminarProductoDelCarrito(filaSeleccionada); 
            actualizarTotal(); 
            vistaGenerarVenta.mostrarMensajeExito("Producto eliminado del carrito."); 
        } else { 
            vistaGenerarVenta.mostrarMensajeAdvertencia("Seleccione un producto para eliminar del carrito."); 
        } 
    } 

    private void actualizarTotal() { 
        DefaultTableModel modelo = vistaGenerarVenta.getModeloCarrito(); 
        double total = 0; 
         
        for (int i = 0; i < modelo.getRowCount(); i++) { 
            total += (double) modelo.getValueAt(i, 4); 
        } 
        vistaGenerarVenta.actualizarTotal(total); 
    } 

     
    private void generarTicketConJasper() { 
        // Datos de la Venta 
        Venta ventaActual = new Venta(); 

        
        ventaActual.setIdVenta((int)(System.currentTimeMillis() % 1000000)); 
        ventaActual.setFecha(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); 
        ventaActual.setTotal(vistaGenerarVenta.getTotal()); 

        // Lista de Detalles de Venta 
        List<DetalleVenta> detallesVenta = new ArrayList<>(); 
        DefaultTableModel modeloCarrito = vistaGenerarVenta.getModeloCarrito(); 

        for (int i = 0; i < modeloCarrito.getRowCount(); i++) { 
            String codigoProducto = (String) modeloCarrito.getValueAt(i, 0); 
            String nombreProducto = (String) modeloCarrito.getValueAt(i, 1); 
            int cantidad = (int) modeloCarrito.getValueAt(i, 2); 
            double precioUnitario = (double) modeloCarrito.getValueAt(i, 3); 
            double precioTotalProducto = (double) modeloCarrito.getValueAt(i, 4); // Subtotal de la línea 

            DetalleVenta detalle = new DetalleVenta( 
                (i + 1),  
                ventaActual.getIdVenta(), 
                codigoProducto, 
                nombreProducto, 
                cantidad, 
                precioUnitario, 
                precioTotalProducto 
            ); 
            detallesVenta.add(detalle); 
        } 

        
        InputStream reportStream = null;  

        try { 
            // Carga la plantilla .jasper desde los recursos del classpath 
            reportStream = getClass().getResourceAsStream("/reports/TicketVenta.jasper"); 

            if (reportStream == null) { 
                vistaGenerarVenta.mostrarMensajeError("Error al cargar la plantilla del ticket. Asegúrate de que 'ticket_venta.jasper' esté en la ruta '/reports/' dentro de tu proyecto."); 
                System.err.println("Error: No se encontró el archivo ticket_venta.jasper en /reports/. Verifica la ruta del classpath o si el archivo existe."); 
                return; // Salimos del método si no se encuentra el reporte 
            } 

            
            Map<String, Object> parameters = new HashMap<>(); 
            parameters.put("numeroTicket", ventaActual.getIdVenta()); 
            parameters.put("fechaVenta", ventaActual.getFecha()); 
            parameters.put("totalVenta", ventaActual.getTotal()); 
            parameters.put("nombreTienda", "Mi Tiendita");  

             
            JRBeanCollectionDataSource itemsDataSource = new JRBeanCollectionDataSource(detallesVenta); 
            parameters.put("itemsDataSource", itemsDataSource); 

            
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, new JREmptyDataSource()); 

            // Mostrar el reporte en un visor 
            JasperViewer.viewReport(jasperPrint, false); // false para que no cierre la aplicación al cerrar el visor 

            // Después de generar el ticket con éxito: 
            vistaGenerarVenta.limpiarCarrito(); // Vacía el carrito en la interfaz 
            vistaGenerarVenta.actualizarTotal(0.0); // Resetea el total 
            vistaGenerarVenta.mostrarMensajeExito("Venta finalizada y ticket generado con éxito."); 

        } catch (JRException e) { 
            
            e.printStackTrace(); // Imprime el stack trace para depuración 
            vistaGenerarVenta.mostrarMensajeError("Ocurrió un error al generar el ticket con JasperReports: " + e.getMessage()); 
        } catch (Exception e) { 
             
            e.printStackTrace(); 
            vistaGenerarVenta.mostrarMensajeError("Ocurrió un error inesperado al generar el ticket: " + e.getMessage()); 
        } finally { 
             
            if (reportStream != null) { 
                try { 
                    reportStream.close(); 
                } catch (IOException ioException) { 
                    System.err.println("Error al cerrar el InputStream del reporte: " + ioException.getMessage()); 
                    ioException.printStackTrace(); 
                } 
            } 
        } 
    } }
