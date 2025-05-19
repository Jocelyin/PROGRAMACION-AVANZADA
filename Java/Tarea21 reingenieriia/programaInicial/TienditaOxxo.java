package programaInicial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
//import java.awt.toolkit;

public class TienditaOxxo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TienditaOxxo frame = new TienditaOxxo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TienditaOxxo() {
		
		this.setTitle("TIENDITA OXXO");
		Image icono = Toolkit.getDefaultToolkit().getImage("C:\\Users\\jmate\\Downloads\\oxxo.png");
		this.setIconImage(icono);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel label = new JLabel("New label");
		contentPane.add(label);
	}

}
