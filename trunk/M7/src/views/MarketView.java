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
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setBounds(188, 72, 61, 16);
		panel.add(lblCargo);
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarket.setBounds(435, 72, 61, 16);
		panel.add(lblMarket);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPlanetName(String name) {
		planetName.setText(name);
	}
}
