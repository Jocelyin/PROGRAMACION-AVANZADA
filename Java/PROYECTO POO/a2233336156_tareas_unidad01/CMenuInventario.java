package a2233336156_tareas_unidad01;

import java.io.IOException;
import java.util.ArrayList;

import Clases.Cproducto;
import Clases.Lista;
import Librerias.Libreria;

public class CMenuInventario {

	
	
	 public void AgregarStock(Lista<Cproducto> vproductos) throws IOException {
	        int posicion;
	        String codigo, cantidad;
	        String info = vproductos.MostrarLista();
	        codigo = Libreria.Leer(info + "\nIntroduce el codigo del producto a modificar");
	        if (codigo != null) 
	        {
	        	 Cproducto producto = new Cproducto(codigo, "","","");      
	        	if(vproductos.existe(producto))
	        	{
	        		producto = vproductos.obtener(producto);
	        	
	        
	                 cantidad = Libreria.Leer("\nIntroduce la Cantidad de Stock a Agregar" + producto.toString());
	                 if (cantidad != null) { 
	                    if (Libreria.EvaluarNumerico(cantidad, 2) || Libreria.EvaluarNumerico(cantidad, 1)) 
	                    {
	                        String nuevacantidad = String.valueOf(Integer.valueOf(cantidad) + Integer.valueOf(producto.getCantidad()));
	                        producto.setCantidad(nuevacantidad);
	                        vproductos.modificar(vproductos.posicion(producto), producto);
	                    } 
	                    else {
	                        System.out.println("no es un valor numerico");
	                    }
	                } 
	                 else {
	                    System.out.println("dato nulo");
	                }
	            } 
	        	else {
	                System.out.println("no existe el codigo");
	            }
	        } 
	        else {
	            System.out.println("dato nulo");
	        }
	    }

	   
	    
	    public  CMenuInventario(Lista<Cproducto> vproductos) throws IOException {
	    	 String opcion = "0";
	    	
	    	   ArrayList<String> datosmenuinventario = new ArrayList();

	    	   datosmenuinventario.add( "1. - Listado ");
	    	   datosmenuinventario.add("2. - Agregar ");
	    	   datosmenuinventario.add("3. - Salida " );
	    	
	        
	        do {
	            opcion = Libreria.DesplegarMenu("Opciones de Inventarios", datosmenuinventario);
	            if (opcion == null) {
	                System.out.println("opcion incorrecta ");
	            } else {
	                switch (opcion) {
	                    case "1":
	                        System.out.println(vproductos.MostrarLista());
	                        break;
	                    case "2":
	                        AgregarStock(vproductos);
	                        break;
	                    case "3":
	                        System.out.println("Salida del Sistema ");
	                        break;
	                    default:
	                        System.out.println("No existe esta opcion ");
	                        break;
	                }
	            }
	        } while (opcion.compareTo("3") != 0);
	    }

}