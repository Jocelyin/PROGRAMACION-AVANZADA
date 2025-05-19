package a2233336156_tareas_unidad01;

import java.util.Objects;

public class CProducto1 {

	private String id, producto, precio, cantidad;

	@Override
	public int hashCode() {
		return Objects.hash(id, producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CProducto1 other = (CProducto1) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(id, other.id)
				&& Objects.equals(precio, other.precio) && Objects.equals(producto, other.producto);
	}

	public CProducto1(String id, String producto, String precio, String cantidad) {
	    this.id = id;
	    this.producto = producto;
	    this.precio = precio;
	    this.cantidad = cantidad;
	}
	
	public CProducto1() {
		super();
		this.id = null;
		this.producto = null;
		this.precio = null;
		this.cantidad = null;
		
	}

	@Override
	public String toString() {
		return this.getId().trim()+this.getProducto()+this.precio.trim()+this.cantidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
