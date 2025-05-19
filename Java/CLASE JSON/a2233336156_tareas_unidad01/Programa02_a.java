package a2233336156_tareas_unidad01;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Unidad1.Modelo.Producto;

public class Programa02_a {
    public static void main(String[] args) {
        List<Producto> lista = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = "";

        // Creando productos
        Producto producto1 = new Producto();
        producto1.setIdproducto("1");
        producto1.setProducto("Producto 1");
        producto1.setDescripcion("Descripcion 1");
        producto1.setCantidad("10");
        producto1.setPrecio("100");
        producto1.setidcategoria("1");
        lista.add(producto1);

        Producto producto2 = new Producto("002", "Producto 2", "20", "200", "2");
        lista.add(producto2);

        // Convertir a JSON
        json = gson.toJson(lista);
        System.out.println(json);

        // Convertir lista de productos a JSONArray
        for (Producto producto : lista) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID Producto", producto.getIdproducto());
            jsonObject.put("Producto", producto.getProducto());
            jsonObject.put("Descripción", producto.getDescripcion());
            jsonObject.put("Cantidad", producto.getCantidad());
            jsonObject.put("Precio", producto.getPrecio());
            jsonObject.put("ID Categoría", producto.getidcategoria());

            jsonArray.add(jsonObject);
        }

        // Guardar en archivo JSON
        try (FileWriter file = new FileWriter("producto2.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer archivo JSON
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("producto2.json")));
            JSONArray readArray = (JSONArray) org.json.simple.JSONValue.parse(jsonContent);

            for (Object obj : readArray) {
                JSONObject jsonObject = (JSONObject) obj;
                Producto producto = new Producto();
                producto.setIdproducto((String) jsonObject.get("ID Producto"));
                producto.setProducto((String) jsonObject.get("Producto"));
                producto.setDescripcion((String) jsonObject.get("Descripción"));
                producto.setCantidad((String) jsonObject.get("Cantidad"));
                producto.setPrecio((String) jsonObject.get("Precio"));
                producto.setidcategoria((String) jsonObject.get("ID Categoría"));

                // Imprimir para verificar
                System.out.println("ID Producto: " + producto.getIdproducto());
                System.out.println("Producto: " + producto.getProducto());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	}