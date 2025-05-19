package a2233336156_tareas_unidad01;


import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
    private List<T> lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }
    
    
 // Método para obtener la lista
    public List<T> getLista() {
        return lista; // Ahora devuelve la lista real
    }

    // Insertar un elemento
    public void insertar(CProducto1 nuevo) {
        lista.add((T) nuevo);
    }

    // Eliminar un elemento si existe
    public boolean eliminar(T elemento) {
        return lista.remove(elemento);
    }

    // Modificar un objeto si existe
    public boolean modificar(CProducto1 seleccionado, CProducto1 modificado) {
        int indice = lista.indexOf(seleccionado);
        if (indice != -1) {
            lista.set(indice, (T) modificado);
            return true;
        }
        return false;
    }

    // Verificar si un elemento existe
    public boolean existe(T elemento) {
        return lista.contains(elemento);
    }

    // Obtener la posición de un elemento
    public int posicion(T elemento) {
        return lista.indexOf(elemento);
    }

    // Listar todos los elementos usando toString()
    @Override
    public String toString() {
        return lista.toString();
    }

    // Obtener el tamaño de la lista
    public int size() {
        return lista.size();
    }

    // Obtener un elemento por su objeto
    public T obtener(T elemento) {
        int indice = lista.indexOf(elemento);
        if (indice != -1) {
            return lista.get(indice);
        }
        return null;
    }

    public String mostrarLista() {
        StringBuilder resultado = new StringBuilder();
        for (T elemento : lista) {
            resultado.append(elemento.toString()).append("\n");
        }
        return resultado.toString();
    }

	
}
