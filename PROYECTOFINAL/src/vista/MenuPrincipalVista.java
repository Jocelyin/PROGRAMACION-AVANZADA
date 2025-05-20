package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import controlador.MenuPrincipalController;

public class MenuPrincipalVista extends JFrame {

    private JButton btnGenerarVenta;
    private JButton btnAlmacen;
    private JButton btnReporteVentas;
    private JPanel panelContenido;
    private CardLayout cardLayout;
    private GenerarVentaVista generarVentaVista;
    private AlmacenMenuView almacenMenuView;
    private ReporteVentasVista reporteVentasVista;

    public static final String COMANDO_GENERAR_VENTA = "generarVenta";
    public static final String COMANDO_ALMACEN = "almacen";
    public static final String COMANDO_REPORTE_VENTAS = "reporteVentas";

    public MenuPrincipalVista() {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);

        // Inicializar vistas
        generarVentaVista = new GenerarVentaVista();
        almacenMenuView = new AlmacenMenuView();
        reporteVentasVista = new ReporteVentasVista();

        // Agregar vistas al panel central
        panelContenido.add(generarVentaVista, COMANDO_GENERAR_VENTA);
        panelContenido.add(almacenMenuView, COMANDO_ALMACEN);
        panelContenido.add(reporteVentasVista, COMANDO_REPORTE_VENTAS);

        // Inicializar los botones aquí
        btnGenerarVenta = new JButton("Generar Venta");
        btnAlmacen = new JButton("Almacén");
        btnReporteVentas = new JButton("Reporte de Ventas");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGenerarVenta);
        panelBotones.add(btnAlmacen);
        panelBotones.add(btnReporteVentas);

        add(panelBotones, BorderLayout.NORTH);
        add(panelContenido, BorderLayout.CENTER);
    }

    public void setControlador(ActionListener controlador) {
        btnGenerarVenta.setActionCommand(COMANDO_GENERAR_VENTA);
        btnGenerarVenta.addActionListener(controlador);
        btnAlmacen.setActionCommand(COMANDO_ALMACEN);
        btnAlmacen.addActionListener(controlador);
        btnReporteVentas.setActionCommand(COMANDO_REPORTE_VENTAS);
        btnReporteVentas.addActionListener(controlador);
    }

    public void mostrarPanel(JPanel panel, String nombrePanel) {
        cardLayout.show(panelContenido, nombrePanel);
    }

    public JButton getBtnGenerarVenta() {
        return btnGenerarVenta;
    }

    public JButton getBtnAlmacen() {
        return btnAlmacen;
    }

    public JButton getBtnReporteVentas() {
        return btnReporteVentas;
    }

    public JPanel getPanelContenido() {
        return panelContenido;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public GenerarVentaVista getGenerarVentaVista() {
        return generarVentaVista;
    }

    public AlmacenMenuView getAlmacenMenuView() {
        return almacenMenuView;
    }

    public ReporteVentasVista getReporteVentasVista() {
        return reporteVentasVista;
    }

    public static String getComandoGenerarVenta() {
        return COMANDO_GENERAR_VENTA;
    }

    public static String getComandoAlmacen() {
        return COMANDO_ALMACEN;
    }

    public static String getComandoReporteVentas() {
        return COMANDO_REPORTE_VENTAS;
    }
}