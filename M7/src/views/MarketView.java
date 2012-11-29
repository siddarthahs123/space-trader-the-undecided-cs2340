/**
 * package that contains this class
 */
package views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import systems.MainController.BuyListener;
import systems.MainController.FillTank;
import systems.MainController.SaveGameListener;
import systems.MainController.SellListener;
import systems.MainController.MapListener;

/**
 * Screen for markets
 * @author Bao
 * @version 1.0
 */
public class MarketView extends JPanel {

	/**
	 * JPanel
	 */
	private JPanel panel = null;

	/**
	 * X coordinate for panel
	 */
	private static final int XCORD = 6;
	
	/**
	 * Y coordinate for panel
	 */
	private static final int YCORD = 6;
	
	/**
	 * Width for panel
	 */
	private static final int WIDTH = 679;
	
	/**
	 * Height for panel
	 */
	
	private static final int HEIGHT = 473;
	/**
	 * Buttons for new/load/continue game
	 */
	
	/**
	 * Labels for marketview
	 */
	private JLabel planetName, lblMrobots, lblMore, lblMnarcotics,
			lblMmedicine, lblMmachines, lblMfirearms, lblMfood, lblMgames,
			lblMfurs, lblMwater, lblCrobots, lblCore, lblCnarcotics,
			lblCmedicine, lblCmachines, lblCfirearms, lblCfood, lblCgames,
			lblCfurs, lblCwater, spaceWarning, lblremaining, creditWarning,
			lblRemcredits;
	
	/**
	 * Group of buttons
	 */
	private ButtonGroup buyGroup, sellGroup;
	
	/**
	 * Buttons to buy and sell goods
	 */
	private JButton waterBuy, fursBuy, gamesBuy, foodBuy, firearmsBuy,
			machinesBuy, medicineBuy, narcoticsBuy, oreBuy, robotsBuy,
			waterSell, fursSell, gamesSell, foodSell, firearmsSell,
			machinesSell, medicineSell, narcoticsSell, oreSell, robotsSell,
			btnToMap, fuelBuy;
	
	/**
	 * Spinner
	 */
	private JSpinner spinner;
	
	/**
	 * Button to save the game
	 */
	private JButton btnSaveGame;

