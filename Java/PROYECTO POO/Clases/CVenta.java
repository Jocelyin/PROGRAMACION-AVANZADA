package Clases;

import java.util.Objects;

public class CVenta extends Cproducto {

	String idticket;
	String fecha;
	String hora;
	
	public CVenta(String id, String producto, String precio, String cantidad) {
		super(id, producto, precio, cantidad);
		// TODO Auto-generated constructor stub
	}
	
	public CVenta()
	{
		super("","", "", "");
		
	}

	public String getIdticket() {
		return idticket;
	}

	public void setIdticket(String idticket) {
		this.idticket = idticket;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash (idticket,this.getId());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof CVenta))
			return false;
		CVenta other = (CVenta) obj;
		return Objects.equals(this.getId(), other.getId()) && Objects.equals(idticket, other.idticket);
	}

	@Override
	public String toString() {
		String codigo = String.format("%1$-" + 5 + "s", this.getId());
		String producto =String.format("%1$-" + 30 + "s", this.getProducto()); 
		String precio = String.format("%1$-" + 10 + "s", this.getPrecio());
		String cantidad =String.format("%1$-" + 10 + "s", this.getCantidad()); 
		String fecha =String.format("%1$-" + 10 + "s", this.getFecha());
		String hora =String.format("%1$-" + 10 + "s", this.getHora());
		String idticket =String.format("%1$-" + 10 + "s", this.getIdticket());
		String cadena = codigo.concat(idticket+fecha+hora+producto+precio+cantidad); 
		return cadena; 
	}

	
	
	
	
}
