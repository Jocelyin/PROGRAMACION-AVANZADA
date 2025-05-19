package Clases;

import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
    private List<T> lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }

    // Insertar un elemento
    public void insertar(T elemento) {
        lista.add(elemento);
    }

    // Eliminar un elemento si existe
    public boolean eliminar(T elemento) {
        return lista.remove(elemento);
    }

    // Modificar un objeto si existe
    public boolean modificar(T elementoAntiguo, T elementoNuevo) {
        int indice = lista.indexOf(elementoAntiguo);
        if (indice != -1) {
            lista.set(indice, elementoNuevo);
            return true;
        }
        return false;
    }
    
    public boolean modificar(T elementoNuevo,int pos) {
            lista.set(pos, elementoNuevo);
            return true;

    }

    public boolean modificar(int pos ,T elementoNuevo) {
            lista.set(pos, elementoNuevo);
            return true;
    }

    // Verificar si un elemento existe
    public boolean existe(T elemento) {
        return lista.contains(elemento);
    }
    
 
    
    // Obtener la posici�n de un elemento
    public int posicion(T elemento) {
        return lista.indexOf(elemento);
    }

    // Listar todos los elementos usando toString()
    @Override
    public String toString() {
        return lista.toString();
    }

    
    // Obtener el tama�o de la lista
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
    
    
    public String MostrarLista() {
        StringBuilder resultado = new StringBuilder();
        for (T elemento : lista) {
            resultado.append(elemento.toString()).append("\n");
        }
        return resultado.toString();
    }
    
    public List<T> getLista()
    {
    	return this.lista;
    	
    }
    
}