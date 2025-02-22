package a2233336156_tareas_unidad01;
import javax.swing.ImageIcon;

public class WeatherConverter {

    public static ImageIcon convert(WeatherType weather) {
        switch (weather) {
            case SUNNY:
                return new ImageIcon("C:/Users/jmate/OneDrive/Escritorio/sunny.png");
            case CLOUDY:
                return new ImageIcon("C:/Users/jmate/OneDrive/Escritorio/cloudy.png");
            case RAINY:
                return new ImageIcon("C:/Users/jmate/OneDrive/Escritorio/rainy.png");
            case SNOWY:
                return new ImageIcon("C:/Users/jmate/OneDrive/Escritorio/snowy.png");
            default:
                return new ImageIcon("C:/Users/jmate/OneDrive/Escritorio/question.png");
        }
    }
}
