package controlador;

import java.util.List;

import modelo.DefinicionAtributo;
import vista.VistaDefinicionAtributos;

public class ControladorDefinicionAtributos {
    private VistaDefinicionAtributos vista;
    private List<DefinicionAtributo> definiciones;

    public ControladorDefinicionAtributos(VistaDefinicionAtributos vista) {
        this.vista = vista;
        this.definiciones = vista.getDefiniciones();
    }

    public List<DefinicionAtributo> obtenerDefiniciones() {
        return definiciones;
    }
}
