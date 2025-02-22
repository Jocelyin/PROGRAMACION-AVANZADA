package a2233336156_tareas_unidad01;

//codigo 2

import javax.swing.*;
import java.awt.*;

public class TipCalculatorApp {
    public static void main(String[] args) {
        // Definir recursos globales
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 22));
        UIManager.put("Label.foreground", new Color(0x0000AD));
        
        // Crear y mostrar la ventana principal
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tip Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.getContentPane().setBackground(new Color(0xC0C0C0));
            
            JPanel panel = new JPanel(new GridLayout(2, 1));
            panel.setBackground(new Color(0xC0C0C0));
            
            JLabel billLabel = new JLabel("PROGRAMACION AVANZADA");
            billLabel.setFont(new Font("Arial", Font.BOLD, 22)); // infoLabelStyle
            
            JTextField billField = new JTextField(10);
            
            panel.add(billLabel);
            panel.add(billField);
            
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}