	/**
	 * Constructor
	 * @param buyListener
	 * @param sellListener
	 * @param mapListener
	 * @param saveGameListener
	 * @param fillTank
	 */
	public MarketView(BuyListener buyListener, SellListener sellListener,
			MapListener mapListener, SaveGameListener saveGameListener,
			FillTank fillTank) {
		panel = new JPanel();
		panel.setBounds(XCORD, YCORD, WIDTH, HEIGHT);
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
		waterBuy.setBounds(367, 95, 115, 29);
		panel.add(waterBuy);
		waterBuy.addActionListener(buyListener);
		waterBuy.setEnabled(false);

		fursBuy = new JButton("Buy");
		fursBuy.setBounds(367, 120, 115, 29);
		panel.add(fursBuy);
		fursBuy.addActionListener(buyListener);
		fursBuy.setEnabled(false);

		gamesBuy = new JButton("Buy");
		gamesBuy.setBounds(367, 145, 115, 29);
		panel.add(gamesBuy);
		gamesBuy.addActionListener(buyListener);
		gamesBuy.setEnabled(false);

		foodBuy = new JButton("Buy");
		foodBuy.setBounds(367, 170, 115, 29);
		panel.add(foodBuy);
		foodBuy.addActionListener(buyListener);
		foodBuy.setEnabled(false);

		firearmsBuy = new JButton("Buy");
		firearmsBuy.setBounds(367, 195, 115, 29);
		panel.add(firearmsBuy);
		firearmsBuy.addActionListener(buyListener);
		firearmsBuy.setEnabled(false);

		machinesBuy = new JButton("Buy");
		machinesBuy.setBounds(367, 220, 115, 29);
		panel.add(machinesBuy);
		machinesBuy.addActionListener(buyListener);
		machinesBuy.setEnabled(false);

		medicineBuy = new JButton("Buy");
		medicineBuy.setBounds(367, 245, 115, 29);
		panel.add(medicineBuy);
		medicineBuy.addActionListener(buyListener);
		medicineBuy.setEnabled(false);

		narcoticsBuy = new JButton("Buy");
		narcoticsBuy.setBounds(367, 270, 115, 29);
		panel.add(narcoticsBuy);
		narcoticsBuy.addActionListener(buyListener);
		narcoticsBuy.setEnabled(false);

		oreBuy = new JButton("Buy");
		oreBuy.setBounds(367, 295, 115, 29);
		panel.add(oreBuy);
		oreBuy.addActionListener(buyListener);
		oreBuy.setEnabled(false);

		robotsBuy = new JButton("Buy");
		robotsBuy.setBounds(367, 320, 115, 29);
		panel.add(robotsBuy);
		robotsBuy.addActionListener(buyListener);
		robotsBuy.setEnabled(false);

		waterSell = new JButton("Sell");
		waterSell.setBounds(476, 95, 115, 29);
		panel.add(waterSell);
		waterSell.addActionListener(sellListener);
		waterSell.setEnabled(false);

		fursSell = new JButton("Sell");
		fursSell.setBounds(476, 120, 115, 29);
		panel.add(fursSell);
		fursSell.addActionListener(sellListener);
		fursSell.setEnabled(false);

		gamesSell = new JButton("Sell");
		gamesSell.setBounds(476, 145, 115, 29);
		panel.add(gamesSell);
		gamesSell.addActionListener(sellListener);
		gamesSell.setEnabled(false);

		foodSell = new JButton("Sell");
		foodSell.setBounds(476, 170, 115, 29);
		panel.add(foodSell);
		foodSell.addActionListener(sellListener);
		foodSell.setEnabled(false);

		firearmsSell = new JButton("Sell");
		firearmsSell.setBounds(476, 195, 115, 29);
		panel.add(firearmsSell);
		firearmsSell.addActionListener(sellListener);
		firearmsSell.setEnabled(false);

		machinesSell = new JButton("Sell");
		machinesSell.setBounds(476, 220, 115, 29);
		panel.add(machinesSell);
		machinesSell.addActionListener(sellListener);
		machinesSell.setEnabled(false);

		medicineSell = new JButton("Sell");
		medicineSell.setBounds(476, 245, 115, 29);
		panel.add(medicineSell);
		medicineSell.addActionListener(sellListener);
		medicineSell.setEnabled(false);

		narcoticsSell = new JButton("Sell");
		narcoticsSell.setBounds(476, 270, 115, 29);
		panel.add(narcoticsSell);
		narcoticsSell.addActionListener(sellListener);
		narcoticsSell.setEnabled(false);

		oreSell = new JButton("Sell");
		oreSell.setBounds(476, 295, 115, 29);
		panel.add(oreSell);
		oreSell.addActionListener(sellListener);
		oreSell.setEnabled(false);

		robotsSell = new JButton("Sell");
		robotsSell.setBounds(476, 320, 115, 29);
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
		spaceWarning.setBounds(354, 361, 237, 16);
		panel.add(spaceWarning);
		spaceWarning.setVisible(false);

		lblremaining = new JLabel("[remaining]");
		lblremaining.setBounds(227, 75, 61, 16);
		panel.add(lblremaining);

		spinner = new JSpinner();
		spinner.setBounds(592, 211, 61, 28);
		panel.add(spinner);
		spinner.setValue(1);
		spinner.addChangeListener(new SpinListener());

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

		creditWarning = new JLabel("Not enough credits remaining!");
		creditWarning.setHorizontalAlignment(SwingConstants.CENTER);
		creditWarning.setBounds(364, 381, 227, 16);
		panel.add(creditWarning);

		btnToMap = new JButton("To Map");
		btnToMap.setBounds(6, 20, 117, 29);
		panel.add(btnToMap);

		fuelBuy = new JButton("Buy");
		fuelBuy.setEnabled(false);
		fuelBuy.setBounds(151, 365, 115, 29);
		fuelBuy.addActionListener(fillTank);
		panel.add(fuelBuy);

		JLabel lblFuel = new JLabel("Fuel");
		lblFuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuel.setBounds(55, 372, 61, 16);
		panel.add(lblFuel);

		btnSaveGame = new JButton("Save Game");
		btnSaveGame.setBounds(543, 414, 104, 29);
		panel.add(btnSaveGame);
		btnSaveGame.addActionListener(saveGameListener);

		creditWarning.setVisible(false);
		btnToMap.addActionListener(mapListener);

	}

