package a2233336156_tareas_unidad01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherApp {
    private JFrame frame;
    private JLabel weatherLabel;
    private JButton updateButton;

    public WeatherApp() {
        frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Crear el JLabel para mostrar el icono del clima
        weatherLabel = new JLabel();
        weatherLabel.setIcon(WeatherConverter.convert(WeatherType.QUESTION));  // Valor predeterminado
        frame.add(weatherLabel);

        // Crear un botón para actualizar el clima
        updateButton = new JButton("Actualizar");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simular cambio de clima
                //WeatherType currentCondition = WeatherType.SUNNY;  // Puedes cambiar esto dinámicamente
                //WeatherType currentCondition = WeatherType.CLOUDY;
               // WeatherType currentCondition = WeatherType.RAINY;
                WeatherType currentCondition = WeatherType.SNOWY;
                
                weatherLabel.setIcon(WeatherConverter.convert(currentCondition));
            }
        });
        frame.add(updateButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WeatherApp();
    }
}

