package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;

import models.spaceship.Spaceship;

import java.util.Random;
import javax.swing.Timer;

public class LanderView extends JPanel {
	
	/**
	 * X coordinate for panel
	 */
	private static final int XCORD = 6;
	
	/**
	 * Y coordinate for panel
	 */
	private static final int YCORD = 6;
	
	/**
	 * Width for panel
	 */
	private static final int WIDTH = 679;
	
	/**
	 * Height for panel
	 */
	private static final int HEIGHT = 473;
	
	private ImageIcon ship;
	private int pos, len, rdel;
	private double angle, x, y;
	private Timer timer;
	
	public LanderView(String playerShip) {
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setBackground(Color.black);
		setLayout(null);
		
		timer = new Timer(50, new TimeListener());
		angle = 0;
		x = WIDTH/2;
		y = HEIGHT/2;
		
		ship = new ImageIcon(getClass().getResource("/views/ships/"+playerShip+".png"));
		
		len = 40;
		Random rand = new Random();
		pos = rand.nextInt(WIDTH-len);
		
		addKeyListener(new MoveListener());
		setFocusable(true);
		
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(Math.toRadians(angle), (x+ship.getIconWidth()/2), (y+ship.getIconHeight()/2));
		ship.paintIcon(this, g2d, (int)x, (int)y);
		ship.paintIcon(this, g2d, (int)20, (int)20);
	}
	
	public class MoveListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println("KEY PRESSED");
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				angle -= 3;
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
				angle += 3;
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				rdel -= 2;
			}
			
		}
		
		public void keyTyped(KeyEvent e) {
			System.out.println("KEY PRESSED");
		}
		
		public void keyReleased(KeyEvent e) {
			System.out.println("KEY PRESSED");
		}
	}
	
	public class TimeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdel++;
			angle -= 4;
			//y += rdel;
			repaint();
		}
	}
	
	public JPanel getPanel() {
		return this;
	}
}
