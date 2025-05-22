package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import modelo.Producto;

public class GenerarVentaVista extends JPanel {

    private JDialog dialogoCantidad;
    private JTextField txtCantidad;
    private JButton btnAgregarCantidad;
    private Producto productoEncontrado;

    private JTextField txtBuscarProducto;
    private JButton btnBuscarProducto;
    private JTable tblCarrito;
    private DefaultTableModel modeloCarrito;
    private JLabel lblTotal; // Este label muestra el total
    private JButton btnAgregarAlCarrito;
    private JButton btnEliminarDelCarrito;
    private JButton btnFinalizarVenta;

    public static final String COMANDO_BUSCAR_PRODUCTO = "buscar_producto";
    public static final String COMANDO_AGREGAR_AL_CARRITO = "agregar_al_carrito";
    public static final String COMANDO_ELIMINAR_DEL_CARRITO = "eliminar_del_carrito";
    public static final String COMANDO_FINALIZAR_VENTA = "finalizar_venta";

    public GenerarVentaVista() {
        setLayout(new BorderLayout(5, 5));

        // Panel para la búsqueda de productos
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBuscarProducto = new JTextField(20);
        btnBuscarProducto = new JButton("Buscar");
        btnBuscarProducto.setActionCommand(COMANDO_BUSCAR_PRODUCTO);
        panelBusqueda.add(new JLabel("Buscar Producto:"));
        panelBusqueda.add(txtBuscarProducto);
        panelBusqueda.add(btnBuscarProducto);
        add(panelBusqueda, BorderLayout.NORTH);

        
        modeloCarrito = new DefaultTableModel(new Object[]{"Código", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"}, 0);
        tblCarrito = new JTable(modeloCarrito);
        JScrollPane scrollPane = new JScrollPane(tblCarrito);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para el total y los botones de acción
        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotal = new JLabel("Total: $0.00");
        btnAgregarAlCarrito = new JButton("Agregar al Carrito");
        btnAgregarAlCarrito.setActionCommand(COMANDO_AGREGAR_AL_CARRITO);
        btnEliminarDelCarrito = new JButton("Eliminar del Carrito");
        btnEliminarDelCarrito.setActionCommand(COMANDO_ELIMINAR_DEL_CARRITO);
        btnFinalizarVenta = new JButton("Finalizar Venta");
        btnFinalizarVenta.setActionCommand(COMANDO_FINALIZAR_VENTA);

        panelAcciones.add(lblTotal);
        panelAcciones.add(btnAgregarAlCarrito);
        panelAcciones.add(btnEliminarDelCarrito);
        panelAcciones.add(btnFinalizarVenta);
        add(panelAcciones, BorderLayout.SOUTH);
    }



    public String getTextoBuscarProducto() {
        return txtBuscarProducto.getText();
    }

    public DefaultTableModel getModeloCarrito() {
        return modeloCarrito;
    }

    public JTable getTblCarrito() {
        return tblCarrito;
    }

    public void actualizarTotal(double total) {
        lblTotal.setText(String.format("Total: $%.2f", total));
    }
    
    
    public double getTotal() {
        // Parsear el texto del JLabel para obtener el valor numérico
        String totalText = lblTotal.getText().replace("Total: $", "");
        try {
            return Double.parseDouble(totalText);
        } catch (NumberFormatException e) {
            return 0.0; 
        }
    }

    public void agregarProductoAlCarrito(String codigo, String nombre, int cantidad, double precioUnitario) {
        modeloCarrito.addRow(new Object[]{codigo, nombre, cantidad, precioUnitario, cantidad * precioUnitario});
    }

    public void eliminarProductoDelCarrito(int filaSeleccionada) {
        if (filaSeleccionada >= 0) {
            modeloCarrito.removeRow(filaSeleccionada);
        }
    }

    public void limpiarCarrito() {
        modeloCarrito.setRowCount(0);
        actualizarTotal(0.00);
    }

    public void mostrarDialogoCantidad(Producto producto, ActionListener listener) {
        productoEncontrado = producto;
        if (dialogoCantidad == null) {
           
            Frame owner = (Frame) SwingUtilities.getWindowAncestor(this);
            dialogoCantidad = new JDialog(owner, "Ingresar Cantidad", true);
            dialogoCantidad.setLayout(new FlowLayout());
            txtCantidad = new JTextField(5);
            btnAgregarCantidad = new JButton("Agregar");
            btnAgregarCantidad.setActionCommand("agregar_cantidad");
            dialogoCantidad.add(new JLabel("Cantidad:"));
            dialogoCantidad.add(txtCantidad);
            dialogoCantidad.add(btnAgregarCantidad);
            dialogoCantidad.pack();
            dialogoCantidad.setLocationRelativeTo(owner); // Centrar con respecto a la ventana principal

            btnAgregarCantidad.addActionListener(listener);
        } else {
            // Resetear el campo de cantidad si el diálogo ya existe
            txtCantidad.setText("1");
            dialogoCantidad.setLocationRelativeTo((Frame) SwingUtilities.getWindowAncestor(this)); // Re-centrar
        }
        dialogoCantidad.setVisible(true);
    }

    public int getCantidadIngresada() {
        try {
            return Integer.parseInt(txtCantidad.getText());
        } catch (NumberFormatException e) {
           
            JOptionPane.showMessageDialog(this, "Cantidad inválida. Ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public Producto getProductoEncontrado() {
        return productoEncontrado;
    }

    public void setProductoEncontrado(Producto productoEncontrado) {
        this.productoEncontrado = productoEncontrado;
    }

    public JDialog getDialogoCantidad() {
        return dialogoCantidad;
    }

    public JTextField getTxtBuscarProducto() {
        return txtBuscarProducto;
    }

    public JButton getBtnAgregarAlCarrito() {
        return btnAgregarAlCarrito;
    }

    public JButton getBtnBuscarProducto() {
        return btnBuscarProducto;
    }

    public JButton getBtnEliminarDelCarrito() {
        return btnEliminarDelCarrito;
    }

    public JButton getBtnFinalizarVenta() {
        return btnFinalizarVenta;
    }
    
   
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}