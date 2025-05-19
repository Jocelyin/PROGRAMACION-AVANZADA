package Controlador;

import Vista.VistaPractica02_b2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPractica02_b2 implements ActionListener {

	    private VistaPractica02_b2 vista;

	    public ControladorPractica02_b2() {
	        vista = new VistaPractica02_b2(); // Crear ventana
	        agregarEventos(); // Conectar botón
	        vista.mostrar(); // Mostrar ventana
	    }

	    // Conectar evento del botón al ActionListener
	    private void agregarEventos() {
	        vista.getBtnSalir().addActionListener(this);
	    }

	    // Acción al presionar botón o Alt + S
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == vista.getBtnSalir()) {
	            JOptionPane.showMessageDialog(vista, "¡Hasta luego desde Practica02_b2!");
	            vista.dispose(); // Cierra ventana
	        }
	    }
	}
