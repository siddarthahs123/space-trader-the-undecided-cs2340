package views;

import java.awt.*;
import javax.swing.*;

import models.*;

public class UniverseView extends JPanel { //maybe implement main view
	
	private JPanel panel;
	private SolarSystem[] galaxies;
	
	public UniverseView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		panel.setBackground(Color.black);
		
	}
	
	public void drawGalaxies(SolarSystem[] galaxies) {
		this.galaxies = galaxies;
		repaint();
		System.out.println("drawing");
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.blue);
		
		for(int i = 0; i < galaxies.length; i++) {
			g.fillOval(galaxies[i].getX(), galaxies[i].getY(), 10, 10);
			System.out.println("drawing planet!");
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
