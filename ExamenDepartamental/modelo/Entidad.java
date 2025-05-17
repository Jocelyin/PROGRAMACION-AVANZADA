package modelo;

import java.util.Map;

public class Entidad {
    private String identificadorUnico;
    private Map<String, Object> atributos;

    public Entidad(String identificadorUnico, Map<String, Object> atributos) {
        this.identificadorUnico = identificadorUnico;
        this.atributos = atributos;
    }

    public String getIdentificadorUnico() {
        return identificadorUnico;
    }

    public Map<String, Object> getAtributos() {
        return atributos;
    }

    public void setAtributo(String clave, Object valor) {
        atributos.put(clave, valor);
    }
}

