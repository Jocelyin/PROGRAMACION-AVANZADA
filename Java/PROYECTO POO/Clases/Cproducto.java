package Clases;

import java.util.Objects;

public class Cproducto implements Iproductos {

	private String id,producto,precio,cantidad;
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getProducto() {
		// TODO Auto-generated method stub
		return this.producto;
	}

	@Override
	public String getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

	@Override
	public String getCantidad() {
		// TODO Auto-generated method stub
		return this.cantidad;
	}

	@Override
	public void setId(String id) {
			this.id=id;	
	}

	@Override
	public void setProducto(String producto) {
	this.producto=producto;
		
	}

	@Override
	public void setPrecio(String precio) {
		this.precio=precio;
		
	}

	@Override
	public void setCantidad(String cantidad) {
		this.cantidad=cantidad;
	}
	
	
	
	

	@Override
	public String toString() {
		String codigo = String.format("%1$-" + 5 + "s", this.getId());
		String producto =String.format("%1$-" + 30 + "s", this.getProducto()); 
		String precio = String.format("%1$-" + 10 + "s", this.getPrecio());
		String cantidad =String.format("%1$-" + 10 + "s", this.getCantidad()); 
		String cadena = codigo.concat(producto+precio+cantidad); 
		return cadena; 
	}

	public Cproducto(String id, String producto, String precio, String cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cproducto other = (Cproducto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
