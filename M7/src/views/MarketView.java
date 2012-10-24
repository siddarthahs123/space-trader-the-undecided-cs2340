package views;

import javax.swing.*;

import models.*;
import java.awt.Color;

public class MarketView extends MainView {
	
	private JPanel panel;
	private JLabel planetName;
	
	public MarketView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		
		planetName = new JLabel("Planet");
		planetName.setHorizontalAlignment(SwingConstants.CENTER);
		planetName.setBounds(250, 25, 174, 16);
		panel.add(planetName);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setBounds(150, 75, 61, 16);
		panel.add(lblCargo);
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarket.setBounds(250, 75, 61, 16);
		panel.add(lblMarket);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setHorizontalAlignment(SwingConstants.CENTER);
		lblWater.setBounds(50, 100, 46, 14);
		panel.add(lblWater);
		
		JLabel lblFurs = new JLabel("Furs");
		lblFurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFurs.setBounds(50, 125, 46, 14);
		panel.add(lblFurs);
		
		JLabel lblGames = new JLabel("Games");
		lblGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblGames.setBounds(50, 150, 46, 14);
		panel.add(lblGames);
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setBounds(50, 175, 46, 14);
		panel.add(lblFood);
		
		JLabel lblFirearms = new JLabel("Firearms");
		lblFirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirearms.setBounds(50, 200, 46, 14);
		panel.add(lblFirearms);
		
		JLabel lblMachines = new JLabel("Machines");
		lblMachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMachines.setBounds(50, 225, 46, 14);
		panel.add(lblMachines);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicine.setBounds(50, 250, 46, 14);
		panel.add(lblMedicine);
		
		JLabel lblNarcotics = new JLabel("Narcotics");
		lblNarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarcotics.setBounds(50, 275, 46, 14);
		panel.add(lblNarcotics);
		
		JLabel lblOre = new JLabel("Ore");
		lblOre.setHorizontalAlignment(SwingConstants.CENTER);
		lblOre.setBounds(50, 300, 46, 14);
		panel.add(lblOre);
		
		JLabel lblRobots = new JLabel("Robots");
		lblRobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobots.setBounds(50, 325, 46, 14);
		panel.add(lblRobots);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPlanetName(String name) {
		planetName.setText(name);
	}
}
