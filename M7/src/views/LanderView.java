package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import systems.MainController.MarketListener;

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
	private Random gen = new Random();
	private final int FUELFACTOR;
	private int fuelLost = 0;
	private ImageIcon ship;
	private int x, y;
	private Timer timer;
	private Pad landerPad;
	private boolean win = false;
	private JButton cont;
	private JLabel status;
	private MouseListener mouse;
	private ImageIcon image;
	
	private final JLabel LOSE = new JLabel("YOU CRASHED!");

	private final JLabel WIN = new JLabel("YOU LANDED");

	private JLabel message = new JLabel("");
	
	private class Pad {
		private int x, y, width, height;
		boolean side = true; //true for left movement, false for right
		
		public Pad() {
			x = 0;
			width = 100;
			height = 10;
			y = getHeight() - height;
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
	
	public LanderView(String playerShip, MarketListener ml, int fuel) {
		FUELFACTOR = fuel/3;
		setLayout(null);
		image = new ImageIcon(getClass().getResource("/views/encounter.png"));
		
		LOSE.setBounds(302, 160, 100, 20);
		LOSE.setForeground(Color.RED);
		LOSE.setVisible(false);
		add(LOSE);

		WIN.setBounds(308, 180, 100, 20);
		WIN.setForeground(Color.GREEN);
		WIN.setVisible(false);
		add(WIN);
		
		message.setBounds(302, 240, 300, 20);
		message.setForeground(Color.RED);
		message.setVisible(false);
		add(message);
		
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setFocusable(true);
		addKeyListener(new KeyController());
		mouse = new MouseController();
		addMouseListener(mouse);
		cont = new JButton("Continue");
		cont.setBounds(295, 200, 100, 20);
		cont.addActionListener(ml);
		cont.setVisible(false);
		cont.setEnabled(false);
		add(cont);
		landerPad = new Pad();
		
		timer = new Timer(25, new TimeListener());
		x = getWidth()/2;
		y = 0;
		
		ship = new ImageIcon(getClass().getResource("/views/ships/"+playerShip+".png"));
		
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		image.paintIcon(this, g, 0, 0);
		g.setColor(Color.WHITE);
		g.drawString("Land the ship on the pad or you will lose fuel!", 223, 20);
		g.drawString("Click on the right side of the ship to move right", 223, 35);
		g.drawString("Click on the left side of the ship to move left" , 223, 50);
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
	
	private class MouseController implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent e) {
			
			if (e.getPoint().x > x && e.getPoint().x < getWidth()) {
				if (x + ship.getIconWidth() <= getWidth())
					x = x + 30;
			}
			else if (e.getPoint().x > 0 && e.getPoint().x < x) {
				x = x - 30;
			}
			repaint();
		}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	private class TimeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			y += 1;
			landerPad.move();
			if (x >= landerPad.getX() && x + ship.getIconWidth() < landerPad.getX() + landerPad.width && y + ship.getIconHeight() + landerPad.height*2 + 10 >= landerPad.getY()) {
				getPanel().removeMouseListener(mouse);
				timer.stop();
				win = true;
				cont.setVisible(true);
				WIN.setVisible(true);
				cont.setEnabled(true);
			}
			else if (y + ship.getIconHeight() + landerPad.height*2 > landerPad.getY()) {
				getPanel().removeMouseListener(mouse);
				fuelLost = gen.nextInt(FUELFACTOR);
				timer.stop();
				win = false;
				cont.setVisible(true);
				LOSE.setVisible(true);
				cont.setEnabled(true);
				message.setText("You lost " + fuelLost + " fuel");
				message.setVisible(true);
			}
			repaint();
		}
	}
	
	public boolean getResult() {
		return win;
	}
	
	public int getFuelLost() {
		return fuelLost;
	}
	
	public JPanel getPanel() {
		return this;
	}
}
