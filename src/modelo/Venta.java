package modelo;



import java.time.LocalDateTime;



public class Venta {

private int idVenta;

private String fecha;


private double total;

private double montoPagado;



// Constructor por defecto

public Venta() {

}



// Constructor con todos los atributos

public Venta(int idVenta, String fecha, double total, double montoPagado) {

this.idVenta = idVenta;

this.fecha = fecha;

this.total = total;

this.montoPagado = montoPagado;

}



// Getters y Setters

public int getIdVenta() {

return idVenta;

}



public void setIdVenta(int idVenta) {

this.idVenta = idVenta;

}



public String getFecha() { // Getter para el String de fecha

return fecha;

}



public void setFecha(String fecha) { // Setter para el String de fecha

this.fecha = fecha;

}



public double getTotal() {

return total;

}



public void setTotal(double total) {

this.total = total;

}



public double getMontoPagado() { // <-- ¡Añadir este getter!

return montoPagado;

}



public void setMontoPagado(double montoPagado) { // <-- ¡Añadir este setter!

this.montoPagado = montoPagado;

}



@Override

public String toString() {

return "Venta{" +

"idVenta=" + idVenta +

", fecha='" + fecha + '\'' +

", total=" + total +

", montoPagado=" + montoPagado +

'}';

}

}