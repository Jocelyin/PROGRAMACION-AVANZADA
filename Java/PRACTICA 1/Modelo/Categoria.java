package Modelo;

public class Categoria {
    private int id;
    private String nombre;

    // Constructor
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}