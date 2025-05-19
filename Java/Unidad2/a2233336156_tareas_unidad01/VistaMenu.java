package a2233336156_tareas_unidad01;

import javax.swing.*;
import java.awt.*;

public class VistaMenu extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
    private JMenuItem menuExcel, menuJson, menuXml, menuSalir;

    public VistaMenu() {
        setTitle("Aplicación con Menú y DesktopPane");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivos");
        menuExcel = new JMenuItem("Excel");
        menuJson = new JMenuItem("Json");
        menuXml = new JMenuItem("XML");
        menuArchivo.add(menuExcel);
        menuArchivo.add(menuJson);
        menuArchivo.add(menuXml);

        JMenu menuSalida = new JMenu("Salida");
        menuSalir = new JMenuItem("Salir");
        menuSalida.add(menuSalir);

        menuBar.add(menuArchivo);
        menuBar.add(menuSalida);
        setJMenuBar(menuBar);

        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JMenuItem getMenuExcel() {
        return menuExcel;
    }

    public JMenuItem getMenuJson() {
        return menuJson;
    }

    public JMenuItem getMenuXml() {
        return menuXml;
    }

    public JMenuItem getMenuSalir() {
        return menuSalir;
    }
}
