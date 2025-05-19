package Vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class VistaPractica01_03 extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

    // Constructor del JDialog
    public VistaPractica01_03() {
        setTitle("Practica01_03 - JDialog");
        setBounds(150, 150, 300, 200);
        setModal(true); // Hace que el JDialog bloquee la ventana principal

        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK); // Fondo para diferenciarar
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Ejemplo de etiqueta
        JLabel lblMensaje = new JLabel("Este es un JDialog");
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 14));
        lblMensaje.setBounds(60, 70, 180, 30);
        contentPane.add(lblMensaje);
    }

    // Método para mostrar el JDialog
    public void mostrar() {
        setVisible(true);
    }
}
