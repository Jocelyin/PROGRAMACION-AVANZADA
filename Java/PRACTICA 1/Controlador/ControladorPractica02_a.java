package Controlador;

import Vista.VistaPractica02_a;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPractica02_a {

    private VistaPractica02_a vista;

    public ControladorPractica02_a() {
        vista = new VistaPractica02_a(); // Crear ventana
        agregarEventos(); // Conectar botón con su acción
        vista.mostrar(); // Mostrar ventana
    }

    // Método para conectar eventos
    private void agregarEventos() {
        vista.getBtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar el botón
                JOptionPane.showMessageDialog(vista, "Byee ;b");
                vista.dispose(); // Cerrar la ventana
            }
        });
    }
}
