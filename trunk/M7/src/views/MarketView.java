package views;

import javax.swing.*;

import models.*;
import systems.MainController.BuyListener;
import systems.MainController.SellListener;
import java.awt.Color;
import java.awt.event.*;

public class MarketView extends MainView {
	
	private JPanel panel;
	private JLabel planetName, lblMrobots, lblMore, lblMnarcotics, lblMmedicine, lblMmachines, lblMfirearms, lblMfood,
		lblMgames, lblMfurs, lblMwater, lblCrobots, lblCore, lblCnarcotics, lblCmedicine, lblCmachines, lblCfirearms,
		lblCfood, lblCgames, lblCfurs, lblCwater;
	private ButtonGroup buyGroup, sellGroup;
	private JButton waterBuy, fursBuy, gamesBuy, foodBuy, firearmsBuy, machinesBuy, medicineBuy, narcoticsBuy, oreBuy,
		robotsBuy, waterSell, fursSell, gamesSell, foodSell, firearmsSell, machinesSell, medicineSell, narcoticsSell, oreSell,
		robotsSell;

	public MarketView(BuyListener buyListener, SellListener sellListener) {
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
		
		lblCwater = new JLabel("cWater");
		lblCwater.setHorizontalAlignment(SwingConstants.CENTER);
		lblCwater.setBounds(175, 100, 61, 14);
		panel.add(lblCwater);
		
		lblCfurs = new JLabel("cFurs");
		lblCfurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfurs.setBounds(175, 125, 61, 14);
		panel.add(lblCfurs);
		
		lblCgames = new JLabel("cGames");
		lblCgames.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgames.setBounds(175, 150, 61, 14);
		panel.add(lblCgames);
		
		lblCfood = new JLabel("cFood");
		lblCfood.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfood.setBounds(175, 175, 61, 14);
		panel.add(lblCfood);
		
		lblCfirearms = new JLabel("cFirearms");
		lblCfirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfirearms.setBounds(175, 200, 61, 14);
		panel.add(lblCfirearms);
		
		lblCmachines = new JLabel("cMachines");
		lblCmachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmachines.setBounds(175, 225, 61, 14);
		panel.add(lblCmachines);
		
		lblCmedicine = new JLabel("cMedicine");
		lblCmedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmedicine.setBounds(175, 250, 61, 14);
		panel.add(lblCmedicine);
		
		lblCnarcotics = new JLabel("cNarcotics");
		lblCnarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnarcotics.setBounds(175, 275, 61, 14);
		panel.add(lblCnarcotics);
		
		lblCore = new JLabel("cOre");
		lblCore.setHorizontalAlignment(SwingConstants.CENTER);
		lblCore.setBounds(175, 300, 61, 14);
		panel.add(lblCore);
		
		lblCrobots = new JLabel("cRobots");
		lblCrobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrobots.setBounds(175, 325, 61, 14);
		panel.add(lblCrobots);
		
		lblMwater = new JLabel("mWater");
		lblMwater.setHorizontalAlignment(SwingConstants.CENTER);
		lblMwater.setBounds(300, 100, 61, 14);
		panel.add(lblMwater);
		
		lblMfurs = new JLabel("mFurs");
		lblMfurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfurs.setBounds(300, 125, 61, 14);
		panel.add(lblMfurs);
		
		lblMgames = new JLabel("mGames");
		lblMgames.setHorizontalAlignment(SwingConstants.CENTER);
		lblMgames.setBounds(300, 150, 61, 14);
		panel.add(lblMgames);
		
		lblMfood = new JLabel("mFood");
		lblMfood.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfood.setBounds(300, 175, 61, 14);
		panel.add(lblMfood);
		
		lblMfirearms = new JLabel("mFirearms");
		lblMfirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfirearms.setBounds(300, 200, 61, 14);
		panel.add(lblMfirearms);
		
		lblMmachines = new JLabel("mMachines");
		lblMmachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMmachines.setBounds(300, 225, 61, 14);
		panel.add(lblMmachines);
		
		lblMmedicine = new JLabel("mMedicine");
		lblMmedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMmedicine.setBounds(300, 250, 61, 14);
		panel.add(lblMmedicine);
		
		lblMnarcotics = new JLabel("mNarcotics");
		lblMnarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblMnarcotics.setBounds(300, 275, 61, 14);
		panel.add(lblMnarcotics);
		
		lblMore = new JLabel("mOre");
		lblMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMore.setBounds(300, 300, 61, 14);
		panel.add(lblMore);
		
		lblMrobots = new JLabel("mRobots");
		lblMrobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblMrobots.setBounds(300, 325, 61, 14);
		panel.add(lblMrobots);
		
		waterBuy = new JButton("Buy");
		waterBuy.setBounds(403, 94, 61, 29);
		panel.add(waterBuy);
		waterBuy.addActionListener(buyListener);
		
		fursBuy = new JButton("Buy");
		fursBuy.setBounds(403, 119, 61, 29);
		panel.add(fursBuy);
		fursBuy.addActionListener(buyListener);
		
		gamesBuy = new JButton("Buy");
		gamesBuy.setBounds(403, 144, 61, 29);
		panel.add(gamesBuy);
		gamesBuy.addActionListener(buyListener);
		
		foodBuy = new JButton("Buy");
		foodBuy.setBounds(403, 169, 61, 29);
		panel.add(foodBuy);
		foodBuy.addActionListener(buyListener);
		
		firearmsBuy = new JButton("Buy");
		firearmsBuy.setBounds(403, 194, 61, 29);
		panel.add(firearmsBuy);
		firearmsBuy.addActionListener(buyListener);
		
		machinesBuy = new JButton("Buy");
		machinesBuy.setBounds(403, 219, 61, 29);
		panel.add(machinesBuy);
		machinesBuy.addActionListener(buyListener);
		
		medicineBuy = new JButton("Buy");
		medicineBuy.setBounds(403, 244, 61, 29);
		panel.add(medicineBuy);
		medicineBuy.addActionListener(buyListener);
		
		narcoticsBuy = new JButton("Buy");
		narcoticsBuy.setBounds(403, 269, 61, 29);
		panel.add(narcoticsBuy);
		narcoticsBuy.addActionListener(buyListener);
		
		oreBuy = new JButton("Buy");
		oreBuy.setBounds(403, 294, 61, 29);
		panel.add(oreBuy);
		oreBuy.addActionListener(buyListener);
		
		robotsBuy = new JButton("Buy");
		robotsBuy.setBounds(403, 319, 61, 29);
		panel.add(robotsBuy);
		robotsBuy.addActionListener(buyListener);
		
		waterSell = new JButton("Sell");
		waterSell.setBounds(476, 94, 61, 29);
		panel.add(waterSell);
		waterSell.addActionListener(sellListener);
		
		fursSell = new JButton("Sell");
		fursSell.setBounds(476, 119, 61, 29);
		panel.add(fursSell);
		fursSell.addActionListener(sellListener);
		
		gamesSell = new JButton("Sell");
		gamesSell.setBounds(476, 144, 61, 29);
		panel.add(gamesSell);
		gamesSell.addActionListener(sellListener);
		
		foodSell = new JButton("Sell");
		foodSell.setBounds(476, 169, 61, 29);
		panel.add(foodSell);
		foodSell.addActionListener(sellListener);
		
		firearmsSell = new JButton("Sell");
		firearmsSell.setBounds(476, 194, 61, 29);
		panel.add(firearmsSell);
		firearmsSell.addActionListener(sellListener);
		
		machinesSell = new JButton("Sell");
		machinesSell.setBounds(476, 219, 61, 29);
		panel.add(machinesSell);
		machinesSell.addActionListener(sellListener);
		
		medicineSell = new JButton("Sell");
		medicineSell.setBounds(476, 244, 61, 29);
		panel.add(medicineSell);
		medicineSell.addActionListener(sellListener);
		
		narcoticsSell = new JButton("Sell");
		narcoticsSell.setBounds(476, 269, 61, 29);
		panel.add(narcoticsSell);
		narcoticsSell.addActionListener(sellListener);
		
		oreSell = new JButton("Sell");
		oreSell.setBounds(476, 294, 61, 29);
		panel.add(oreSell);
		oreSell.addActionListener(sellListener);
		
		robotsSell = new JButton("Sell");
		robotsSell.setBounds(476, 319, 61, 29);
		panel.add(robotsSell);
		robotsSell.addActionListener(sellListener);
		
		buyGroup = new ButtonGroup();
		buyGroup.add(waterBuy);
		buyGroup.add(fursBuy);
		buyGroup.add(gamesBuy);
		buyGroup.add(foodBuy);
		buyGroup.add(firearmsBuy);
		buyGroup.add(machinesBuy);
		buyGroup.add(medicineBuy);
		buyGroup.add(narcoticsBuy);
		buyGroup.add(oreBuy);
		buyGroup.add(robotsBuy);
		
		sellGroup = new ButtonGroup();
		sellGroup.add(waterSell);
		sellGroup.add(fursSell);
		sellGroup.add(gamesSell);
		sellGroup.add(foodSell);
		sellGroup.add(firearmsSell);
		sellGroup.add(machinesSell);
		sellGroup.add(medicineSell);
		sellGroup.add(narcoticsSell);
		sellGroup.add(oreSell);
		sellGroup.add(robotsSell);
	}
	
