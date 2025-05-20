package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AlmacenMenuView extends JPanel { // Cambia JFrame a JPanel

    private JButton btnAltaProducto;
    private JButton btnAgregarStock;
    private JButton btnReducirStock;
    private JPanel panelBotones;
    private JTable tablaInventario;
    private DefaultTableModel modeloTablaInventario;
    private JScrollPane scrollPaneTabla;

    public static final String COMANDO_ALTA_PRODUCTO = "alta_producto";
    public static final String COMANDO_AGREGAR_STOCK = "agregar_stock";
    public static final String COMANDO_REDUCIR_STOCK = "reducir_stock";

    public AlmacenMenuView() {
        setLayout(new BorderLayout(10, 10)); // Ahora usamos setLayout en el JPanel

        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnAltaProducto = new JButton("Alta Producto");
        btnAltaProducto.setActionCommand(COMANDO_ALTA_PRODUCTO);
        panelBotones.add(btnAltaProducto);

        btnAgregarStock = new JButton("Agregar Stock");
        btnAgregarStock.setActionCommand(COMANDO_AGREGAR_STOCK);
        panelBotones.add(btnAgregarStock);

        btnReducirStock = new JButton("Reducir Stock");
        btnReducirStock.setActionCommand(COMANDO_REDUCIR_STOCK);
        panelBotones.add(btnReducirStock);

        add(panelBotones, BorderLayout.NORTH);

        modeloTablaInventario = new DefaultTableModel(new Object[]{"Código", "Nombre", "Precio", "Stock"}, 0);
        tablaInventario = new JTable(modeloTablaInventario);
        scrollPaneTabla = new JScrollPane(tablaInventario);
        add(scrollPaneTabla, BorderLayout.CENTER);

        // setPreferredSize(new Dimension(800, 600)); // Ya no es necesario aquí
        // pack(); // Ya no llamamos pack() aquí
        // setLocationRelativeTo(null); // La posición la gestiona el JFrame padre
    }

    public void setActionListener(ActionListener listener) {
        btnAltaProducto.addActionListener(listener);
        btnAgregarStock.addActionListener(listener);
        btnReducirStock.addActionListener(listener);
    }

    public DefaultTableModel getModeloTablaInventario() {
        return modeloTablaInventario;
    }
}