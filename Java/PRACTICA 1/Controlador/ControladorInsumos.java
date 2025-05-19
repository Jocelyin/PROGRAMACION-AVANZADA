package Controlador;

import java.awt.event.*;
import javax.swing.*;
import Modelo.*;
import Vista.VistaInsumos;

public class ControladorInsumos {
    private VistaInsumos vista;
    private Lista<Insumo> listaInsumos;
    private Lista<Categoria> listaCategorias;
    private int idInsumo = 1; // contador autoincremental para los insumos

    public ControladorInsumos(VistaInsumos vista, Lista<Insumo> listaInsumos, Lista<Categoria> listaCategorias) {
        this.vista = vista;
        this.listaInsumos = listaInsumos;
        this.listaCategorias = listaCategorias;

        // Cargar las categorías en el ComboBox
        cargarCategorias();

        // Cargar la lista de insumos en la interfaz
        cargarListaInsumos();
        
        ControladorArchivo.guardarInsumos(listaInsumos); // Guarda insumos actuales
        
        ControladorArchivo.guardarCategorias(listaCategorias); // Guarda categorías

        // Agregar eventos a los botones
        this.vista.btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarInsumo();
            }
        });

        this.vista.btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarInsumo();
            }
        });

        this.vista.btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarInsumo();
            }
        });

        this.vista.btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Evento al seleccionar un insumo en la lista
        this.vista.listaInsumos.addListSelectionListener(e -> seleccionarInsumo());
    }

    // Método para cargar categorías en el combo box
    private void cargarCategorias() {
        this.vista.comboCategorias.removeAllItems();
        for (Categoria cat : listaCategorias.obtenerLista()) {
            this.vista.comboCategorias.addItem(cat.getNombre());
        }
    }

    // Método para cargar insumos en la lista visual
    private void cargarListaInsumos() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Insumo ins : listaInsumos.obtenerLista()) {
            modelo.addElement(ins.getNombre() + " - $" + ins.getPrecio() + " (" + ins.getCategoria().getNombre() + ")");
        }
        this.vista.listaInsumos.setModel(modelo);
    }

    // Método para guardar un nuevo insumo
    private void guardarInsumo() {
        String nombre = this.vista.txtNombre.getText();
        String precioStr = this.vista.txtPrecio.getText();
        String nombreCategoria = (String) this.vista.comboCategorias.getSelectedItem();

        if (nombre.isEmpty() || precioStr.isEmpty() || nombreCategoria == null) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos.");
            return;
        }

        double precio = Double.parseDouble(precioStr);

        // Buscar categoría seleccionada
        Categoria categoria = null;
        for (Categoria cat : listaCategorias.obtenerLista()) {
            if (cat.getNombre().equals(nombreCategoria)) {
                categoria = cat;
                break;
            }
        }

        // Crear y agregar insumo
        Insumo insumo = new Insumo(idInsumo++, nombre, precio, categoria);
        listaInsumos.insertar(insumo);
        cargarListaInsumos();
        limpiarCampos();
    }

    // Método para modificar insumo seleccionado
    private void modificarInsumo() {
        int index = this.vista.listaInsumos.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un insumo.");
            return;
        }

        String nombre = this.vista.txtNombre.getText();
        String precioStr = this.vista.txtPrecio.getText();
        String nombreCategoria = (String) this.vista.comboCategorias.getSelectedItem();

        if (nombre.isEmpty() || precioStr.isEmpty() || nombreCategoria == null) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos.");
            return;
        }

        double precio = Double.parseDouble(precioStr);

        // Buscar categoría
        Categoria categoria = null;
        for (Categoria cat : listaCategorias.obtenerLista()) {
            if (cat.getNombre().equals(nombreCategoria)) {
                categoria = cat;
                break;
            }
        }

        // Modificar insumo
        Insumo insumo = listaInsumos.obtenerLista().get(index);
        insumo.setNombre(nombre);
        insumo.setPrecio(precio);
        insumo.setCategoria(categoria);

        cargarListaInsumos();
        limpiarCampos();
    }

    // Método para eliminar insumo seleccionado
    private void eliminarInsumo() {
        int index = this.vista.listaInsumos.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un insumo.");
            return;
        }

        listaInsumos.obtenerLista().remove(index);
        cargarListaInsumos();
        limpiarCampos();
    }

    // Método para limpiar los campos
    private void limpiarCampos() {
        this.vista.txtNombre.setText("");
        this.vista.txtPrecio.setText("");
        this.vista.comboCategorias.setSelectedIndex(-1);
        this.vista.listaInsumos.clearSelection();
    }

    // Método para cargar los datos del insumo seleccionado en los campos de texto
    private void seleccionarInsumo() {
        int index = this.vista.listaInsumos.getSelectedIndex();
        if (index != -1) {
            Insumo insumo = listaInsumos.obtenerLista().get(index);
            this.vista.txtNombre.setText(insumo.getNombre());
            this.vista.txtPrecio.setText(String.valueOf(insumo.getPrecio()));
            this.vista.comboCategorias.setSelectedItem(insumo.getCategoria().getNombre());
        }
    }
}
