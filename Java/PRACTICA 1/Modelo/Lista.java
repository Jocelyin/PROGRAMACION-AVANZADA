package Modelo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * Clase generica para manejar listas de objetos (Modelo).
 * @param <T> Tipo de objeto.
 */
public class Lista<T> {
    private final List<T> lista;

    // Constructor
    public Lista() {
        this.lista = new ArrayList<>();
    }

    // Insertar un elemento si no existe
    public boolean insertar(T elemento) {
        if (!lista.contains(elemento)) {
            lista.add(elemento);
            return true;
        }
        return false; // Ya existe
    }

    // Eliminar un elemento si existe
    public boolean eliminar(T elemento) {
        return lista.remove(elemento);
    }

    // Modificar un elemento existente (reemplaza)
    public boolean modificar(T antiguo, T nuevo) {
        int index = lista.indexOf(antiguo);
        if (index != -1) {
            lista.set(index, nuevo);
            return true;
        }
        return false;
    }

    // Buscar un elemento y devolverlo como Optional
    public Optional<T> buscar(T elemento) {
        return lista.contains(elemento) ? Optional.of(elemento) : Optional.empty();
    }

    // Obtener lista completa (copia)
    public List<T> obtenerLista() {
        return new ArrayList<>(lista);
    }

    // Convertir lista a arreglo de Strings basado en un atributo dinámico
    public String[] toStringArreglo(String atributo) {
        String[] datos = new String[lista.size()];
        int pos = 0;

        for (T elemento : lista) {
            try {
                Field campo = elemento.getClass().getDeclaredField(atributo);
                campo.setAccessible(true);
                Object valor = campo.get(elemento);
                datos[pos] = (valor != null) ? valor.toString() : "null";
            } catch (NoSuchFieldException | IllegalAccessException e) {
                datos[pos] = "Atributo no encontrado";
            }
            pos++;
        }
        return datos;
    }

    // Rellenar un JComboBox con los elementos de la lista
    public JComboBox<T> agregarAComboBox(JComboBox<T> comboBox) {
        DefaultComboBoxModel<T> model = new DefaultComboBoxModel<>();
        for (T item : lista) {
            model.addElement(item);
        }
        comboBox.setModel(model);
        return comboBox;
    }
}
