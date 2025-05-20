package modelo;

public class DetalleVenta {
    private int idDetalle;
    private int idVenta;
    private String codigoProducto;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;

    // Constructor por defecto
    public DetalleVenta() {
    }

    // Constructor con todos los atributos relevantes
    public DetalleVenta(int idVenta, String codigoProducto, int cantidad, double precioUnitario, double precioTotal) {
        this.idVenta = idVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }

    // Getters y Setters
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
               "idDetalle=" + idDetalle +
               ", idVenta=" + idVenta +
               ", codigoProducto='" + codigoProducto + '\'' +
               ", cantidad=" + cantidad +
               ", precioUnitario=" + precioUnitario +
               ", precioTotal=" + precioTotal +
               '}';
    }
}