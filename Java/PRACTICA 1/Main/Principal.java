package Main;

import Controlador.ControladorInsumos;
import Modelo.Categoria;
import Modelo.Insumo;
import Modelo.Lista;
import Vista.VistaInsumos;

public class Principal {

    	    public static void main(String[] args) {
    	        // Crear lista de categorías simulando las que el usuario ya agregó
    	        Lista<Categoria> categorias = new Lista<>();
    	        categorias.insertar(new Categoria(1, "Papelería"));
    	        categorias.insertar(new Categoria(2, "Oficina"));
    	        categorias.insertar(new Categoria(3, "Limpieza"));

    	        // Crear lista de insumos vacía
    	        Lista<Insumo> insumos = new Lista<>();

    	        // Crear Vista
    	        VistaInsumos vista = new VistaInsumos();

    	        // Conectar todo con el Controlador
    	        new ControladorInsumos(vista, insumos, categorias);

    	        // Mostrar la ventana
    	        vista.setVisible(true);
    	    }
    	}










//import Controlador.ControladorPractica01_01;
//import Controlador.ControladorPractica01_02;
//import Controlador.ControladorPractica01_03;
//import Controlador.ControladorPractica02_a;
//import Controlador.ControladorPractica02_b2;
//import Controlador.ControladorInsumos;
//import Controlador.ControladorCategorias;

//public class Principal {
   // public static void main(String[] args) {
        //new ControladorPractica01_01(); // Iniciar el controlador
        //new ControladorPractica01_02();
        //new ControladorPractica01_03();
        //new ControladorPractica02_a(); 
    	//new ControladorPractica02_b2();
    	//new ControladorInsumos();
    	//new ControladorCategorias();
