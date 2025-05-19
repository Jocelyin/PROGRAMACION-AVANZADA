package Modelo;

public class Insumo {
    private int id;
    private String nombre;
    private Categoria categoria;
    private double precio;

    // Constructor
    public Insumo(int id, String nombre, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public Categoria getCategoria() { return categoria; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + categoria + " - $" + precio ;
    }
}
