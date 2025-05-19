package Controladoor;

	import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

	public class Impresion extends JFrame {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Impresion frame = new Impresion();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public Impresion() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 347, 222);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JButton Bimprimir = new JButton("Imprimir");
	        Bimprimir.setBounds(115, 73, 89, 23);
	        Bimprimir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    String currentDir = System.getProperty("user.dir");
	                    System.out.println("La ruta absoluta del proyecto es: " + currentDir);
	                    JasperReport reporte = JasperCompileManager.compileReport(currentDir + "/Reportes/");

	                    Map<String, Object> parametros = new HashMap<String, Object>();
	                    parametros.put("totalticket", "28");
	                    parametros.put("articulostotal", "2");

	                    // Asignar el archivo CSV
	                    FileInputStream archivo = new FileInputStream(new File("Ticket.cvs"));

	                    // Fuente de datos
	                    JRCsvDataSource datasource = new JRCsvDataSource(archivo);

	                    // Usar la primera fila como encabezado
	                    datasource.setUseFirstRowAsHeader(true);

	                    // Generar el reporte con los parámetros y la fuente de datos
	                    JasperPrint print = JasperFillManager.fillReport(reporte, parametros, datasource);

	                    // Mostrar el reporte en un JFrame
	                    JasperViewer viewer = new JasperViewer(print, true);
	                    viewer.setVisible(true);
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	            }

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });

	        contentPane.add(Bimprimir);
	    }
	}



