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
		lblCfood, lblCgames, lblCfurs, lblCwater, spaceWarning, lblremaining;;
	private ButtonGroup buyGroup, sellGroup;
	private JButton waterBuy, fursBuy, gamesBuy, foodBuy, firearmsBuy, machinesBuy, medicineBuy, narcoticsBuy, oreBuy,
		robotsBuy, waterSell, fursSell, gamesSell, foodSell, firearmsSell, machinesSell, medicineSell, narcoticsSell, oreSell,
		robotsSell;
	private JSpinner spinner;
	private JLabel lblRemcredits;

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
		waterBuy.setBounds(386, 94, 97, 29);
		panel.add(waterBuy);
		waterBuy.addActionListener(buyListener);
		waterBuy.setEnabled(false);
		
		fursBuy = new JButton("Buy");
		fursBuy.setBounds(386, 119, 97, 29);
		panel.add(fursBuy);
		fursBuy.addActionListener(buyListener);
		fursBuy.setEnabled(false);
		
		gamesBuy = new JButton("Buy");
		gamesBuy.setBounds(386, 144, 97, 29);
		panel.add(gamesBuy);
		gamesBuy.addActionListener(buyListener);
		gamesBuy.setEnabled(false);
		
		foodBuy = new JButton("Buy");
		foodBuy.setBounds(386, 169, 97, 29);
		panel.add(foodBuy);
		foodBuy.addActionListener(buyListener);
		foodBuy.setEnabled(false);
		
		firearmsBuy = new JButton("Buy");
		firearmsBuy.setBounds(386, 194, 97, 29);
		panel.add(firearmsBuy);
		firearmsBuy.addActionListener(buyListener);
		firearmsBuy.setEnabled(false);
		
		machinesBuy = new JButton("Buy");
		machinesBuy.setBounds(386, 219, 97, 29);
		panel.add(machinesBuy);
		machinesBuy.addActionListener(buyListener);
		machinesBuy.setEnabled(false);
		
		medicineBuy = new JButton("Buy");
		medicineBuy.setBounds(386, 244, 97, 29);
		panel.add(medicineBuy);
		medicineBuy.addActionListener(buyListener);
		medicineBuy.setEnabled(false);
		
		narcoticsBuy = new JButton("Buy");
		narcoticsBuy.setBounds(386, 269, 97, 29);
		panel.add(narcoticsBuy);
		narcoticsBuy.addActionListener(buyListener);
		narcoticsBuy.setEnabled(false);
		
		oreBuy = new JButton("Buy");
		oreBuy.setBounds(386, 294, 97, 29);
		panel.add(oreBuy);
		oreBuy.addActionListener(buyListener);
		oreBuy.setEnabled(false);
		
		robotsBuy = new JButton("Buy");
		robotsBuy.setBounds(386, 319, 97, 29);
		panel.add(robotsBuy);
		robotsBuy.addActionListener(buyListener);
		robotsBuy.setEnabled(false);
		
		waterSell = new JButton("Sell");
		waterSell.setBounds(476, 94, 97, 29);
		panel.add(waterSell);
		waterSell.addActionListener(sellListener);
		waterSell.setEnabled(false);
		
		fursSell = new JButton("Sell");
		fursSell.setBounds(476, 119, 97, 29);
		panel.add(fursSell);
		fursSell.addActionListener(sellListener);
		fursSell.setEnabled(false);
		
		gamesSell = new JButton("Sell");
		gamesSell.setBounds(476, 144, 97, 29);
		panel.add(gamesSell);
		gamesSell.addActionListener(sellListener);
		gamesSell.setEnabled(false);
		
		foodSell = new JButton("Sell");
		foodSell.setBounds(476, 169, 97, 29);
		panel.add(foodSell);
		foodSell.addActionListener(sellListener);
		foodSell.setEnabled(false);
		
		firearmsSell = new JButton("Sell");
		firearmsSell.setBounds(476, 194, 97, 29);
		panel.add(firearmsSell);
		firearmsSell.addActionListener(sellListener);
		firearmsSell.setEnabled(false);
		
		machinesSell = new JButton("Sell");
		machinesSell.setBounds(476, 219, 97, 29);
		panel.add(machinesSell);
		machinesSell.addActionListener(sellListener);
		machinesSell.setEnabled(false);
		
		medicineSell = new JButton("Sell");
		medicineSell.setBounds(476, 244, 97, 29);
		panel.add(medicineSell);
		medicineSell.addActionListener(sellListener);
		medicineSell.setEnabled(false);
		
		narcoticsSell = new JButton("Sell");
		narcoticsSell.setBounds(476, 269, 97, 29);
		panel.add(narcoticsSell);
		narcoticsSell.addActionListener(sellListener);
		narcoticsSell.setEnabled(false);
		
		oreSell = new JButton("Sell");
		oreSell.setBounds(476, 294, 97, 29);
		panel.add(oreSell);
		oreSell.addActionListener(sellListener);
		oreSell.setEnabled(false);
		
		robotsSell = new JButton("Sell");
		robotsSell.setBounds(476, 319, 97, 29);
		panel.add(robotsSell);
		robotsSell.addActionListener(sellListener);
		robotsSell.setEnabled(false);
		
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
		
		spaceWarning = new JLabel("No space remaining in cargo hold!");
		spaceWarning.setHorizontalAlignment(SwingConstants.CENTER);
		spaceWarning.setBounds(227, 371, 237, 16);
		panel.add(spaceWarning);
		spaceWarning.setVisible(false);
		
		lblremaining = new JLabel("[remaining]");
		lblremaining.setBounds(227, 75, 61, 16);
		panel.add(lblremaining);
		
		spinner = new JSpinner();
		spinner.setBounds(592, 211, 61, 28);
		panel.add(spinner);
		spinner.setValue(1);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(592, 194, 61, 16);
		panel.add(lblAmount);
		
		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setBounds(565, 25, 61, 16);
		panel.add(lblCredits);
		
		lblRemcredits = new JLabel("remCredits");
		lblRemcredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemcredits.setBounds(565, 46, 61, 16);
		panel.add(lblRemcredits);
	}
	
	public int getAmount() {
		return (Integer)spinner.getValue();
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
	
	public JLabel getSpaceWarning() {
		return spaceWarning;
	}
	
	public void setPlanetName(String name) {
		planetName.setText(name);
	}
	
	public void setLblRemaining(String amount) {
		lblremaining.setText("["+amount+"]");
	}
	
	public JLabel getLblRemcredits() {
		return lblRemcredits;
	}
}
