package modelo;


public class Producto {
    private String codigoProducto;
    private String nombre;
    private double precioVenta;
    private int stock;
    private int limiteStock;

    // Constructor(es)
    public Producto() {
       
    }

    public Producto(String codigoProducto, String nombre, double precioVenta, int stock, int limiteStock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.limiteStock = limiteStock;
    }

    // Getters y Setters para cada atributo
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getLimiteStock() {
        return limiteStock;
    }

    public void setLimiteStock(int limiteStock) {
        this.limiteStock = limiteStock;
    }

    @Override
    public String toString() {
        return "Producto{" +
               "codigoProducto='" + codigoProducto + '\'' +
               ", nombre='" + nombre + '\'' +
               ", precioVenta=" + precioVenta +
               ", stock=" + stock +
               ", limiteStock=" + limiteStock +
               '}';
    }
}
