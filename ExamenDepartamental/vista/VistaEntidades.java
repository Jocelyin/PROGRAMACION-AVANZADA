package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEntidades;
import modelo.DefinicionAtributo;
import modelo.Entidad;
import patrones.PersistenciaServiceSingleton;
import patrones.SujetoObservable;

public class VistaEntidades extends JFrame implements Observador{ // ✅ Implementa Observador
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modeloTabla;
    private JTable tablaEntidades;
    private JPanel panelFormulario;
    private JButton btnAgregar;
    private List<DefinicionAtributo> definiciones;
    
    private SujetoObservable sujetoObservable; // 🔹 Se añade el sujeto observado




    public VistaEntidades(List<DefinicionAtributo> definiciones, SujetoObservable sujetoObservable) {
        this.definiciones = definiciones;
        this.sujetoObservable = sujetoObservable;
        sujetoObservable.agregarObservador(this);

        setTitle("Gestión de Entidades");
        setSize(400, 300);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        tablaEntidades = new JTable(modeloTabla);
        add(new JScrollPane(tablaEntidades), BorderLayout.NORTH);

        panelFormulario = new JPanel(new GridLayout(definiciones.size(), 2));
        add(panelFormulario, BorderLayout.CENTER);

        btnAgregar = new JButton("Agregar Entidad");
        add(btnAgregar, BorderLayout.SOUTH);

        
        generarCampos(); 

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void actualizar() { 
        System.out.println("🔄 Vista actualizada.");
    }

    public void actualizarTabla(List<Entidad> entidades) {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de actualizar

        for (Entidad entidad : entidades) {
            Object[] fila = new Object[entidad.getAtributos().size()];
            int i = 0;

            for (Map.Entry<String, Object> entry : entidad.getAtributos().entrySet()) {
                fila[i++] = entry.getValue();
            }

            modeloTabla.addRow(fila);
        }
    }

    private void generarCampos() {
        panelFormulario.removeAll();
        System.out.println("▶ Generando campos en VistaEntidades, cantidad de atributos: " + definiciones.size());

        if (definiciones.isEmpty()) {
            panelFormulario.add(new JLabel("No se definieron atributos."));
        } else {
            for (DefinicionAtributo atributo : definiciones) {
                JLabel etiqueta = new JLabel(atributo.getNombre() + " (" + atributo.getTipo() + "):");
                JTextField campoTexto = new JTextField();

                panelFormulario.add(etiqueta);
                panelFormulario.add(campoTexto);
            }
        }

        panelFormulario.revalidate();
        panelFormulario.repaint();
    }





    public Map<String, Object> obtenerValores() {
        Map<String, Object> valores = new java.util.HashMap<>();
        Component[] componentes = panelFormulario.getComponents();

        for (int i = 0; i < componentes.length; i += 2) {
            JLabel label = (JLabel) componentes[i];
            JTextField textField = (JTextField) componentes[i + 1];
            String nombreAtributo = label.getText().split(" ")[0];
            valores.put(nombreAtributo, textField.getText());
        }
        return valores;
    }
    
   
}
