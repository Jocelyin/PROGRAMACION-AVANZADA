package a2233336156_tareas_unidad01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cronometro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel Panelprincipal;
	private JTextField TIniciar, Tdetenerse, Tsalida;
	private JButton Bdetener, Bsalida, Biniciar;
	private long tiempoinicio, tiempodetener;
	private double tiemposalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cronometro frame = new Cronometro();
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
	public Cronometro() {
		//System.currentTimeMillis();//long
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 231);
		Panelprincipal = new JPanel();
		Panelprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Panelprincipal);
		GridBagLayout gbl_panelprincipal = new GridBagLayout();
		gbl_panelprincipal.columnWidths = new int[] {118, 118, 118, 0};
		gbl_panelprincipal.rowHeights = new int[]{40, 40, 40, 0};
		gbl_panelprincipal.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelprincipal.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		Panelprincipal.setLayout(gbl_panelprincipal);
		
		
		Biniciar = new JButton("INICIAR");
		Biniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_Biniciar = new GridBagConstraints();
		gbc_Biniciar.insets = new Insets(0, 0, 5, 5);
		gbc_Biniciar.gridx = 0;
		gbc_Biniciar.gridy = 0;
		Panelprincipal.add(Biniciar, gbc_Biniciar);
		Biniciar.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Iniciar:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		Panelprincipal.add(lblNewLabel, gbc_lblNewLabel);
		
		TIniciar = new JTextField();
		GridBagConstraints gbc_tIniciar = new GridBagConstraints();
		gbc_tIniciar.insets = new Insets(0, 0, 5, 0);
		gbc_tIniciar.fill = GridBagConstraints.HORIZONTAL;
		gbc_tIniciar.gridx = 2;
		gbc_tIniciar.gridy = 0;
		Panelprincipal.add(TIniciar, gbc_tIniciar);
		TIniciar.setColumns(10);
		
		Bdetener = new JButton("DETENER");
		GridBagConstraints gbc_Bdetener = new GridBagConstraints();
		gbc_Bdetener.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_Bdetener.insets = new Insets(0, 0, 5, 5);
		gbc_Bdetener.gridx = 0;
		gbc_Bdetener.gridy = 1;
		Panelprincipal.add(Bdetener, gbc_Bdetener);
		this.Bdetener.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("Detenerse:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		Panelprincipal.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		Tdetenerse = new JTextField();
		GridBagConstraints gbc_tdetenerse = new GridBagConstraints();
		gbc_tdetenerse.insets = new Insets(0, 0, 5, 0);
		gbc_tdetenerse.fill = GridBagConstraints.HORIZONTAL;
		gbc_tdetenerse.gridx = 2;
		gbc_tdetenerse.gridy = 1;
		Panelprincipal.add(Tdetenerse, gbc_tdetenerse);
		Tdetenerse.setColumns(10);
		
		Bsalida = new JButton("SALIR");
		GridBagConstraints gbc_Bsalida = new GridBagConstraints();
		gbc_Bsalida.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_Bsalida.insets = new Insets(0, 0, 0, 5);
		gbc_Bsalida.gridx = 0;
		gbc_Bsalida.gridy = 2;
		Panelprincipal.add(Bsalida, gbc_Bsalida);
		
		JLabel lblNewLabel_2 = new JLabel("Tiempo transcurrido:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		Panelprincipal.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		Tsalida = new JTextField();
		GridBagConstraints gbc_tsalida = new GridBagConstraints();
		gbc_tsalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_tsalida.gridx = 2;
		gbc_tsalida.gridy = 2;
		Panelprincipal.add(Tsalida, gbc_tsalida);
		Tsalida.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==Biniciar)
		{
			this.tiempoinicio = System.currentTimeMillis();
			this.TIniciar.setText(String.valueOf( this.tiempoinicio));
			this.Tdetenerse.setText("");
			this.Tsalida.setText("");
		}
		else
			if(e.getSource()==Bdetener) 
			{
				this.tiempodetener = System.currentTimeMillis();
				this.Tdetenerse.setText(String.valueOf(tiempodetener));
				this.tiemposalida = (this.tiempodetener-this.tiempoinicio)/1000;
				this.Tsalida.setText(String.valueOf(this.tiemposalida));
			}
			else
				if(e.getSource()==Bsalida)
					this.dispose();
		
		
	}

}
