package views;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import models.*;
import systems.MainController.*;

/**
 * This class represents the Long-Range map for the game and displays all Solar Systems.
 * @author Justin
 */
public class UniverseView extends MainView { //maybe implement main view
	
	private JPanel panel;
	
	/**
	 * Constructor for this class.
	 */
	public UniverseView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		panel.setBackground(Color.black);
		
	}
	
	/**
	 * This method places the galaxies on the map as buttons.
	 * @param galaxies An SolarSystem array of all galaxies
	 * @param listener A listener to be added to each button
	 * @return A hashtable storing the button-solarsystem pairs
	 */
	public Hashtable<JButton, SolarSystem> drawGalaxies(SolarSystem[] galaxies, PlanetListener listener) {
		Hashtable<JButton, SolarSystem> tempHash = new Hashtable<JButton, SolarSystem>();
		for(int i = 0; i < galaxies.length; i++) {
			ImageIcon icon = new ImageIcon("src/views/galaxy.png");
			JButton galaxyButton = new JButton(icon);
			galaxyButton.setBounds(galaxies[i].getX(), galaxies[i].getY(), 33, 33);
			galaxyButton.addActionListener(listener);
			tempHash.put(galaxyButton, galaxies[i]);
			panel.add(galaxyButton);
		}
		
		return tempHash;
	}
	
	/**
	 * This method is a getter for the panel.
	 * @return The panel
	 */
	public JPanel getPanel() {
		return panel;
	}
	
}
