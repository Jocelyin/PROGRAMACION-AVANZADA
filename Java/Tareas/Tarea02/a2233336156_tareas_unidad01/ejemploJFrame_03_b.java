package a2233336156_tareas_unidad01;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ejemploJFrame_03_b extends JFrame {
    static JLabel La, Lb;
    static JButton Bboton;

    public ejemploJFrame_03_b() {
        this.setLayout(null);
        this.setBounds(10, 10, 300, 300);

        La = new JLabel("el triángulo de base 5 y de altura 2");
        La.setBounds(10, 10, 200, 30);

        Lb = new JLabel();
        Lb.setBounds(10, 100, 200, 30);

        Bboton = new JButton();
        Bboton.setText("Calcular");
        Bboton.setBounds(10, 50, 100, 30);

        this.add(La);
        this.add(Lb);
        this.add(Bboton);
    }

    public static void main(String[] parametro) {
        ejemploJFrame_03_b ventana = new ejemploJFrame_03_b(); 
        ventana.setVisible(true);
        Lb.setText("el área del triángulo es 5");
    }
}