	/**
	 * Listener class for spinners
	 * @author Bao
	 *
	 */
	public class SpinListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			if ((Integer) spinner.getValue() < 1) {
				spinner.setValue(1);
			}
		}
	}

	/**
	 * Returns save button
	 * @return save button
	 */
	public JButton getSaveButton() {
		return btnSaveGame;
	}

	/**
	 * Returns cost
	 * @return cost
	 */
	public int getAmount() {
		return (Integer) spinner.getValue();
	}

	/**
	 * Returns planet name
	 * @return planet name
	 */
	public JLabel getPlanetName() {
		return planetName;
	}

	/**
	 * Returns robot labels
	 * @return robot labels
	 */
	public JLabel getLblMrobots() {
		return lblMrobots;
	}

	/**
	 * Returns more label
	 * @return more label
	 */
	public JLabel getLblMore() {
		return lblMore;
	}

	/**
	 * Return narcotics label
	 * @return narcotics label
	 */
	public JLabel getLblMnarcotics() {
		return lblMnarcotics;
	}

	/**
	 * Return medicine label
	 * @return medicine label
	 */
	public JLabel getLblMmedicine() {
		return lblMmedicine;
	}

	/**
	 * Returns machine label
	 * @return machine label
	 */
	public JLabel getLblMmachines() {
		return lblMmachines;
	}

	/**
	 * Returns firearms label
	 * @return firearms label
	 */
	public JLabel getLblMfirearms() {
		return lblMfirearms;
	}

	/**
	 * Returns food label
	 * @return food label
	 */
	public JLabel getLblMfood() {
		return lblMfood;
	}

	/**
	 * Returns games label
	 * @return games label
	 */
	public JLabel getLblMgames() {
		return lblMgames;
	}

	/**
	 * Returns furs label
	 * @return furs label
	 */
	public JLabel getLblMfurs() {
		return lblMfurs;
	}

	/**
	 * Returns water label
	 * @return water label
	 */
	public JLabel getLblMwater() {
		return lblMwater;
	}

	/**
	 * Returns robots cost label
	 * @return robots cost label
	 */
	public JLabel getLblCrobots() {
		return lblCrobots;
	}

	/**
	 * Returns ore cost label
	 * @return ore cost label
	 */
	public JLabel getLblCore() {
		return lblCore;
	}

	/**
	 * Returns narcotics cost label
	 * @return narcotics cost label
	 */
	public JLabel getLblCnarcotics() {
		return lblCnarcotics;
	}

	/**
	 * Returns medicine cost label
	 * @return medicine cost label
	 */
	public JLabel getLblCmedicine() {
		return lblCmedicine;
	}

	/**
	 * Returns machines cost label
	 * @return machines cost label
	 */
	public JLabel getLblCmachines() {
		return lblCmachines;
	}

	/**
	 * Returns firearms cost label
	 * @return firearms cost label
	 */
	public JLabel getLblCfirearms() {
		return lblCfirearms;
	}

	/**
	 * Returns food cost label
	 * @return food cost label
	 */
	public JLabel getLblCfood() {
		return lblCfood;
	}

	/**
	 * Returns games cost label
	 * @return games cost label
	 */
	public JLabel getLblCgames() {
		return lblCgames;
	}

	/**
	 * Returns furs cost label
	 * @return furs cost label
	 */
	public JLabel getLblCfurs() {
		return lblCfurs;
	}

	/**
	 * Returns water cost label
	 * @return water cost label
	 */
	public JLabel getLblCwater() {
		return lblCwater;
	}

	/**
	 * Returns buttons for buying items
	 * @return buying buttons
	 */
	public ButtonGroup getBuyGroup() {
		return buyGroup;
	}

	/**
	 * Returns buttons for sellings items
	 * @return
	 */
	public ButtonGroup getSellGroup() {
		return sellGroup;
	}

	/**
	 * Returns button to buy water
	 * @return button to buy water
	 */
	public JButton getWaterBuy() {
		return waterBuy;
	}

	/**
	 * Returns button to buy water
	 * @return button to buy water
	 */
	public JButton getFursBuy() {
		return fursBuy;
	}

	/**
	 * Returns button to buy games
	 * @return button to buy games
	 */
	public JButton getGamesBuy() {
		return gamesBuy;
	}

	/**
	 * Returns button to buy food
	 * @return button to buy food
	 */
	public JButton getFoodBuy() {
		return foodBuy;
	}

	/**
	 * Returns button to buy firearms
	 * @return button to buy firearms
	 */
	public JButton getFirearmsBuy() {
		return firearmsBuy;
	}

	/**
	 * Returns button to buy machines
	 * @return button to buy machines
	 */
	public JButton getMachinesBuy() {
		return machinesBuy;
	}

	/**
	 * Returns button to buy medicine
	 * @return button to buy medicine
	 */
	public JButton getMedicineBuy() {
		return medicineBuy;
	}

	/**
	 * Returns button to buy narcotics
	 * @return button to buy narcotics
	 */
	public JButton getNarcoticsBuy() {
		return narcoticsBuy;
	}

	/**
	 * Returns button to buy ore
	 * @return button to buy ore
	 */
	public JButton getOreBuy() {
		return oreBuy;
	}

	/**
	 * Returns button to buy robots
	 * @return button to buy robots
	 */
	public JButton getRobotsBuy() {
		return robotsBuy;
	}

	/**
	 * Returns button to sell water
	 * @return button to sell water
	 */
	public JButton getWaterSell() {
		return waterSell;
	}

	/**
	 * Returns button to sell furs
	 * @return button to sell furs
	 */
	public JButton getFursSell() {
		return fursSell;
	}

	/**
	 * Returns button to sell games
	 * @return button to sell games
	 */
	public JButton getGamesSell() {
		return gamesSell;
	}

	/**
	 * Returns button to sell food
	 * @return button to sell food
	 */
	public JButton getFoodSell() {
		return foodSell;
	}

	/**
	 * Returns button to sell firearms
	 * @return button to sell firearms
	 */
	public JButton getFirearmsSell() {
		return firearmsSell;
	}

	/**
	 * Returns button to sell machines
	 * @return button to sell machines
	 */
	public JButton getMachinesSell() {
		return machinesSell;
	}

	/**
	 * Returns button to sell medicine
	 * @return button to sell medicine
	 */
	public JButton getMedicineSell() {
		return medicineSell;
	}

	/**
	 * Returns button to sell narcotics
	 * @return
	 */
	public JButton getNarcoticsSell() {
		return narcoticsSell;
	}

	/**
	 * Returns button to sell ore
	 * @return button to sell ore
	 */
	public JButton getOreSell() {
		return oreSell;
	}

	/**
	 * Returns button to sell robots
	 * @return button to sell robots
	 */
	public JButton getRobotsSell() {
		return robotsSell;
	}

	/**
	 * Returns the panel for market view
	 * @return market view panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Returns warning for no more inventory space
	 * @return warning for no more inventory space
	 */
	public JLabel getSpaceWarning() {
		return spaceWarning;
	}

	/**
	 * Sets the name for the planet
	 * @param name
	 */
	public void setPlanetName(String name) {
		planetName.setText(name);
	}

	/**
	 * Sets the remaining trade goods
	 * @param amount
	 */
	public void setLblRemaining(String amount) {
		lblremaining.setText("[" + amount + "]");
	}

	/**
	 * Returns the credits left
	 * @return remaining credits
	 */
	public JLabel getLblRemcredits() {
		return lblRemcredits;
	}

	/**
	 * Returns warning if the player doesn't have enough credits
	 * @return credit warning
	 */
	public JLabel getCreditWarning() {
		return creditWarning;
	}

	/**
	 * Returns button to go back to universe view
	 * @return button to go back to universe view
	 */
	public JButton getBtnToMap() {
		return btnToMap;
	}

	/**
	 * Returns button to buy fuel
	 * @return button to buy fuel
	 */
	public JButton getBuyFuel() {
		return fuelBuy;
	}
	
	/**
	 * MarketView toString method
	 * @return nothing
	 */
	public String toString() {
		return "";
	}
}
