package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class VistaPractica02_b2 extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JButton btnSalir; // Botón

    public VistaPractica02_b2() {
        setTitle("Practica02_b2 - Botón con Mnemonic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);

        contentPane = new JPanel();
        contentPane.setBackground(Color.GREEN); // Color diferente para diferenciar
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Crear botón
        btnSalir = new JButton("Salir (Alt + S)");
        btnSalir.setBounds(80, 70, 140, 30); // Posición y tamaño

        // Establecer mnemonic (Alt + S)
        btnSalir.setMnemonic(KeyEvent.VK_S); // Tecla S como acceso rápido
        btnSalir.setToolTipText("Presiona Alt + S para salir"); // Mensaje de ayuda

        contentPane.add(btnSalir);
    }

    // Método para obtener el botón
    public JButton getBtnSalir() {
        return btnSalir;
    }

    // Mostrar ventana
    public void mostrar() {
        setVisible(true);
    }
}

