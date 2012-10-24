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
		lblCargo.setBounds(175, 75, 61, 16);
		panel.add(lblCargo);
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarket.setBounds(300, 75, 61, 16);
		panel.add(lblMarket);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setHorizontalAlignment(SwingConstants.CENTER);
		lblWater.setBounds(50, 100, 70, 14);
		panel.add(lblWater);
		
		JLabel lblFurs = new JLabel("Furs");
		lblFurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFurs.setBounds(50, 125, 70, 14);
		panel.add(lblFurs);
		
		JLabel lblGames = new JLabel("Games");
		lblGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblGames.setBounds(50, 150, 70, 14);
		panel.add(lblGames);
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setBounds(50, 175, 70, 14);
		panel.add(lblFood);
		
		JLabel lblFirearms = new JLabel("Firearms");
		lblFirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirearms.setBounds(50, 200, 70, 14);
		panel.add(lblFirearms);
		
		JLabel lblMachines = new JLabel("Machines");
		lblMachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMachines.setBounds(50, 225, 70, 14);
		panel.add(lblMachines);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicine.setBounds(50, 250, 70, 14);
		panel.add(lblMedicine);
		
		JLabel lblNarcotics = new JLabel("Narcotics");
		lblNarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarcotics.setBounds(50, 275, 70, 14);
		panel.add(lblNarcotics);
		
		JLabel lblOre = new JLabel("Ore");
		lblOre.setHorizontalAlignment(SwingConstants.CENTER);
		lblOre.setBounds(50, 300, 70, 14);
		panel.add(lblOre);
		
		JLabel lblRobots = new JLabel("Robots");
		lblRobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobots.setBounds(50, 325, 70, 14);
		panel.add(lblRobots);
		
		JLabel lblCWater = new JLabel("cWater");
		lblCWater.setHorizontalAlignment(SwingConstants.CENTER);
		lblCWater.setBounds(175, 100, 61, 14);
		panel.add(lblCWater);
		
		JLabel lblCfurs = new JLabel("cFurs");
		lblCfurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfurs.setBounds(175, 125, 61, 14);
		panel.add(lblCfurs);
		
		JLabel lblCgames = new JLabel("cGames");
		lblCgames.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgames.setBounds(175, 150, 61, 14);
		panel.add(lblCgames);
		
		JLabel lblCfood = new JLabel("cFood");
		lblCfood.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfood.setBounds(175, 175, 61, 14);
		panel.add(lblCfood);
		
		JLabel lblCfirearms = new JLabel("cFirearms");
		lblCfirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfirearms.setBounds(175, 200, 61, 14);
		panel.add(lblCfirearms);
		
		JLabel lblCmachines = new JLabel("cMachines");
		lblCmachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmachines.setBounds(175, 225, 61, 14);
		panel.add(lblCmachines);
		
		JLabel lblCmedicine = new JLabel("cMedicine");
		lblCmedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmedicine.setBounds(175, 250, 61, 14);
		panel.add(lblCmedicine);
		
		JLabel lblCnarcotics = new JLabel("cNarcotics");
		lblCnarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnarcotics.setBounds(175, 275, 61, 14);
		panel.add(lblCnarcotics);
		
		JLabel lblCore = new JLabel("cOre");
		lblCore.setHorizontalAlignment(SwingConstants.CENTER);
		lblCore.setBounds(175, 300, 61, 14);
		panel.add(lblCore);
		
		JLabel lblCrobots = new JLabel("cRobots");
		lblCrobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrobots.setBounds(175, 325, 61, 14);
		panel.add(lblCrobots);
		
		JLabel lblMwater = new JLabel("mWater");
		lblMwater.setHorizontalAlignment(SwingConstants.CENTER);
		lblMwater.setBounds(300, 100, 61, 14);
		panel.add(lblMwater);
		
		JLabel lblMfurs = new JLabel("mFurs");
		lblMfurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfurs.setBounds(300, 125, 61, 14);
		panel.add(lblMfurs);
		
		JLabel lblMgames = new JLabel("mGames");
		lblMgames.setHorizontalAlignment(SwingConstants.CENTER);
		lblMgames.setBounds(300, 150, 61, 14);
		panel.add(lblMgames);
		
		JLabel lblMfood = new JLabel("mFood");
		lblMfood.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfood.setBounds(300, 175, 61, 14);
		panel.add(lblMfood);
		
		JLabel lblMfirearms = new JLabel("mFirearms");
		lblMfirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfirearms.setBounds(300, 200, 61, 14);
		panel.add(lblMfirearms);
		
		JLabel lblMmachines = new JLabel("mMachines");
		lblMmachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMmachines.setBounds(300, 225, 61, 14);
		panel.add(lblMmachines);
		
		JLabel lblMmedicine = new JLabel("mMedicine");
		lblMmedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMmedicine.setBounds(300, 250, 61, 14);
		panel.add(lblMmedicine);
		
		JLabel lblMnarcotics = new JLabel("mNarcotics");
		lblMnarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblMnarcotics.setBounds(300, 275, 61, 14);
		panel.add(lblMnarcotics);
		
		JLabel lblMore = new JLabel("mOre");
		lblMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMore.setBounds(300, 300, 61, 14);
		panel.add(lblMore);
		
		JLabel lblMrobots = new JLabel("mRobots");
		lblMrobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblMrobots.setBounds(300, 325, 61, 14);
		panel.add(lblMrobots);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPlanetName(String name) {
		planetName.setText(name);
	}
}
