package a2233336156_tareas_unidad01;


	import java.awt.event.ActionEvent;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;

	public class ejemploJFrame_03_d extends JFrame {
	    static JLabel La, Lb;
	    static JButton Bboton;

	    public ejemploJFrame_03_d() {
	        this.setLayout(null);
	        this.setBounds(10, 10, 300, 300);

	        La = new JLabel("El triángulo de base 5 y de altura 2");
	        La.setBounds(10, 10, 200, 30);
	        this.add(La);

	        Lb = new JLabel();
	        Lb.setBounds(10, 100, 200, 30);
	        this.add(Lb);

	        Bboton = new JButton();
	        Bboton.setText("Calcular");
	        Bboton.setBounds(10, 50, 100, 30);
	        Bboton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Lb.setText("El área del triángulo es 5");
	            }
	        });

	        this.add(Bboton);
	    }

	    public static void main(String parametro[]) {
	        ejemploJFrame_03_d ventana = new ejemploJFrame_03_d();
	        ventana.setVisible(true);
	    }
	}

