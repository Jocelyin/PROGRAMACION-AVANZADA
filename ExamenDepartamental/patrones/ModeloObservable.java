package patrones;

import java.util.ArrayList;
import java.util.List;


public class ModeloObservable {
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar();
        }
    }
}

interface Observador {
    void actualizar();
}

