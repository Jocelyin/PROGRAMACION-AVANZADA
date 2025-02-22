package a2233336156_tareas_unidad01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaAsistentePrestamo extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField campoSaldoPrestamo, campoTasaInteres, campoNumeroPagos, campoPagoMensual;
    private JTextArea areaAnalisis;
    private JButton botonCalcular, botonNuevoAnalisis, botonSalir, botonCambiarModo;
    private boolean modoCalcularPago = true;

    public VistaAsistentePrestamo() {
        setTitle("Asistente de Préstamos");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        campoSaldoPrestamo = new JTextField(10);
        campoTasaInteres = new JTextField(10);
        campoNumeroPagos = new JTextField(10);
        campoPagoMensual = new JTextField(10);
        campoPagoMensual.setEnabled(false); // Deshabilitar inicialmente
        areaAnalisis = new JTextArea(10, 30);
        botonCalcular = new JButton("Calcular Pago Mensual");
        botonNuevoAnalisis = new JButton("Nuevo Análisis");
        botonSalir = new JButton("Salir");
        botonCambiarModo = new JButton("Cambiar Modo");

        agregarComponente(new JLabel("Saldo del Préstamo:"), 0, 0);
        agregarComponente(campoSaldoPrestamo, 0, 1);
        agregarComponente(new JLabel("Tasa de Interés (%):"), 1, 0);
        agregarComponente(campoTasaInteres, 1, 1);
        agregarComponente(new JLabel("Número de Pagos:"), 2, 0);
        agregarComponente(campoNumeroPagos, 2, 1);
        agregarComponente(new JLabel("Pago Mensual:"), 3, 0);
        agregarComponente(campoPagoMensual, 3, 1);
        agregarComponente(new JScrollPane(areaAnalisis), 4, 0, 2, 1);
        agregarComponente(botonCalcular, 5, 0);
        agregarComponente(botonNuevoAnalisis, 5, 1);
        agregarComponente(botonSalir, 6, 0);
        agregarComponente(botonCambiarModo, 6, 1);

        botonNuevoAnalisis.setEnabled(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarComponente(Component comp, int fila, int col) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = col;
        gbc.gridy = fila;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(comp, gbc);
    }

    private void agregarComponente(Component comp, int fila, int col, int colspan, int rowspan) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = col;
        gbc.gridy = fila;
        gbc.gridwidth = colspan;
        gbc.gridheight = rowspan;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        add(comp, gbc);
    }

    public String obtenerSaldoPrestamo() { return campoSaldoPrestamo.getText(); }
    public String obtenerTasaInteres() { return campoTasaInteres.getText(); }
    public String obtenerNumeroPagos() { return campoNumeroPagos.getText(); }
    public String obtenerPagoMensual() { return campoPagoMensual.getText(); }
    public void establecerTextoAnalisis(String texto) { areaAnalisis.setText(texto); }
    
    public void agregarEscuchadorCalculo(ActionListener listener) { botonCalcular.addActionListener(listener); }
    public void agregarEscuchadorNuevoAnalisis(ActionListener listener) { botonNuevoAnalisis.addActionListener(listener); }
    public void agregarEscuchadorSalir(ActionListener listener) { botonSalir.addActionListener(listener); }
    public void agregarEscuchadorCambiarModo(ActionListener listener) { botonCambiarModo.addActionListener(listener); }
    
    public void alternarModoCalcularPago() {
        modoCalcularPago = !modoCalcularPago;
        if (modoCalcularPago) {
            botonCalcular.setText("Calcular Pago Mensual");
            campoNumeroPagos.setEnabled(true);
            campoPagoMensual.setEnabled(false);
        } else {
            botonCalcular.setText("Calcular Número de Pagos");
            campoNumeroPagos.setEnabled(false);
            campoPagoMensual.setEnabled(true);
        }
    }
    
    public boolean estaModoCalcularPago() { return modoCalcularPago; }
}
