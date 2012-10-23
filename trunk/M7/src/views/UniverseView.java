package views;

import java.awt.*;
import javax.swing.*;


import models.*;

public class UniverseView extends MainView { //maybe implement main view
	
	private JPanel panel;
	
	public UniverseView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		panel.setBackground(Color.black);
	}
	
	public void drawGalaxies(SolarSystem[] galaxies) {
		
		for(int i = 0; i < galaxies.length; i++) {
			ImageIcon icon = new ImageIcon("src/views/galaxy.png");
			JButton planet = new JButton(icon);
			planet.setBounds(galaxies[i].getX(), galaxies[i].getY(), 25, 25);
			panel.add(planet);
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
