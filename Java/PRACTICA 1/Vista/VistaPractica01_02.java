package Vista;

import javax.swing.JWindow;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VistaPractica01_02 extends JWindow {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

    public VistaPractica01_02() {
        setBounds(100, 100, 300, 200); // Tamaño y posición
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE); // Fondo blanco
        setContentPane(contentPane);
        contentPane.setLayout(null); // Layout libre (sin administrar posición)

        // Ejemplo: Etiqueta centrada
        JLabel lblMensaje = new JLabel("Esta es una JWindow");
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 16));
        lblMensaje.setBounds(50, 80, 200, 30);
        contentPane.add(lblMensaje);
    }

    // Método para mostrar la ventana
    public void mostrar() {
        setVisible(true);
    }
}
