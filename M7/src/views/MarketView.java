package views;

import javax.swing.*;

import models.*;

public class MarketView extends MainView {
	
	private JPanel panel;
	private JLabel planetName;
	
	public MarketView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		
		planetName = new JLabel("Planet");
		planetName.setHorizontalAlignment(SwingConstants.CENTER);
		planetName.setBounds((panel.getWidth()/2)-87, 20, 174, 16);
		panel.add(planetName);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPlanetName(String name) {
		planetName.setText(name);
	}
}
