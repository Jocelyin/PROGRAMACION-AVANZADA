package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import modelo.Venta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException; // Importar para manejar errores de parseo

public class ReporteVentasVista extends JPanel {

    private JTable tablaVentas;
    private DefaultTableModel modeloTabla;
    private JButton btnCargarReporte;

    public ReporteVentasVista() {
        setLayout(new BorderLayout());

       
        String[] columnas = {"ID Venta", "Fecha y Hora Venta", "Total Venta", "Monto Pagado"}; 
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 

        for (Venta venta : ventas) {
            String fechaHoraVentaStr = venta.getFecha();
            String fechaFormateada = fechaHoraVentaStr; 

            String horaFormateada = ""; 

            
            try {
                LocalDateTime dateTime = LocalDateTime.parse(fechaHoraVentaStr, formatter);
                fechaFormateada = dateTime.toLocalDate().toString(); // "YYYY-MM-DD"
                horaFormateada = dateTime.toLocalTime().toString();  // "HH:MM:SS"
            } catch (DateTimeParseException e) {
               
                System.err.println("Error al parsear fecha de venta: " + fechaHoraVentaStr + " - " + e.getMessage());
            }

            Object[] fila = {
                venta.getIdVenta(),
                
                venta.getFecha(), 
                venta.getTotal(), 
                venta.getMontoPagado() 
            };
            modeloTabla.addRow(fila);
        }
    }

    // Método para mostrar mensajes (similar a GenerarVentaVista)
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}