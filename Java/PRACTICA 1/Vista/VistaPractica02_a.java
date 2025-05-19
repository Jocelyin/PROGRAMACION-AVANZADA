package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class VistaPractica02_a extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton btnSalir; // Botón

    public VistaPractica02_a() {
        setTitle("Practica02_a - Botón Salir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);

        contentPane = new JPanel();
        contentPane.setBackground(Color.CYAN);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Crear botón "Salir"
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 70, 100, 30); // Posición y tamaño
        contentPane.add(btnSalir);
    }

    // Método para obtener el botón (para usarlo en el Controlador)
    public JButton getBtnSalir() {
        return btnSalir;
    }

    // Mostrar ventana
    public void mostrar() {
        setVisible(true);
    }
}
