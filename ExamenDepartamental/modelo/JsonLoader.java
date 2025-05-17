package modelo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonLoader {

    public static List<Entidad> cargarEntidades(String rutaArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        List<Entidad> entidades = null;

        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                System.out.println("⚠️ Error: El archivo " + rutaArchivo + " no existe.");
                return null;
            }

            entidades = mapper.readValue(archivo, mapper.getTypeFactory().constructCollectionType(List.class, Entidad.class));
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer el JSON: " + e.getMessage());
        }

        return entidades;
    }
}

