package drawshape;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setFocusable(true);
		
		DrawStuff eclipse = new DrawStuff();
		eclipse.setPosition(10, 10);
		frame.add(eclipse, BorderLayout.CENTER);
		
		frame.addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					Location.y = Location.y - 10;
					eclipse.setPosition(Location.x, Location.y);
					eclipse.repaint();
					break;
				case KeyEvent.VK_DOWN:
					Location.y = Location.y + 10;
					eclipse.setPosition(Location.x, Location.y);
					eclipse.repaint();
					break;
				case KeyEvent.VK_RIGHT:
					Location.x = Location.x + 10;
					eclipse.setPosition(Location.x, Location.y);
					eclipse.repaint();
					break;
				case KeyEvent.VK_LEFT:
					Location.x = Location.x - 10;
					eclipse.setPosition(Location.x, Location.y);
					eclipse.repaint();
					break;
				case KeyEvent.VK_SPACE:
					Random rand = new Random();
					int x = rand.nextInt(1200);
					int y = rand.nextInt(800);
					eclipse.addBarrier(x, y);
					eclipse.repaint();
					break;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
