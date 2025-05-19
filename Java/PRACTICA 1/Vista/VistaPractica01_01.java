
package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class VistaPractica01_01 extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

    public VistaPractica01_01() {
        setTitle("Practica01_01 - Ventana Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.LIGHT_GRAY); // Ejemplo de color

        setContentPane(contentPane);
        contentPane.setLayout(null); // Layout libre, como en la práctica
    }

    // Método para mostrar la ventana
    public void mostrar() {
        setVisible(true);
    }
}
