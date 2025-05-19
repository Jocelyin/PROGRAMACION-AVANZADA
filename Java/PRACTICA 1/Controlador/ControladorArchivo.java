package Controlador;

import Modelo.ArchivoTxt;
import Modelo.Insumo;
import Modelo.Categoria;
import Modelo.Lista;

public class ControladorArchivo {

    // Guardar insumos en archivo
    public static void guardarInsumos(Lista<Insumo> listaInsumos) {
        ArchivoTxt.guardarLista(listaInsumos.obtenerLista(), "insumos.txt");
    }

    // Guardar categorías en archivo
    public static void guardarCategorias(Lista<Categoria> listaCategorias) {
        ArchivoTxt.guardarLista(listaCategorias.obtenerLista(), "categorias.txt");
    }

    // Leer archivo de insumos
    public static void leerInsumos() {
        ArchivoTxt.leerArchivo("insumos.txt");
    }

    // Leer archivo de categorías
    public static void leerCategorias() {
        ArchivoTxt.leerArchivo("categorias.txt");
    }
}
