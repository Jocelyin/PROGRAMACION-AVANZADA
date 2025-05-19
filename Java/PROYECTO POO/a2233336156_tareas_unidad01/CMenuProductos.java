package a2233336156_tareas_unidad01;

import java.io.IOException;
import java.util.ArrayList;

import Clases.Cproducto;
import Clases.Lista;
import Librerias.Libreria;

public class CMenuProductos {

	public void ModificarProducto(Lista<Cproducto> vproductos) throws IOException {
        String codigo, precio;
        int posicion;
        String info = vproductos.MostrarLista();
        codigo = Libreria.Leer(info + "\nIntroduce el codigo del producto a modificar");
        if (codigo != null) {
        	Cproducto producto= new Cproducto(codigo,"","","");
        	if (vproductos.existe(producto))
        	{
               
                producto = vproductos.obtener(producto);
                precio = Libreria.Leer("\nIntroduce el precio de " + producto.toString() + " ");
                
                if (precio != null) {
                    if (Libreria.EvaluarNumerico(precio, 2) || Libreria.EvaluarNumerico(precio, 1)) {
                        producto.setPrecio(precio);
                        vproductos.modificar(vproductos.posicion(producto), producto);
                    } else {
                        System.out.println("no es un valor numerico");
                    }
                } else {
                    System.out.println("dato nulo");
                }
            } else {
                System.out.println("no existe el codigo");
            }
        } else {
            System.out.println("dato nulo");
        }
    }


    public CMenuProductos(Lista<Cproducto> vproductos) throws IOException {
        ArrayList<String> datosmenuproductos = new ArrayList();

        datosmenuproductos.add("1.-Modificar ");
        datosmenuproductos.add("2.-Listado ");
        datosmenuproductos.add("3.-Salida ");

        String opcion = "0";
        do {
            opcion = Libreria.DesplegarMenu("Opciones de Productos", datosmenuproductos);
            if (opcion == null)
                System.out.println("opcion incorrecta ");
            else
                switch (opcion) {
                    case "1":
                        ModificarProducto(vproductos);
                        break;
                    case "2":
                        System.out.println(vproductos.MostrarLista());
                        break;
                    case "3":
                        System.out.println("Salida del Sistema ");
                        break;
                    default:
                        System.out.println("No existe esta opcion ");
                        break;
                }
        } while (opcion.compareTo("3") != 0);
    }
	
}
