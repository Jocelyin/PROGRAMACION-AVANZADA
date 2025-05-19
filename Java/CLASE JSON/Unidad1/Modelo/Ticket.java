package Unidad1.Modelo;

import java.util.List;
import java.util.Objects;

public class Ticket {
	private String idTicket;
	private List<Producto> productos;
	
	public Ticket() {
		
	}

	public Ticket(String idTicket, List<Producto> productos) {
		super();
		this.idTicket = idTicket;
		this.productos = productos;
	}

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	

}
