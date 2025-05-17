package patrones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.DefinicionAtributo;
import modelo.Entidad;

public class EntidadFactory {
    public static Entidad crearEntidad(String identificadorUnico, List<DefinicionAtributo> definiciones, Map<String, Object> valores) {
        Map<String, Object> atributos = new HashMap<>();

        for (DefinicionAtributo definicion : definiciones) {
            atributos.put(definicion.getNombre(), valores.getOrDefault(definicion.getNombre(), null));
        }

        return new Entidad(identificadorUnico, atributos);
    }
}

