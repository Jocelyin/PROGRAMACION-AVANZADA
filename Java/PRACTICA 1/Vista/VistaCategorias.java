package Vista;

import javax.swing.*;

public class VistaCategorias extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId, txtNombre;
    private JButton btnAgregar;
    private JTextArea areaLista;

    public VistaCategorias() {
        setTitle("Gestión de Categorías");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(120, 20, 150, 25);
        txtId.setEditable(false); // ID automático
        add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 150, 25);
        add(txtNombre);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(120, 100, 150, 30);
        add(btnAgregar);

        areaLista = new JTextArea();
        areaLista.setBounds(20, 140, 350, 100);
        areaLista.setEditable(false);
        add(areaLista);
    }

    // Métodos públicos para acceder desde el controlador
    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JTextArea getAreaLista() { return areaLista; }
}
