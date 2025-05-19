package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaInsumos extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Componentes
    public JTextField txtNombre, txtPrecio;
    public JComboBox<String> comboCategorias;
    public JButton btnGuardar, btnModificar, btnEliminar, btnLimpiar;
    public JList<String> listaInsumos;

    // Constructor
    public VistaInsumos() {
        setTitle("Gestión de Insumos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        // Panel superior: campos de texto y combo
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(4, 2, 5, 5));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiquetas y campos
        panelSuperior.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelSuperior.add(txtNombre);

        panelSuperior.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelSuperior.add(txtPrecio);

        panelSuperior.add(new JLabel("Categoría:"));
        comboCategorias = new JComboBox<>();
        panelSuperior.add(comboCategorias);

        panel.add(panelSuperior, BorderLayout.NORTH);

        // Panel centro: lista de insumos
        listaInsumos = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaInsumos);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior: botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4, 5, 5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        panel.add(panelBotones, BorderLayout.SOUTH);
    }
}

