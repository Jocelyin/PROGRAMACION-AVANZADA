package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import modelo.Venta;

public class ReporteVentasVista extends JPanel {

    private JTable tablaVentas;
    private DefaultTableModel modeloTabla;
    private JButton btnCargarReporte;

    public ReporteVentasVista() {
        setLayout(new BorderLayout());

        // Crear el modelo de la tabla
        String[] columnas = {"ID Venta", "Fecha Venta", "Hora Venta", "Total Venta", "Monto Pagado"};
        modeloTabla = new DefaultTableModel(columnas, 0);

        // Crear la tabla
        tablaVentas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaVentas);

        // Crear el botón para cargar el reporte
        btnCargarReporte = new JButton("Cargar Reporte de Ventas");

        // Añadir componentes al panel
        add(scrollPane, BorderLayout.CENTER);
        add(btnCargarReporte, BorderLayout.SOUTH);
    }

    public JButton getBtnCargarReporte() {
        return btnCargarReporte;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void mostrarReporteVentas(List<Venta> ventas) {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de mostrar nuevos datos
        for (Venta venta : ventas) {
            Object[] fila = {
                    venta.getIdVenta(),
                    venta.getFechaVenta().toLocalDate(),
                    venta.getFechaVenta().toLocalTime(),
                    venta.getTotalVenta(),
                    venta.getMontoPagado()
            };
            modeloTabla.addRow(fila);
        }
    }
}