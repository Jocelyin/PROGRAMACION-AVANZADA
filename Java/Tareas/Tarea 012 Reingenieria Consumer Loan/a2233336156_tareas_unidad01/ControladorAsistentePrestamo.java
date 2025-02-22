package a2233336156_tareas_unidad01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAsistentePrestamo {
    private VistaAsistentePrestamo vista;
    
    public ControladorAsistentePrestamo(VistaAsistentePrestamo vista) {
        this.vista = vista;
        this.vista.agregarEscuchadorCalculo(new EscuchadorCalculo());
        this.vista.agregarEscuchadorNuevoAnalisis(e -> vista.establecerTextoAnalisis(""));
        this.vista.agregarEscuchadorSalir(e -> System.exit(0));
        this.vista.agregarEscuchadorCambiarModo(e -> vista.alternarModoCalcularPago());
    }
    
    private class EscuchadorCalculo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double saldo = Double.parseDouble(vista.obtenerSaldoPrestamo());
               // double tasaInteres = Double.parseDouble(vista.obtenerTasaInteres()) / 100.0;
                double tasaInteres = Double.parseDouble(vista.obtenerTasaInteres().replace("%", "").trim());

                
                if (tasaInteres == 0) {
                    vista.establecerTextoAnalisis("Error: La tasa de interés no puede ser 0.");
                    return;
                }
                
                if (vista.estaModoCalcularPago()) {
                    int meses = Integer.parseInt(vista.obtenerNumeroPagos());
                    double interesMensual = tasaInteres / 12.0;
                    double pago = saldo * (interesMensual / (1 - Math.pow(1 + interesMensual, -meses)));
                    vista.establecerTextoAnalisis("Pago Mensual: " + String.format("%.2f", pago));
                } else {
                    double pago = Double.parseDouble(vista.obtenerPagoMensual());
                    double interesMensual = tasaInteres / 12.0;
                    if (pago <= saldo * interesMensual) {
                        vista.establecerTextoAnalisis("Error: El pago debe ser mayor que los intereses.");
                        return;
                    }
                    int meses = (int) (Math.log(pago / (pago - saldo * interesMensual)) / Math.log(1 + interesMensual));
                    vista.establecerTextoAnalisis("Número de Pagos: " + meses);
                }
            } catch (NumberFormatException ex) {
                vista.establecerTextoAnalisis("Error: Ingrese valores numéricos válidos.");
            }
        }
    }
}
