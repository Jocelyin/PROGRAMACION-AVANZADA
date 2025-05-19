package a2233336156_tareas_unidad01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DialogoProducto extends JDialog {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JTextField txtId, txtProducto, txtPrecio, txtCantidad;
	    private JButton btnGuardar, btnCancelar;
	    private boolean esAgregar;
	    private boolean guardado;
	    private CProducto1 producto;

	    public DialogoProducto(JFrame parent, boolean esAgregar, CProducto1 seleccionado) {
	        super(parent, esAgregar ? "Agregar Producto" : "Modificar Precio", true);
	        this.esAgregar = esAgregar;
	        this.producto = seleccionado;
	        this.guardado = false;
	        setLayout(new GridBagLayout());
	        setSize(300, 250);

	        GridBagConstraints gbc;
	        JPanel panelId = new JPanel(new FlowLayout());
	        panelId.add(new JLabel("ID: "));
	        txtId = new JTextField(15);
	        panelId.add(txtId);
	        gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.insets = new Insets(5, 5, 5, 5);
	        getContentPane().add(panelId, gbc);

	        JPanel panelProducto = new JPanel(new FlowLayout());
	        panelProducto.add(new JLabel("Producto: "));
	        txtProducto = new JTextField(15);
	        panelProducto.add(txtProducto);
	        gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.insets = new Insets(5, 5, 5, 5);
	        getContentPane().add(panelProducto, gbc);

	        JPanel panelPrecio = new JPanel(new FlowLayout());
	        panelPrecio.add(new JLabel("Precio: "));
	        txtPrecio = new JTextField(15);
	        panelPrecio.add(txtPrecio);
	        gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.insets = new Insets(5, 5, 5, 5);
	        getContentPane().add(panelPrecio, gbc);

	        JPanel panelCantidad = new JPanel(new FlowLayout());
	        panelCantidad.add(new JLabel("Cantidad: "));
	        txtCantidad = new JTextField(15);
	        panelCantidad.add(txtCantidad);
	        gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.insets = new Insets(5, 5, 5, 5);
	        getContentPane().add(panelCantidad, gbc);

	        JPanel panelBotones = new JPanel(new FlowLayout());
	        btnGuardar = new JButton("Guardar");
	        btnCancelar = new JButton("Cancelar");
	        panelBotones.add(btnGuardar);
	        panelBotones.add(btnCancelar);
	        gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.gridx = 0;
	        gbc.gridy = 4;
	        gbc.insets = new Insets(5, 5, 5, 5);
	        getContentPane().add(panelBotones, gbc);

	        if (seleccionado != null) {
	            txtId.setText(seleccionado.getId());
	            txtProducto.setText(seleccionado.getProducto());
	            txtPrecio.setText(seleccionado.getPrecio());
	            txtCantidad.setText(seleccionado.getCantidad());
	            if (!esAgregar) {
	                txtId.setEnabled(false);
	                txtProducto.setEnabled(false);
	                txtCantidad.setEnabled(false);
	            }
	        }

	        btnGuardar.addActionListener(e -> {
	            guardado = true;
	            setVisible(false);
	        });
	        btnCancelar.addActionListener(e -> setVisible(false));
	    }

	    public CProducto1 obtenerProducto() {
	        return new CProducto1(txtId.getText(), txtProducto.getText(), txtPrecio.getText(), txtCantidad.getText());// Aqui sale un error
	    }
	    
	    public boolean fueGuardado() {
	        return guardado;
	    }
	}
