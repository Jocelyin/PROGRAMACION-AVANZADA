
	package a2233336156_tareas_unidad01;

	import Unidad1.Modelo.Producto;
	import Unidad1.Modelo.Ticket;
	import com.google.gson.Gson;
	import com.google.gson.GsonBuilder;
	import com.google.gson.reflect.TypeToken;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.lang.reflect.Type;
	import java.util.ArrayList;
	import java.util.List;

	public class Programa01_b {
	    public static void main(String[] args) {
	        List<Producto> lista = new ArrayList<>();
	        List<Ticket> lista2 = new ArrayList<>();

	        Gson gson = new GsonBuilder().setPrettyPrinting().create();

	        // Creando productos
	        Producto producto1 = new Producto();
	        producto1.getIdproducto("1");
	        producto1.getProducto("Producto 1");
	        producto1.getDescripcion("Descripcion 1");
	        producto1.getCantidad("10");
	        producto1.getPrecio("100");
	        producto1.getIdcategoria("1");

	        Producto producto2 = new Producto("002", "Producto 2", "20", "200", "2");

	        lista.add(producto1);
	        lista.add(producto2);

	        // Creando ticket
	        Ticket ticket1 = new Ticket();
	        ticket1.setIdTicket("001");
	        ticket1.setProductos(lista);
	        lista2.add(ticket1);

	        // Convertir a JSON
	        String json = gson.toJson(lista2);
	        System.out.println(json);

	        // Guardar en un archivo JSON
	        try (FileWriter file = new FileWriter("ticket.json")) {
	            file.write(json);
	            file.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Leer archivo JSON
	        try (FileReader reader = new FileReader("ticket.json")) {
	            Type listType = new TypeToken<List<Ticket>>() {}.getType();
	            List<Ticket> tickets = gson.fromJson(reader, listType);

	            // Imprimir tickets y productos
	            for (Ticket ticket : tickets) {
	                System.out.println("Ticket ID: " + ticket.getIdTicket());
	                System.out.println("Productos:");

	                for (Producto producto : ticket.getProductos()) {
	                    System.out.println("ID Producto: " + producto.getIdproducto());
	                    System.out.println("Producto: " + producto.getProducto());
	                    System.out.println("Descripción: " + producto.getDescripcion());
	                    System.out.println("Cantidad: " + producto.getCantidad());
	                    System.out.println("Precio: " + producto.getPrecio());
	                    System.out.println("ID Categoría: " + producto.getIdcategoria());
	                }
	                System.out.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
