package principal;

import controlador.ControladorDefinicionAtributos;
import controlador.ControladorEntidades;
import patrones.PersistenciaServiceSingleton;
import patrones.SujetoObservable; // ✅ Importamos SujetoObservable
import vista.VistaDefinicionAtributos;
import vista.VistaEntidades;

public class Main {
    public static void main(String[] args) {
        // **Definir atributos dinámicos**
        VistaDefinicionAtributos vistaDefinicion = new VistaDefinicionAtributos();
        ControladorDefinicionAtributos controladorDefinicion = new ControladorDefinicionAtributos(vistaDefinicion);

        // **Esperar a que el usuario defina los atributos**
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // **Crear la instancia de SujetoObservable**
        SujetoObservable sujetoObservable = new SujetoObservable(); // ✅ Se instancia correctamente

        // **Inicializar la gestión de entidades con la instancia de SujetoObservable**
        VistaEntidades vistaEntidades = new VistaEntidades(controladorDefinicion.obtenerDefiniciones(), sujetoObservable);
        ControladorEntidades controladorEntidades = new ControladorEntidades(vistaEntidades, 
        		PersistenciaServiceSingleton.getInstancia().getPersistencia(), sujetoObservable);
    }
}
