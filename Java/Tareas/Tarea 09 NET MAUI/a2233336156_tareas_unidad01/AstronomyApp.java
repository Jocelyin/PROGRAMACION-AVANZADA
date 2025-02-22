package a2233336156_tareas_unidad01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AstronomyApp {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AstronomyApp window = new AstronomyApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AstronomyApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);

        // Página de selección de cuerpos astronómicos
        JPanel bodySelectionPage = new JPanel();
        bodySelectionPage.setLayout(new GridLayout(4, 1));

        JButton btnSun = new JButton("Sol");
        btnSun.addActionListener(e -> showAstronomicalBodyDetails("Sol"));
        bodySelectionPage.add(btnSun);

        JButton btnEarth = new JButton("Tierra");
        btnEarth.addActionListener(e -> showAstronomicalBodyDetails("Tierra"));
        bodySelectionPage.add(btnEarth);

        JButton btnMoon = new JButton("Luna");
        btnMoon.addActionListener(e -> showAstronomicalBodyDetails("Luna"));
        bodySelectionPage.add(btnMoon);

        JButton btnComet = new JButton("Cometa Halley");
        btnComet.addActionListener(e -> showAstronomicalBodyDetails("Cometa Halley"));
        bodySelectionPage.add(btnComet);

        // Página de detalles del cuerpo astronómico
        JPanel bodyDetailsPage = new JPanel();
        bodyDetailsPage.setLayout(new BorderLayout());
        JLabel detailsLabel = new JLabel("Detalles del cuerpo astronómico", JLabel.CENTER);
        bodyDetailsPage.add(detailsLabel, BorderLayout.CENTER);

        // Agregar las páginas al cardLayout
        cardPanel.add(bodySelectionPage, "BodySelection");
        cardPanel.add(bodyDetailsPage, "BodyDetails");

        // Mostrar la página de selección de cuerpos astronómicos
        cardLayout.show(cardPanel, "BodySelection");
    }

    // Mostrar los detalles del cuerpo astronómico
    private void showAstronomicalBodyDetails(String bodyName) {
        // Actualiza el contenido de la página de detalles según el cuerpo seleccionado
        JPanel bodyDetailsPage = (JPanel) cardPanel.getComponent(1);
        JLabel detailsLabel = (JLabel) bodyDetailsPage.getComponent(0);
        detailsLabel.setText("Detalles de " + bodyName);

        // Mostrar la página de detalles
        cardLayout.show(cardPanel, "BodyDetails");
    }
}