	public JLabel getPlanetName() {
		return planetName;
	}

	public JLabel getLblMrobots() {
		return lblMrobots;
	}

	public JLabel getLblMore() {
		return lblMore;
	}

	public JLabel getLblMnarcotics() {
		return lblMnarcotics;
	}

	public JLabel getLblMmedicine() {
		return lblMmedicine;
	}

	public JLabel getLblMmachines() {
		return lblMmachines;
	}

	public JLabel getLblMfirearms() {
		return lblMfirearms;
	}

	public JLabel getLblMfood() {
		return lblMfood;
	}

	public JLabel getLblMgames() {
		return lblMgames;
	}

	public JLabel getLblMfurs() {
		return lblMfurs;
	}

	public JLabel getLblMwater() {
		return lblMwater;
	}

	public JLabel getLblCrobots() {
		return lblCrobots;
	}

	public JLabel getLblCore() {
		return lblCore;
	}

	public JLabel getLblCnarcotics() {
		return lblCnarcotics;
	}

	public JLabel getLblCmedicine() {
		return lblCmedicine;
	}

	public JLabel getLblCmachines() {
		return lblCmachines;
	}

	public JLabel getLblCfirearms() {
		return lblCfirearms;
	}

	public JLabel getLblCfood() {
		return lblCfood;
	}

