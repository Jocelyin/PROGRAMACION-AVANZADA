package a2233336156_tareas_unidad01;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class programa13a extends JFrame {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private JTable table;

    public programa13a() {
        setTitle("Sistema");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuPrincipal = new JMenu("Principal");
        JMenu menuAlmacen = new JMenu("Almacén");
        JMenu menuConfig = new JMenu("Configuración");
        JMenu menuSalida = new JMenu("Salida");

        JMenuItem ventasItem = new JMenuItem("Ventas");
        JMenuItem reportesItem = new JMenuItem("Reportes");
        menuPrincipal.add(ventasItem);
        menuPrincipal.add(reportesItem);

        // Crear submenús para "Almacén"
        JMenuItem inventarioItem = new JMenuItem("Inventario");
        JMenuItem productosItem = new JMenuItem("Productos");
        menuAlmacen.add(inventarioItem);
        menuAlmacen.add(productosItem);

        // Crear submenús para "Configuración"
        JMenuItem preferenciasItem = new JMenuItem("Preferencias");
        JMenuItem usuariosItem = new JMenuItem("Usuarios");
        menuConfig.add(preferenciasItem);
        menuConfig.add(usuariosItem);

        // Crear submenús para "Salida"
        JMenuItem cerrarSesionItem = new JMenuItem("Cerrar Sesión");
        JMenuItem salirItem = new JMenuItem("Salir");
        menuSalida.add(cerrarSesionItem);
        menuSalida.add(salirItem);

        menuBar.add(menuPrincipal);
        menuBar.add(menuAlmacen);
        menuBar.add(menuConfig);
        menuBar.add(menuSalida);
        setJMenuBar(menuBar);

        // Crear la tabla
        String[] columnNames = {"Id Producto", "Producto", "Descripción", "Cantidad", "Precio"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton addButton = new JButton("Agregar");
        JButton deleteButton = new JButton("Eliminar");
        JButton modifyButton = new JButton("Modificar");
        JButton exitButton = new JButton("Salida");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Agregar ActionListener a los botones
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{"", "", "", "", ""});
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(programa13a.this, "Seleccione una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    for (int i = 0; i < table.getColumnCount(); i++) {
                        String newValue = JOptionPane.showInputDialog(programa13a.this, "Ingrese nuevo valor para "
                                 + table.getColumnName(i), table.getValueAt(selectedRow, i));
                        if (newValue != null) {
                            table.setValueAt(newValue, selectedRow, i);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(programa13a.this, "Seleccione una fila para modificar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Agregar ActionListener a los submenús
        ActionListener submenuActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem source = (JMenuItem) e.getSource();
                JDialog dialog = new JDialog(programa13a.this, source.getText(), true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(programa13a.this);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        };

        ventasItem.addActionListener(submenuActionListener);
        reportesItem.addActionListener(submenuActionListener);
        inventarioItem.addActionListener(submenuActionListener);
        productosItem.addActionListener(submenuActionListener);
        preferenciasItem.addActionListener(submenuActionListener);
        usuariosItem.addActionListener(submenuActionListener);
        cerrarSesionItem.addActionListener(submenuActionListener);
        salirItem.addActionListener(submenuActionListener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new programa13a().setVisible(true);
        });
    }
}
