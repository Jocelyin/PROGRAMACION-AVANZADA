package modelo;

public class DefinicionAtributo {
    private String nombre;
    private String tipo; // "String" o "Integer"

    public DefinicionAtributo(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
