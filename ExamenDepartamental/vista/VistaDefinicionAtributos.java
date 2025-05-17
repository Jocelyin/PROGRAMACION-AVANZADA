package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.DefinicionAtributo;
import patrones.SujetoObservable;
import controlador.ControladorEntidades;
import patrones.PersistenciaServiceSingleton;

public class VistaDefinicionAtributos extends JFrame {
    private JTextField txtNombreAtributo;
    private JComboBox<String> cmbTipoAtributo;
    private JButton btnAgregar, btnConfirmar;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaAtributos;
    private List<DefinicionAtributo> definiciones;

    public VistaDefinicionAtributos() {
        definiciones = new ArrayList<>();

        setTitle("Definir Atributos");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        txtNombreAtributo = new JTextField(10);
        cmbTipoAtributo = new JComboBox<>(new String[]{"String", "Integer"});
        btnAgregar = new JButton("Agregar");

        panelSuperior.add(new JLabel("Nombre:"));
        panelSuperior.add(txtNombreAtributo);
        panelSuperior.add(new JLabel("Tipo:"));
        panelSuperior.add(cmbTipoAtributo);
        panelSuperior.add(btnAgregar);

        add(panelSuperior, BorderLayout.NORTH);

        modeloLista = new DefaultListModel<>();
        listaAtributos = new JList<>(modeloLista);
        add(new JScrollPane(listaAtributos), BorderLayout.CENTER);

        btnConfirmar = new JButton("Confirmar Atributos");
        add(btnConfirmar, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAtributo();
            }
        });

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarAtributos();
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void agregarAtributo() {
        String nombre = txtNombreAtributo.getText().trim();
        String tipo = (String) cmbTipoAtributo.getSelectedItem();

        if (!nombre.isEmpty()) {
            definiciones.add(new DefinicionAtributo(nombre, tipo));
            modeloLista.addElement(nombre + " (" + tipo + ")");
            txtNombreAtributo.setText("");

            System.out.println("▶ Total de atributos en VistaDefinicionAtributos: " + definiciones.size()); // ✅ Verificación importante
        }
    }


    private VistaEntidades vistaEntidades; // ✅ Guarda la referencia a la ventana de entidades

    private void confirmarAtributos() {
        if (definiciones.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes agregar al menos un atributo.");
            return;
        }

        JOptionPane.showMessageDialog(this, "Atributos definidos correctamente.");

        if (vistaEntidades == null) { 
            SujetoObservable sujetoObservable = new SujetoObservable();
            vistaEntidades = new VistaEntidades(definiciones, sujetoObservable);
            vistaEntidades.setVisible(true);

            new ControladorEntidades(vistaEntidades, PersistenciaServiceSingleton.getInstancia().getPersistencia(), sujetoObservable);
        }

        dispose(); 
    }






    public List<DefinicionAtributo> getDefiniciones() {
        System.out.println("▶ Enviando atributos desde VistaDefinicionAtributos: " + definiciones.size()); // vvverificación
        return definiciones;
    }

}
