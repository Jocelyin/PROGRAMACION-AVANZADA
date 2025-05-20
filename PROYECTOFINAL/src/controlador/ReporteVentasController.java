package controlador;

import dao.VentaDAO;
import dao.VentaDAOImpl;
import vista.ReporteVentasVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Venta;

public class ReporteVentasController implements ActionListener {

    private ReporteVentasVista vista;
    private VentaDAO ventaDAO;

    public ReporteVentasController(ReporteVentasVista vista) {
        this.vista = vista;
        this.ventaDAO = new VentaDAOImpl();
        this.vista.getBtnCargarReporte().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnCargarReporte()) {
            cargarReporteVentas();
        }
    }

    private void cargarReporteVentas() {
        List<Venta> ventas = ventaDAO.obtenerTodasLasVentas();
        vista.mostrarReporteVentas(ventas);
    }
}