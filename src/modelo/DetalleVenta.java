package modelo;

public class DetalleVenta {

private int idDetalle;

private int idVenta;

private String codigoProducto;

private String nombreProducto;

private int cantidad;

private double precioUnitario;

private double precioTotal;



// Constructor por defecto

public DetalleVenta() {

}




public DetalleVenta(int idDetalle, int idVenta, String codigoProducto, String nombreProducto, int cantidad, double precioUnitario, double precioTotal) {

this.idDetalle = idDetalle;

this.idVenta = idVenta;

this.codigoProducto = codigoProducto;

this.nombreProducto = nombreProducto;

this.cantidad = cantidad;

this.precioUnitario = precioUnitario;

this.precioTotal = precioTotal;

}




public DetalleVenta(int idVenta, String codigoProducto, String nombreProducto, int cantidad, double precioUnitario, double precioTotal) {

this.idVenta = idVenta;

this.codigoProducto = codigoProducto;

this.nombreProducto = nombreProducto;

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



public String getNombreProducto() {

return nombreProducto;

}



public void setNombreProducto(String nombreProducto) {

this.nombreProducto = nombreProducto;

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

", nombreProducto='" + nombreProducto + '\'' +

", cantidad=" + cantidad +

", precioUnitario=" + precioUnitario +

", precioTotal=" + precioTotal +

'}';

}}