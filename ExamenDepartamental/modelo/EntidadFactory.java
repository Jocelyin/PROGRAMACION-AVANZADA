package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntidadFactory {
    private static List<DefinicionAtributo> definiciones;

    public static void setDefiniciones(List<DefinicionAtributo> nuevasDefiniciones) {
        definiciones = nuevasDefiniciones;
    }

    public static Entidad crearEntidad(String identificadorUnico, Map<String, Object> valores) {
        if (definiciones == null || definiciones.isEmpty()) {
            throw new IllegalStateException("No hay definiciones de atributos disponibles.");
        }

        Map<String, Object> atributos = new HashMap<>();
        for (DefinicionAtributo definicion : definiciones) {
            atributos.put(definicion.getNombre(), valores.getOrDefault(definicion.getNombre(), null));
        }

        return new Entidad(identificadorUnico, atributos);
    }
}

