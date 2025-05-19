package Controlador;

import Modelo.Categoria;
import Modelo.Lista;
import Vista.VistaCategorias;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorCategorias implements ActionListener {

    private VistaCategorias vista;
    private Lista<Categoria> listaCategorias;
    private int idActual = 1; // ID automático

    public ControladorCategorias() {
        vista = new VistaCategorias();
        listaCategorias = new Lista<>();
        vista.getBtnAgregar().addActionListener(this);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            agregarCategoria();
        }
    }

    private void agregarCategoria() {
        String nombre = vista.getTxtNombre().getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor ingresa un nombre.");
            return;
        }

        Categoria nueva = new Categoria(idActual, nombre);
        listaCategorias.insertar(nueva);
        idActual++; // Incrementar ID

        vista.getTxtId().setText(String.valueOf(idActual)); // Mostrar próximo ID
        vista.getTxtNombre().setText(""); // Limpiar campo

        actualizarLista(); // Mostrar lista de categorías
    }

    private void actualizarLista() {
        StringBuilder listaTexto = new StringBuilder();
        for (Categoria categoria : listaCategorias.obtenerLista()) {
            listaTexto.append(categoria.toString()).append("\n");
        }
        vista.getAreaLista().setText(listaTexto.toString());
    }
}
