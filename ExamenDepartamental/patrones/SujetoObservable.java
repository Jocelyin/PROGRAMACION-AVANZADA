package patrones;

	import java.util.ArrayList;
import java.util.List;

import vista.Observador;
import vista.VistaEntidades;

	public class SujetoObservable {
	    private List<Observador> observadores = new ArrayList<>();

	    public void agregarObservador(VistaEntidades vista) {
	        observadores.add((Observador) vista);
	    }

	    public void notificarObservadores() {
	        for (Observador obs : observadores) {
	            obs.actualizar();
	        }
	    }
	}


