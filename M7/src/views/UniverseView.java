package views;

import java.awt.*;
import java.util.*;

import javax.swing.*;


import models.*;
import systems.MainController.*;

public class UniverseView extends MainView { //maybe implement main view
	
	private JPanel panel;
	
	public UniverseView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		panel.setBackground(Color.black);
		
	}
	
	public Hashtable<JButton, SolarSystem> drawGalaxies(SolarSystem[] galaxies, PlanetListener listener) {
		Hashtable<JButton, SolarSystem> tempHash = new Hashtable<JButton, SolarSystem>();
		for(int i = 0; i < galaxies.length; i++) {
			ImageIcon icon = new ImageIcon("src/views/galaxy.png");
			JButton galaxyButton = new JButton(icon);
			galaxyButton.setBounds(galaxies[i].getX(), galaxies[i].getY(), 25, 25);
			galaxyButton.addActionListener(listener);
			tempHash.put(galaxyButton, galaxies[i]);
			panel.add(galaxyButton);
		}
		
		return tempHash;
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
