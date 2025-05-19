package Modeloo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

	public class FactoryTicket {

	    // Lista de tickets estática
	    static List<Ticket> lista = new ArrayList<>();

	    // Método para asignar la lista desde fuera
	    public void setFactory(List<Ticket> datos) {
	        lista = datos;
	    }

	    // Método para devolver una colección de tickets
	    public static Collection<Ticket> Generar() {
	        if (lista == null) {
	            lista = new ArrayList<>();
	        }
	        return new ArrayList<>(lista);
	    }
	}



