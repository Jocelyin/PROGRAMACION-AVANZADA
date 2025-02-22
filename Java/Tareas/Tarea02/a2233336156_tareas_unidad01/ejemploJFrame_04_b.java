package a2233336156_tareas_unidad01;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

public class ejemploJFrame_04_b extends JFrame {
    static JLabel La, Lb, Lc;
    static JButton Bcalcular, Bsalir;
    static JTextField Ta, Th, Tb;

    public ejemploJFrame_04_b() {
        this.setLayout(null);
        this.setTitle("Eduardo Alvarez - Ejemplo JFrame_04_b");
        this.setBounds(10, 10, 350, 300);

        // Crear y configurar etiquetas
        La = new JLabel("Introduce el valor de la Altura:");
        La.setBounds(10, 10, 200, 30);
        Lb = new JLabel("Introduce el valor de la Base:");
        Lb.setBounds(10, 40, 200, 30);
        Lc = new JLabel("El área es igual a --> ");
        Lc.setBounds(10, 110, 200, 30);

        // Crear y configurar campos de texto
        Th = new JTextField("");
        Th.setBounds(220, 10, 100, 30);
        Tb = new JTextField("");
        Tb.setBounds(220, 40, 100, 30);
        Ta = new JTextField("");
        Ta.setBounds(220, 110, 100, 30);
        Ta.setEditable(false); // Campo no editable para el resultado

        // Crear y configurar botones
        Bcalcular = new JButton("Calcular");
        Bcalcular.setBounds(10, 60, 100, 30);
        Bsalir = new JButton("Salir");
        Bsalir.setBounds(120, 60, 100, 30);

        // Añadir ActionListener para el botón "Calcular"
        Bcalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double h, b, a;
                String Sh = Th.getText();
                String Sb = Tb.getText();

                if (!Sh.isEmpty() && !Sb.isEmpty()) {
                    try {
                        h = Double.parseDouble(Sh);
                        b = Double.parseDouble(Sb);
                        a = (h * b) / 2; // Cálculo del área del triángulo
                        Ta.setText(String.valueOf(a)); // Mostrar el resultado
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Lo siento, uno o ambos campos están vacíos.");
                }
            }
        });

        // Añadir ActionListener para el botón "Salir"
        Bsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cerrar el programa
            }
        });

        // Agregar componentes al JFrame
        this.add(La);
        this.add(Lb);
        this.add(Lc);
        this.add(Th);
        this.add(Tb);
        this.add(Ta);
        this.add(Bcalcular);
        this.add(Bsalir);
    }

    public static void main(String[] args) {
        ejemploJFrame_04_b ventana = new ejemploJFrame_04_b();
        ventana.setVisible(true);
    }
}



