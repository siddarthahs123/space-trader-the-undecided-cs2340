package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
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
	private int x, y;
	private Timer timer;
	private Pad landerPad;
	
	private class Pad {
		private int x, y, width, height;
		boolean side = true; //true for left movement, false for right
		
		public Pad(int x, int y) {
			this.x = x;
			this.y = y;
			width = 100;
			height = 10;
		}
		
		public void setX(int newX) {
			x = newX;
		}
		public void setY(int newY) {
			y = newY;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		
		public void draw(Graphics page) {
			page.setColor(Color.WHITE);
			page.fillRect(x, (getHeight() - height), width, height);
		}
		
		public void move () {
			x = getX();
			if (side) {
				if (x + width > getWidth())
					side = false;
				else
					x = x + 5;
			}
			else {
				if (x < 0)
					side = true;
				else
					x = x - 5;
			}
		}
	}
	
	public LanderView(String playerShip) {
		
		setBackground(Color.black);
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setFocusable(true);
		addKeyListener(new KeyController());

		landerPad = new Pad(0, 0);
		timer = new Timer(20, new TimeListener());
		x = getWidth()/2;
		y = 0;
		
		ship = new ImageIcon(getClass().getResource("/views/ships/"+playerShip+".png"));
		
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ship.paintIcon(this, g, x, y);
		landerPad.draw(g);
	}
	
	private class KeyController implements KeyListener {
		
		public void keyPressed(KeyEvent key) {
			System.out.println("Got here");
			switch (key.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					if (x + ship.getIconWidth() + 5 < getWidth())
						x = x + 5;
					break;
                case KeyEvent.VK_LEFT:
                	if (x + 5 > 0)
                		x = x - 5;
                    break;
			}
			repaint(); 
        }

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {}
	}
	
	private class TimeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			y += 1;
			landerPad.move();
			repaint();
		}
	}
	
	public JPanel getPanel() {
		return this;
	}
}
