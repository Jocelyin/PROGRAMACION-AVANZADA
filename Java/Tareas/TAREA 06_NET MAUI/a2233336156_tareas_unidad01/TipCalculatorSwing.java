package a2233336156_tareas_unidad01;

import javax.swing.*;
import java.awt.*;

public class TipCalculatorSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tip Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Configuración del layout
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        frame.setLayout(gridBagLayout);

        // Configuración de elementos
        JLabel billLabel = new JLabel("Bill:");
        JTextField billInput = new JTextField(10);
        JLabel tipLabel = new JLabel("Tip:");
        JLabel tipOutput = new JLabel("0.00");
        JLabel totalLabel = new JLabel("Total:");
        JLabel totalOutput = new JLabel("0.00");
        JLabel tipPercentLabel = new JLabel("Tip Percentage:");
        JLabel tipPercent = new JLabel("15%");
        JSlider tipSlider = new JSlider(0, 100, 15);
        JButton button15 = new JButton("15%");
        JButton button20 = new JButton("20%");
        JButton roundDown = new JButton("Round Down");
        JButton roundUp = new JButton("Round Up");

        // Alineación de elementos
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Añadir billLabel y billInput
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(billLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(billInput, gbc);

        // Añadir tipLabel y tipOutput
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(tipLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(tipOutput, gbc);

        // Añadir totalLabel y totalOutput
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(totalLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(totalOutput, gbc);

        // Añadir tipPercentLabel y tipPercent
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        frame.add(tipPercentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        frame.add(tipPercent, gbc);

        // Añadir el slider
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        frame.add(tipSlider, gbc);

        gbc.gridwidth = 1;

        // Añadir botones para porcentaje de propina
        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(button15, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        frame.add(button20, gbc);

        // Añadir botones para redondear
        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(roundDown, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        frame.add(roundUp, gbc);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}

