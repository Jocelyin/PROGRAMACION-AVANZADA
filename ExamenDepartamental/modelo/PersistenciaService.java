package modelo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PersistenciaService {
    public List<Entidad> cargarEntidades() {
        ObjectMapper mapper = new ObjectMapper();
        List<Entidad> entidades = null;

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("entidades.json");
            if (inputStream == null) {
                System.out.println("⚠️ Error: No se encontró entidades.json");
                return List.of(); // Devuelve una lista vacía si el archivo no existe
            }

            entidades = mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, Entidad.class));
        } catch (Exception e) {
            System.out.println("⚠️ Error al leer entidades.json: " + e.getMessage());
        }

        return entidades; 
    } 

    public void guardarEntidades(List<Entidad> entidades) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File archivo = new File("src/resources/entidades.json"); // AjustaAA la ruta si es necesario
            mapper.writeValue(archivo, entidades);
            System.out.println("✅ Entidades guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("⚠️ Error al guardar entidades: " + e.getMessage());
        }
    }
}


