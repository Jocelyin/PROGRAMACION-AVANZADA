package a2233336156_tareas_unidad01;

import javax.swing.*;
import java.awt.*;

public class NotesApp {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Notes App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Notes", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.BLACK);
        panel.add(label, BorderLayout.NORTH);

        JTextArea editor = new JTextArea("Enter your note");
        editor.setBackground(new Color(0xFF, 0xF0, 0xAD)); // Color de fondo
        editor.setForeground(Color.BLACK); // Color del texto
        panel.add(editor, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(0xFF, 0xF0, 0xAD)); // Color de fondo
        saveButton.setForeground(Color.BLACK); // Color del texto
        panel.add(saveButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}


