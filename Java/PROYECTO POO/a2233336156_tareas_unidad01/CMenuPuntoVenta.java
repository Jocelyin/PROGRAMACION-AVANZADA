package a2233336156_tareas_unidad01;

import java.io.IOException;

import Clases.CVenta;
import Clases.Cproducto;
import Clases.Cpticket;
import Clases.Cticket;
import Clases.Lista;
import Librerias.Libreria;

public class CMenuPuntoVenta {

	public  CMenuPuntoVenta ( Lista<CVenta> ventas,String idticket,Lista<Cproducto> vproductos) throws IOException 
	{ 
		
	
	String opcion, membrete; 
	Boolean pago = false; 
	int tamticket=50;
	String[][] vticket = new String[tamticket][4];
	
	
	String fechadia = Fecha(); 
	idticket = Libreria.IdTicketSiguiente(idticket);
	Cticket Vticket = new Cticket(idticket,fechadia,"00:00");
	if (codigo=null) {
		Cproducto producto = new Cproducto(codigo,null,null,null)
				if(mproducto.existe(producto))
				{
					producto = mproducto.obtener(producto)
							System.out.println(producto.toString());
					
					int cant = Integer.parseInt(producto.getCantidad();
					if(cant>0)
					{
					 Cpticket productoticket = new Cpticket	(producto.getId(),"","","");
					 int pos = mticket.posicion(productoticket);
					if (pos>0)
					{
						
					    productoticket=ticket.obtener(productoticket);
					    int cant2 = Integer.parseInt(prodcutoticket.getCantidad()+1);
					    productoticket.setCantidad(String.valueOf(cant2));
						mticket.modificar(productoticket,pos);
					}
					
					//si esta el producto en el ticket
					else
					{
					productoticket.setCantidad("1");
					productoticket.setProducto(producto.getProducto());
					productoticket.setPrecio(producto.getPrecio());
					mticket.insertar(productoticket);
					}
					
					cant=cant--;
					producto.setCantidad(fechadia)
					//si no esta el producto en el ticket
					//si no hay productos
				}
					
					else
						System.out.println("No hay productos para venta.");
				}
					else
						System.out.println("El codigo no existe no se puede agregar.");
					
								
					
					
				}
	
	}
 
	
 	 

	
}
	

