package a2233336156_tareas_unidad01;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programa12a extends JFrame {
    private static final long serialVersionUID = 1L;

    public Programa12a() {
        setTitle("Sistema");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear los menús
        JMenu menuPrincipal = new JMenu("Principal");
        JMenu menuAlmacen = new JMenu("Almacén");
        JMenu menuConfig = new JMenu("Configuración");
        JMenu menuSalida = new JMenu("Salida");

        // Crear submenús para "Principal"
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

        // Agregar los menús a la barra de menú
        menuBar.add(menuPrincipal);
        menuBar.add(menuAlmacen);
        menuBar.add(menuConfig);
        menuBar.add(menuSalida);

        // Establecer la barra de menú en el frame
        setJMenuBar(menuBar);

        // Agregar ActionListener a los submenús
        ActionListener menuActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem source = (JMenuItem) e.getSource();
                JDialog dialog = new JDialog(Programa12a.this, source.getText(), true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(Programa12a.this);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }
        };

        ventasItem.addActionListener(menuActionListener);
        reportesItem.addActionListener(menuActionListener);
        inventarioItem.addActionListener(menuActionListener);
        productosItem.addActionListener(menuActionListener);
        preferenciasItem.addActionListener(menuActionListener);
        usuariosItem.addActionListener(menuActionListener);
        cerrarSesionItem.addActionListener(menuActionListener);
        salirItem.addActionListener(menuActionListener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Programa12a().setVisible(true);
        });
    }
}