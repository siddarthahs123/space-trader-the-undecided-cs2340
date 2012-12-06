package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import models.player.Player;
import systems.MainController.MarketListener;

public class FighterView extends JPanel {

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

	private JButton cont;

	private Timer timer;

	private int health;

	private int damage;

	private ImageIcon image;

	private Pirate pirate;

	private int x, y;

	private Random gen = new Random();

	private MouseListener mouse = new MouseController();

	private boolean result = false;

	private final JLabel LOSE = new JLabel("YOU LOSE...");

	private final JLabel WIN = new JLabel("YOU WIN!");

	private JLabel message = new JLabel("");

	private double credits;
	
	private double creditChange;

	private static final int BADFACTOR = 200;

	public FighterView(MarketListener marketListener) {
		setLayout(null);
		health = 100;
		damage = 0;
		image = new ImageIcon(getClass().getResource("/views/encounter.png"));

		pirate = new Pirate();

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setFocusable(true);
		addMouseListener(mouse);
		cont = new JButton("Continue");
		cont.addActionListener(marketListener);
		cont.setBounds(295, 200, 100, 20);
		cont.setEnabled(false);
		cont.setVisible(false);
		add(cont);

		LOSE.setBounds(316, 180, 100, 20);
		LOSE.setForeground(Color.RED);
		LOSE.setVisible(false);
		add(LOSE);

		WIN.setBounds(317, 180, 100, 20);
		WIN.setForeground(Color.GREEN);
		WIN.setVisible(false);
		add(WIN);

		message.setBounds(250, 55, 300, 20);
		message.setForeground(Color.RED);
		message.setVisible(false);
		add(message);

		x = gen.nextInt(WIDTH - pirate.getImage().getIconWidth() + 1);
		y = 50;

		timer = new Timer(23, new TimeListener());
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("Pirate's Health", 25, 23);
		g.drawString(
				"Destroy the Pirate's ship before he can board yours. Use your mouse!",
				225, 23);
		g.drawLine(0, 40, WIDTH, 40);
		g.setColor(Color.GREEN);
		g.fill3DRect(110, 8, 100, 20, true);
		g.setColor(Color.RED);
		if (damage != 0)
			g.fill3DRect(110 + (100 - damage), 8, damage, 20, false);
		image.paintIcon(this, g, 0, 42);

		pirate.getImage().paintIcon(this, g, x, y);
	}

	private class MouseController implements MouseListener {
		public void mouseClicked(MouseEvent arg0) {
		}

		public void mouseEntered(MouseEvent arg0) {
		}

		public void mouseExited(MouseEvent arg0) {
		}

		public void mousePressed(MouseEvent e) {
			if (pirate.isShot(e.getPoint(), x, y) == true) {
				damage += 5;
				health -= 5;
				repaint();
			}
		}

		public void mouseReleased(MouseEvent arg0) {
		}

	}

	private class TimeListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (health == 0) {
				pirate.image = new ImageIcon(getClass().getResource(
						"/views/destroyed.png"));
				getPanel().removeMouseListener(getMouse());
				timer.stop();
				cont.setEnabled(true);
				cont.setVisible(true);
				WIN.setVisible(true);
				repaint();
				result = true;
			} else if (y > HEIGHT) {
				
				if (credits + creditChange < 0) {
					message.setText("Pirates stole all of your credits");
				} else
					message.setText("Pirates stole " + -1 * creditChange
							+ " credits from you");

				timer.stop();
				cont.setEnabled(true);
				cont.setVisible(true);
				LOSE.setVisible(true);
				message.setVisible(true);
				result = false;
			} else {
				int randomChance = gen.nextInt(5);
				int signChange = gen.nextInt(2);
				if (signChange == 0) {
					if (randomChance == 4)
						x = x + 10;
					else
						x = x - 1;
					if (x < 0)
						x = 0;
				} else {
					if (randomChance == 5)
						x = x - 10;
					else
						x = x + 1;
					if (x > WIDTH - pirate.getImage().getIconWidth())
						x = WIDTH - pirate.getImage().getIconWidth();
				}
				y += 2;
				repaint();
			}
		}
	}

	public JPanel getPanel() {
		return this;
	}

	public MouseListener getMouse() {
		return mouse;
	}

	public boolean getResult() {
		return result;
	}

	private class Pirate {
		private ImageIcon image;
		private boolean shot;

		public Pirate() {
			image = new ImageIcon(getClass().getResource("/views/enemy.png"));
		}

		public ImageIcon getImage() {
			return image;
		}

		public boolean isShot(Point point, int x, int y) {
			if ((point.getX() >= x && point.getX() <= x + image.getIconWidth())
					&& (point.getY() >= y && point.getY() <= y
							+ image.getIconHeight())) {
				shot = true;
			} else {
				shot = false;
			}
			return shot;
		}
	}

	public void setCurrCredits(Player player) {
		this.credits = player.getCredits();
	}
	
	public void setCreditChange(double creditChange) {
		this.creditChange = creditChange;
	}
	// public static void main(String[] args) {
	// JFrame frame = new JFrame("Space Battle");
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frame.setBounds(0, 0, 679, 473);
	// frame.setResizable(false);
	// FighterView fight = new FighterView(/* new MarketListener() */);
	// frame.getContentPane().add(fight);
	//
	// frame.pack();
	// frame.setVisible(true);
	// }
}