	public JLabel getLblCgames() {
		return lblCgames;
	}

	public JLabel getLblCfurs() {
		return lblCfurs;
	}

	public JLabel getLblCwater() {
		return lblCwater;
	}

	public ButtonGroup getBuyGroup() {
		return buyGroup;
	}

	public ButtonGroup getSellGroup() {
		return sellGroup;
	}

	public JButton getWaterBuy() {
		return waterBuy;
	}

	public JButton getFursBuy() {
		return fursBuy;
	}

	public JButton getGamesBuy() {
		return gamesBuy;
	}

	public JButton getFoodBuy() {
		return foodBuy;
	}

	public JButton getFirearmsBuy() {
		return firearmsBuy;
	}

	public JButton getMachinesBuy() {
		return machinesBuy;
	}

	public JButton getMedicineBuy() {
		return medicineBuy;
	}

	public JButton getNarcoticsBuy() {
		return narcoticsBuy;
	}

	public JButton getOreBuy() {
		return oreBuy;
	}

	public JButton getRobotsBuy() {
		return robotsBuy;
	}

	public JButton getWaterSell() {
		return waterSell;
	}

	public JButton getFursSell() {
		return fursSell;
	}

	public JButton getGamesSell() {
		return gamesSell;
	}

	public JButton getFoodSell() {
		return foodSell;
	}

	public JButton getFirearmsSell() {
		return firearmsSell;
	}

	public JButton getMachinesSell() {
		return machinesSell;
	}

	public JButton getMedicineSell() {
		return medicineSell;
	}

	public JButton getNarcoticsSell() {
		return narcoticsSell;
	}

	public JButton getOreSell() {
		return oreSell;
	}

	public JButton getRobotsSell() {
		return robotsSell;
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPlanetName(String name) {
		planetName.setText(name);
	}
}
