package Clases;

public class Cpticket  extends Cproducto {

	public Cpticket(String id, String producto, String precio, String cantidad) {
		super(id, producto, precio, cantidad);
		// TODO Auto-generated constructor stub
	}
	
	public String subTotal()
	{
		
			double subtotal = 0; 
			subtotal = Double.parseDouble(this.getPrecio()) * Double.parseDouble(this.getCantidad()); 
			return String.valueOf(subtotal); 
	}
	

	
	
	@Override
	public String toString() {
		String codigo = String.format("%1$-" + 5 + "s", this.getId());
		String producto =String.format("%1$-" + 30 + "s", this.getProducto()); 
		String precio = String.format("%1$-" + 10 + "s", this.getPrecio());
		String cantidad =String.format("%1$-" + 10 + "s", this.getCantidad()); 
		String subtotal =String.format("%1$-" + 10 + "s", this.subTotal()); 
		String cadena = codigo.concat(producto+precio+cantidad+subtotal); 
		return cadena; 
	}



	public String toStringTicket()
	{
		return this.toString()+String.format("%1$-" + 10 + "s", this.subTotal()); 
	}
	

}
