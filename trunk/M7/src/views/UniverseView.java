/**
 * package that contains this class
 */
package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import systems.MainController.PlanetListener;

import models.space.SolarSystem;

/**
 * This class represents the Long-Range map for the game and displays all Solar
 * Systems.
 * 
 * @author Justin
 * @version 1.0
 */
public class UniverseView extends JPanel { // maybe implement main view

	/**
	 * Panel for universe view
	 */
	//private JPanel panel = null;

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

	/**
	 * Bounds for the galaxies
	 */
	private static final int BUTTON_BOUNDS = 33;
	
	/**
	 * Warning that states if the ship is out of fuel or can't reach a galaxy
	 */
	private JLabel fuelWarning = null;

	private BufferedImage image;

	/**
	 * X coordinate for warning
	 */
	private static final int WARN_X = 211;
	
	/**
	 * Y coordinate for warning
	 */
	private static final int WARN_Y = 6;
	
	/**
	 * Width of the warning
	 */
	private static final int WARN_WIDTH = 255;
	
	/**
	 * Height of the warning
	 */
	private static final int WARN_HEIGHT = 16;
	
	/**
	 * Constructor for this class.
	 */
	public UniverseView() {
		File file = new File ("src/views/galaxyBackground.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setLayout(null);
		//setBackground(Color.black);

		fuelWarning = new JLabel("Not enough fuel to reach destination!");
		fuelWarning.setForeground(Color.WHITE);
		fuelWarning.setHorizontalAlignment(SwingConstants.CENTER);
		fuelWarning.setBounds(WARN_X, WARN_Y, WARN_WIDTH, WARN_HEIGHT);
		fuelWarning.setVisible(false);
		add(fuelWarning);

	}

	/**
	 * This method places the galaxies on the map as buttons.
	 * 
	 * @param galaxies
	 *            An SolarSystem array of all galaxies
	 * @param listener
	 *            A listener to be added to each button
	 * @return A hashtable storing the button-solarsystem pairs
	 */
	public Map<JButton, SolarSystem> drawGalaxies(SolarSystem[] galaxies,
			PlanetListener listener) {
		Map<JButton, SolarSystem> tempHash = new Hashtable<JButton, SolarSystem>();
		for (int i = 0; i < galaxies.length; i++) {
			ImageIcon icon = new ImageIcon("src/views/galaxy.png");
			JButton galaxyButton = new JButton(icon);
			galaxyButton.setBounds(galaxies[i].getX(), galaxies[i].getY(), BUTTON_BOUNDS,
					BUTTON_BOUNDS);
			galaxyButton.addActionListener(listener);
			galaxyButton.setToolTipText("<html>Galaxy: " + galaxies[i].name()
					+ "<br>Tech Level: " + galaxies[i].techLevel()
					+ "<br>Coordinates: " + galaxies[i].getX() + ", "
					+ galaxies[i].getY() + "</html>");
			tempHash.put(galaxyButton, galaxies[i]);
			add(galaxyButton);
		}

		return tempHash;
	}

	/**
	 * This method is a getter for the panel.
	 * 
	 * @return The panel
	 */
	public JPanel getPanel() {
		return this;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}

	/**
	 * Returns the fuel warning
	 * @return fuel warning
	 */
	public JLabel getFuelWarning() {
		return fuelWarning;
	}
	
	/**
	 * The toString method
	 * @return nothing
	 */
	public String toString() {
		return "";
	}
}
