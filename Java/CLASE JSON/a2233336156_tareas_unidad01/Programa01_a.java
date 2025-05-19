package a2233336156_tareas_unidad01;

import Unidad1.Modelo.Producto;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Programa01_a {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	List<Producto> lista = new ArrayList<Producto>();
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = "";
	Producto producto1 = new Producto();
	producto1.getIdproducto();
	producto1.getProducto("Producto 1");
	producto1.getDescripcion("Descripcion 1");
	producto1.getCantidad("10");
	producto1.getPrecio("100");
	producto1.getIdcategoria("1");
	Producto producto2 = new Producto("002","Producto 2","20","200","2");
	lista.add(producto2);
	
	json = gson.toJson(lista);
	System.out.println(json);
	
	try {
		FileWriter file = new FileWriter("producto.json");
		file.write(json);
		file.flush();
		file.close();
	}catch (IOException e) {
		e.printStackTrace();
	}
	}
	}
	
	//se importa el (java.lang.reflect)
	//Type lisType = new TypeToken<List<Producto>>() {}.getType()	;
	//try (FileReader reader = new FileReader("producto.json")){
	
	//List<Producto> LectLista = gson.tronJson(reader,List<Producto>);
		//for(Producto nodo:lectlista)
		//System.out.println(nodo.getIdproducto());
		//System.out.println(nodo.Producto());
		//System.out.println(nodo.setDescripcion());
		//System.out.println(nodo.setCantidad());
		//System.out.println(nodo.setPrecio());
		//System.out.println(nodo.setidcategoria());
		//}
		
	//}catch (IOException e) {
//		e.printStackTrace();
	//}
 

//}
