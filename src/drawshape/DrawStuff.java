package drawshape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DrawStuff extends JComponent {

	private static float x1;
	private static float y1;
	
	void setPosition(float x, float y) {
		x1 = x;
		y1 = y;
	}
	
	private static int barrierCount = 0;
	private static ArrayList<int[]> barriers = new ArrayList<int[]>();
	
	public void addBarrier(int x, int y) {
		barrierCount = barrierCount + 1;
		int[] barrier = new int[2];
		barrier[0] = x;
		barrier[1] = y;
		barriers.add(barrier);
		
	}

	public void paint(Graphics g) {
		
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Shape drawEllipse = new Ellipse2D.Float(x1, y1, 50, 50);
		graph2.draw(drawEllipse);
		graph2.setPaint(Color.GRAY);
		graph2.fill(drawEllipse);
		
		int i = 0;
		
		while (i <= barrierCount - 1) {
			int[] barrier = barriers.get(i);
			Shape newEllipse = new Ellipse2D.Float(barrier[0], barrier[1], 50, 50);
			graph2.draw(newEllipse);
			graph2.setPaint(Color.BLUE);
			graph2.fill(newEllipse);
			i = i + 1;
		}

	}
}
