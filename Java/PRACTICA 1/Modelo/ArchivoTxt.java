package Modelo;

import java.io.*;
import java.util.List;

public class ArchivoTxt {

    // Método para guardar una lista en archivo
    public static <T> void guardarLista(List<T> lista, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (T item : lista) {
                writer.write(item.toString());
                writer.newLine(); // Salto de línea
            }
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Método para leer un archivo completo (línea por línea)
    public static void leerArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido de " + nombreArchivo + ":");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
