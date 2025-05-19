package a2233336156_tareas_unidad01;

	import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Clases.CVenta;
import Clases.Cproducto;
import Clases.Lista;
import Librerias.Larchivos;
import Librerias.Libreria;

	public class PrincipalPOO {

	    static Lista<Cproducto> productos;
	    static String ventas[][];
	    static int tamventas = 100;
	    static String fecha;

	    public static Lista<Cproducto> CargarProductos() {
	        Lista<Cproducto> producto = new Lista();

	        producto.insertar(new Cproducto("001", "Arroz 1kg", "35", "10"));
	        producto.insertar(new Cproducto("002", "Azúcar 1kg", "25", "10"));
	        producto.insertar(new Cproducto("003", "Harina 1kg", "28", "10"));
	        producto.insertar(new Cproducto("005", "Leche 1L", "35", "10"));
	        producto.insertar(new Cproducto("006", "Huevos 12 unidades", "45", "10"));
	        producto.insertar(new Cproducto("007", "Fideos 500g", "20", "10"));
	        producto.insertar(new Cproducto("008", "Sal 1kg", "15", "10"));
	        producto.insertar(new Cproducto("009", "Pasta de tomate 400g", "25", "10"));
	        producto.insertar(new Cproducto("010", "Atún lata 170g", "35", "10"));

	        return producto;
	    }
	    
	    
	    
	    
	   

	    public static void MenuPrincipal(Lista<Cproducto> vproductos) throws IOException {
	        ArrayList<String> datosmenuprincipal = new ArrayList();
	        datosmenuprincipal.add("1.-Productos ");
	        datosmenuprincipal.add("2.-Punto de Venta ");
	        datosmenuprincipal.add("3.- Inventario");
	        datosmenuprincipal.add("4.-Ventas");
	        datosmenuprincipal.add("5.-Salida ");

	        String opcion = "0";
	        String idticket;
	        
	        do {
	            opcion = Libreria.DesplegarMenu("Menu de Punto de Tienda de Abarrotes la Pequeñita", datosmenuprincipal);

	            if (opcion == null)
	                System.out.println("opcion incorrecta ");
	            else
	                switch (opcion) {
	                    case "1":
	                    	CMenuProductos menuproductos = new CMenuProductos(vproductos);
	                        break;
	                    case "2":
	                        System.out.println(productos.MostrarLista());
	                        break;
	                    case "3":
	                        CMenuInventario inventario = new CMenuInventario(vproductos);
	                        break;
	                    case "4":
	                        System.out.println("VENTAS");
	                        break;
	                    case "5":
	                        System.out.println("Salida del Sistema ");
	                        break;
	                    default:
	                        System.out.println("No existe esta opcion ");
	                        break;
	                }
	        } while (opcion.compareTo("5") != 0);
	    }

	    public static void main(String[] args) throws IOException {
	    	List Listaventa;
	    	CVenta objeto = new CVenta();
	        try {
	        	if(Larchivos.ExisteArchivo("Procutos.txt"))
	        		Listaventa = Larchivos.CargarCsv("Productos,txt", CVenta.class);
	        		
	        		
	        	else
	        		System.out.println("No hay Productos");
	            productos = CargarProductos();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        MenuPrincipal(productos);
	    }
	}



