package controlador;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import modelo.Producto;
import vista.AlmacenMenuView;
import vista.AltaProductoVista;

import vista.AgregarStockVista;
import vista.ReducirStockVista;


import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AlmacenMenuController implements ActionListener {

    private AlmacenMenuView vistaAlmacenMenu;
    private AltaProductoVista vistaAltaProducto;
    private AltaProductoController controladorAltaProducto;

    private AgregarStockVista vistaAgregarStock;
    private AgregarStockController controladorAgregarStock;
    private ReducirStockVista vistaReducirStock;
    private ReducirStockController controladorReducirStock;
    private ProductoDAO productoDAO;

    public AlmacenMenuController(AlmacenMenuView vistaAlmacenMenu) {
        this.vistaAlmacenMenu = vistaAlmacenMenu;
        this.vistaAlmacenMenu.setActionListener(this);
        this.productoDAO = new ProductoDAOImpl();
        cargarInventario(); // Cargar el inventario al abrir la vista
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case AlmacenMenuView.COMANDO_ALTA_PRODUCTO:
                mostrarAltaProducto();
                break;
            
            case AlmacenMenuView.COMANDO_AGREGAR_STOCK:
                mostrarAgregarStock();
                break;
            case AlmacenMenuView.COMANDO_REDUCIR_STOCK:
                mostrarReducirStock();
                break;
            
            default:
                break;
        }
    }

    private void cargarInventario() {
        DefaultTableModel modelo = vistaAlmacenMenu.getModeloTablaInventario();
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar

        List<Producto> productos = productoDAO.obtenerTodosProductos();
        for (Producto producto : productos) {
            modelo.addRow(new Object[]{
                    producto.getCodigoProducto(),
                    producto.getNombre(),
                    producto.getPrecioVenta(),
                    producto.getStock()
            });
        }
    }

    private void mostrarAltaProducto() {
        if (vistaAltaProducto == null) {
            vistaAltaProducto = new AltaProductoVista();
            controladorAltaProducto = new AltaProductoController(vistaAltaProducto);
            controladorAltaProducto.iniciarVista();
        } else {
            vistaAltaProducto.setVisible(true);
        }
    }



    private void mostrarAgregarStock() {
        if (vistaAgregarStock == null) {
            vistaAgregarStock = new AgregarStockVista();
            controladorAgregarStock = new AgregarStockController(vistaAgregarStock);
            controladorAgregarStock.iniciarVista();
        } else {
            vistaAgregarStock.setVisible(true);
        }
    }

    private void mostrarReducirStock() {
        if (vistaReducirStock == null) {
            vistaReducirStock = new ReducirStockVista();
            controladorReducirStock = new ReducirStockController(vistaReducirStock);
            controladorReducirStock.iniciarVista();
        } else {
            vistaReducirStock.setVisible(true);
        }
    }

    private void mostrarBajaProducto() {
        System.out.println("Mostrar Baja Producto (implementar)");
    }
}