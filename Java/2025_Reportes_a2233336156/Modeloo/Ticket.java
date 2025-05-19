package Modeloo;

public class Ticket {

	    private String idticket;
	    private String fecha, hora;
	    private String idproducto, producto;
	    private String precio, cantidad, iva, total;

	    // Constructor
	    public Ticket(String idticket, String fecha, String hora, String idproducto, String producto,
	                  String precio, String cantidad, String iva, String total) {
	        this.idticket = idticket;
	        this.fecha = fecha;
	        this.hora = hora;
	        this.idproducto = idproducto;
	        this.producto = producto;
	        this.precio = precio;
	        this.cantidad = cantidad;
	        this.iva = iva;
	        this.total = total;
	    }

	    // Getters y Setters
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

	    public String getIdproducto() {
	        return idproducto;
	    }

	    public void setIdproducto(String idproducto) {
	        this.idproducto = idproducto;
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

	    public String getIva() {
	        return iva;
	    }

	    public void setIva(String iva) {
	        this.iva = iva;
	    }

	    public String getTotal() {
	        return total;
	    }

	    public void setTotal(String total) {
	        this.total = total;
	    }
	}


