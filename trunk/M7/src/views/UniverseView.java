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
		System.out.println("drawing");
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		System.out.println("painting!");
		g.setColor(Color.blue);
		
		for(int i = 0; i < galaxies.length; i++) {
			g.drawOval(galaxies[i].getX(), galaxies[i].getY(), 10, 10);
			System.out.println("drawing planet!");
		}
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
