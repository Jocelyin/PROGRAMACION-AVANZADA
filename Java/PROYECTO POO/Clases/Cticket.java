package Clases;

public class Cticket {
private String id;
private String fecha;
private String hora;
private Lista<Cpticket> productos;





public Cticket(String id, String fecha, String hora) {
	super();
	this.id = id;
	this.fecha = fecha;
	this.hora = hora;
	this.productos = new Lista<Cpticket>();
	
}
public String getId() {
	return id;
}
public String getFecha() {
	return fecha;
}
public String getHora() {
	return hora;
}
public Lista<Cpticket> getProductos() {
	return productos;
}
public void setId(String id) {
	this.id = id;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public void setHora(String hora) {
	this.hora = hora;
}
public void setProductos(Lista<Cpticket> productos) {
	this.productos = productos;
}


public String subtotal ()
{
	double subtotal=0;
	for(Object nodo : this.productos.getLista() )
		subtotal = subtotal +Double.parseDouble(((Cpticket) nodo).subTotal());
	return String.valueOf(subtotal);
}
public String IvaTicket() {
	double subtotal = Double.parseDouble(this.subtotal());
	if (subtotal>0)
	subtotal = 0.16 * subtotal;
	else
		subtotal=-1;
	return String.valueOf(subtotal); 
	} 

public String TotalTicket() {
	double subtotal = Double.parseDouble(this.subtotal());
	return String.valueOf(Double.parseDouble(this.subtotal())+Double.parseDouble(this.IvaTicket())) ; 
	}



@Override
public String toString() {
		String salida = "";
		String subtotal=String.format("%.2f",this.subtotal());
		String iva=String.format("%.2f",this.IvaTicket());
		String total=String.format("%.2f",this.TotalTicket());
		salida = "Fecha " + fecha + "Ticket No." + this.getId(); 
		salida = salida + "\n" + this.productos.toString(); 
		salida = salida + "\n \n El total sin iva " + subtotal; 
		salida = salida + "\n el iva total es " + iva; 
		salida = salida + "\n el total de la venta fue " +total ; 
		return salida; 
		}

} 




