package patrones;

import modelo.PersistenciaService;

public class PersistenciaServiceSingleton {
    private static PersistenciaServiceSingleton instancia;
    private PersistenciaService persistencia;

    private PersistenciaServiceSingleton() {
        persistencia = new PersistenciaService();
    }

    public static PersistenciaServiceSingleton getInstancia() {
        if (instancia == null) {
            instancia = new PersistenciaServiceSingleton();
        }
        return instancia;
    }

    public PersistenciaService getPersistencia() {
        return persistencia;
    }
}

