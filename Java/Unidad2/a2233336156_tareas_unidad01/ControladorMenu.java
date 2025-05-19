package a2233336156_tareas_unidad01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorMenu {
    private VistaMenu vistaMenu;

    public ControladorMenu(VistaMenu vistaMenu) {
        this.vistaMenu = vistaMenu;
        this.vistaMenu.setVisible(true);

        // Acciones de menú
        this.vistaMenu.getMenuExcel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVistaProducto("productos.xlsx", "Excel");
            }
        });

        this.vistaMenu.getMenuJson().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVistaProducto("productos.json", "JSON");
            }
        });

        this.vistaMenu.getMenuXml().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVistaProducto("productos.xml", "XML");
            }
        });

        this.vistaMenu.getMenuSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Método para abrir la ventana de productos
    private void abrirVistaProducto(String archivo, String tipoArchivo) {
        try {
            VistaProducto vistaProducto = new VistaProducto();
            ControladorProducto controladorProducto = new ControladorProducto(vistaProducto, archivo, tipoArchivo);
            vistaMenu.getDesktopPane().add(vistaProducto);
            vistaProducto.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaMenu, "Error al abrir la vista: " + ex.getMessage());
        }
    }
    
}