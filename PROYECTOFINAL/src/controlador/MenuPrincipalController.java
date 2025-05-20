package controlador;

import vista.MenuPrincipalVista;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MenuPrincipalController implements ActionListener {

    private MenuPrincipalVista vistaMenuPrincipal;
    private JPanel panelContenido;
    private CardLayout cardLayout;

    public MenuPrincipalController(MenuPrincipalVista vistaMenuPrincipal) {
        this.vistaMenuPrincipal = vistaMenuPrincipal;
        this.panelContenido = vistaMenuPrincipal.getPanelContenido();
        this.cardLayout = vistaMenuPrincipal.getCardLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case MenuPrincipalVista.COMANDO_GENERAR_VENTA:
                vistaMenuPrincipal.mostrarPanel(vistaMenuPrincipal.getGenerarVentaVista(), MenuPrincipalVista.COMANDO_GENERAR_VENTA);
                break;
            case MenuPrincipalVista.COMANDO_ALMACEN:
                vistaMenuPrincipal.mostrarPanel(vistaMenuPrincipal.getAlmacenMenuView(), MenuPrincipalVista.COMANDO_ALMACEN);
                break;
            case MenuPrincipalVista.COMANDO_REPORTE_VENTAS:
                vistaMenuPrincipal.mostrarPanel(vistaMenuPrincipal.getReporteVentasVista(), MenuPrincipalVista.COMANDO_REPORTE_VENTAS);
                break;
            default:
                break;
        }
    }
}