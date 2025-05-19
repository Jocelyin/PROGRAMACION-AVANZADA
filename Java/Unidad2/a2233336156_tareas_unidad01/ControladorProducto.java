package a2233336156_tareas_unidad01;

import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControladorProducto {
    private VistaProducto vistaProducto;
    private String archivo;
    private String tipoArchivo;
    private CArchivo<CProducto1> cArchivo;

    public ControladorProducto(VistaProducto vistaProducto, String archivo, String tipoArchivo) {
        this.vistaProducto = vistaProducto;
        this.archivo = archivo;
        this.tipoArchivo = tipoArchivo;

        cArchivo = new CArchivo<>(vistaProducto.getListaProductos().getLista(), CProducto1.class); //Aqui sale "Cannot infer type arguments for CArchivo
        cargarProductos();

        // Botones
        vistaProducto.getBtnAgregar().addActionListener(e -> agregarProducto());
        vistaProducto.getBtnModificar().addActionListener(e -> modificarProducto());
        vistaProducto.getBtnEliminar().addActionListener(e -> eliminarProducto());
        vistaProducto.getBtnSalir().addActionListener(e -> vistaProducto.dispose());
    }

    // Cargar productos desde el archivo
    private void cargarProductos() {
        try {
            switch (tipoArchivo) {
                case "Excel":
                    cArchivo.leerExcel(archivo);
                    break;
                case "JSON":
                    cArchivo.leerJSON(archivo);
                    break;
                case "XML":
                    cArchivo.leerXML(archivo);
                    break;
            }
            actualizarTabla();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(vistaProducto, "Error al leer archivo: " + ex.getMessage());
        }
    }

    // Actualizar tabla con lista
    private void actualizarTabla() {
        DefaultTableModel modelo = vistaProducto.getModelo();
        modelo.setRowCount(0); // Limpiar tabla
        for (CProducto1 p : vistaProducto.getListaProductos().getLista()) // Type mismatch:cannot convert from element type CProducto to CProducto
        {
            modelo.addRow(new Object[]{p.getId(), p.getProducto(), p.getPrecio(), p.getCantidad()});
        }
    }

    // Agregar Producto
    private void agregarProducto() {
        DialogoProducto dialogo = new DialogoProducto(vistaProducto, true, null);
        dialogo.setVisible(true);
        if (dialogo.fueGuardado()) {
            CProducto1 nuevo = dialogo.obtenerProducto();
            vistaProducto.getListaProductos().insertar(nuevo);
            actualizarTabla();
            guardarArchivo();
        }
    }

    // Modificar Producto
    private void modificarProducto() {
        int fila = vistaProducto.getTabla().getSelectedRow();
        if (fila >= 0) {
            CProducto1 seleccionado = vistaProducto.getListaProductos().getLista().get(fila);// Type mismatch:cannot convert from element type CProducto to CProducto
            DialogoProducto dialogo = new DialogoProducto(vistaProducto, false, seleccionado);
            dialogo.setVisible(true);
            if (dialogo.fueGuardado()) {
                CProducto1 modificado = dialogo.obtenerProducto();
                vistaProducto.getListaProductos().modificar(seleccionado, modificado);
                actualizarTabla();
                guardarArchivo();
            }
        } else {
            JOptionPane.showMessageDialog(vistaProducto, "Selecciona un producto para modificar.");
        }
    }

    // Eliminar Producto
    private void eliminarProducto() {
        int fila = vistaProducto.getTabla().getSelectedRow();
        if (fila >= 0) {
            CProducto1 seleccionado = vistaProducto.getListaProductos().getLista().get(fila);
            vistaProducto.getListaProductos().eliminar(seleccionado);
            actualizarTabla();
            guardarArchivo();
        } else {
            JOptionPane.showMessageDialog(vistaProducto, "Selecciona un producto para eliminar.");
        }
    }

    // Guardar cambios en archivo
    private void guardarArchivo() {
        try {
            switch (tipoArchivo) {
                case "Excel":
                    cArchivo.guardarExcel(archivo);
                    break;
                case "JSON":
                    cArchivo.guardarJSON(archivo);
                    break;
                case "XML":
                    cArchivo.guardarXML(archivo);
                    break;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(vistaProducto, "Error al guardar archivo: " + ex.getMessage());
        }
    }
}
