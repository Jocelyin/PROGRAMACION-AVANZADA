package a2233336156_tareas_unidad01;



import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;



public class VistaProducto extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnAgregar, btnEliminar, btnModificar, btnSalir;
    private Lista<CProducto1> listaProductos;

    public VistaProducto() {
        setTitle("Gestión de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        listaProductos = new Lista<>();
        modelo = new DefaultTableModel(new String[]{"ID", "Producto", "Precio", "Cantidad"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnModificar = new JButton("Modificar");
        btnSalir = new JButton("Salir");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public Lista<CProducto1> getListaProductos() {
        return listaProductos;
    }
}
