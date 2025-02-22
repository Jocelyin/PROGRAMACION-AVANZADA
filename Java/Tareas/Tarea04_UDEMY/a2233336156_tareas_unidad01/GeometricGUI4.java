package a2233336156_tareas_unidad01;

import javax.swing.*;
import java.awt.*;

public class GeometricGUI4 extends JPanel 
{
	public GeometricGUI4() {
	}
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        int width = 300;
        int height = 66;

        g.setColor(Color.RED);
        g.fillRect(50, 50, width, height);

        g.setColor(Color.WHITE);
        g.fillRect(50, 50 + height, width, height);

        g.setColor(Color.BLUE);
        g.fillRect(50, 50 + 2 * height, width, height);
    }

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Bandera de los Países Bajos");
        GeometricGUI4 panel = new GeometricGUI4();
        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}