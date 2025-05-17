package controlador;

import java.util.List;
import java.util.Map;
import modelo.Entidad;
import modelo.EntidadFactory;
import modelo.PersistenciaService;
import patrones.SujetoObservable;
import vista.VistaEntidades;

public class ControladorEntidades {
    private List<Entidad> entidades;
    private PersistenciaService persistencia;
    private VistaEntidades vista;
    private SujetoObservable sujetoObservable; // ✅ Se integra con Observer

  

    public ControladorEntidades(VistaEntidades vista, PersistenciaService persistencia, SujetoObservable sujetoObservable) {
        this.persistencia = persistencia;
        this.vista = vista;
        this.sujetoObservable = sujetoObservable;
        sujetoObservable.agregarObservador(vista); // ✅ La vista se registra como observador
    }

    public void agregarEntidad() {
        Map<String, Object> valores = vista.obtenerValores();
        String identificadorUnico = (String) valores.get("Identificador"); 
        Entidad nuevaEntidad = EntidadFactory.crearEntidad(identificadorUnico, valores);
        entidades.add(nuevaEntidad);
        persistencia.guardarEntidades(entidades);

        sujetoObservable.notificarObservadores(); // ✅ Ahora realmente notificamos los observadores
    }


    private void actualizarVista() {
        vista.actualizarTabla(entidades);
    }
}
