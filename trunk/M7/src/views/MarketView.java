/**
 * package that contains this class
 */
package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
			lblRemcredits, fuelLabel;
	
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

	private BufferedImage image;
	
	private ImageIcon image1;

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
		
		File file = new File ("src/views/marketBackground.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		image1 = new ImageIcon(getClass().getResource("/views/marketBackground.png"));
		
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setLayout(null);
		
		

		planetName = new JLabel("Planet");
		planetName.setForeground(Color.WHITE);
		planetName.setHorizontalAlignment(SwingConstants.CENTER);
		planetName.setBounds(250, 25, 174, 16);
		add(planetName);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setForeground(Color.WHITE);
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setBounds(175, 75, 61, 16);
		add(lblCargo);

		JLabel lblMarket = new JLabel("Market");
		lblMarket.setForeground(Color.WHITE);
		lblMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarket.setBounds(300, 75, 61, 16);
		add(lblMarket);

		JLabel lblWater = new JLabel("Water");
		lblWater.setForeground(Color.WHITE);
		lblWater.setHorizontalAlignment(SwingConstants.CENTER);
		lblWater.setBounds(50, 100, 70, 14);
		add(lblWater);

		JLabel lblFurs = new JLabel("Furs");
		lblFurs.setForeground(Color.WHITE);
		lblFurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFurs.setBounds(50, 125, 70, 14);
		add(lblFurs);

		JLabel lblGames = new JLabel("Games");
		lblGames.setForeground(Color.WHITE);
		lblGames.setHorizontalAlignment(SwingConstants.CENTER);
		lblGames.setBounds(50, 150, 70, 14);
		add(lblGames);

		JLabel lblFood = new JLabel("Food");
		lblFood.setForeground(Color.WHITE);
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setBounds(50, 175, 70, 14);
		add(lblFood);

		JLabel lblFirearms = new JLabel("Firearms");
		lblFirearms.setForeground(Color.WHITE);
		lblFirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirearms.setBounds(50, 200, 70, 14);
		add(lblFirearms);

		JLabel lblMachines = new JLabel("Machines");
		lblMachines.setForeground(Color.WHITE);
		lblMachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMachines.setBounds(50, 225, 70, 14);
		add(lblMachines);

		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setForeground(Color.WHITE);
		lblMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicine.setBounds(50, 250, 70, 14);
		add(lblMedicine);

		JLabel lblNarcotics = new JLabel("Narcotics");
		lblNarcotics.setForeground(Color.WHITE);
		lblNarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblNarcotics.setBounds(50, 275, 70, 14);
		add(lblNarcotics);

		JLabel lblOre = new JLabel("Ore");
		lblOre.setForeground(Color.WHITE);
		lblOre.setHorizontalAlignment(SwingConstants.CENTER);
		lblOre.setBounds(50, 300, 70, 14);
		add(lblOre);

		JLabel lblRobots = new JLabel("Robots");
		lblRobots.setForeground(Color.WHITE);
		lblRobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobots.setBounds(50, 325, 70, 14);
		add(lblRobots);

		lblCwater = new JLabel("cWater");
		lblCwater.setForeground(Color.WHITE);
		lblCwater.setHorizontalAlignment(SwingConstants.CENTER);
		lblCwater.setBounds(175, 100, 61, 14);
		add(lblCwater);

		lblCfurs = new JLabel("cFurs");
		lblCfurs.setForeground(Color.WHITE);
		lblCfurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfurs.setBounds(175, 125, 61, 14);
		add(lblCfurs);

		lblCgames = new JLabel("cGames");
		lblCgames.setForeground(Color.WHITE);
		lblCgames.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgames.setBounds(175, 150, 61, 14);
		add(lblCgames);

		lblCfood = new JLabel("cFood");
		lblCfood.setForeground(Color.WHITE);
		lblCfood.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfood.setBounds(175, 175, 61, 14);
		add(lblCfood);

		lblCfirearms = new JLabel("cFirearms");
		lblCfirearms.setForeground(Color.WHITE);
		lblCfirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfirearms.setBounds(175, 200, 61, 14);
		add(lblCfirearms);

		lblCmachines = new JLabel("cMachines");
		lblCmachines.setForeground(Color.WHITE);
		lblCmachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmachines.setBounds(175, 225, 61, 14);
		add(lblCmachines);

		lblCmedicine = new JLabel("cMedicine");
		lblCmedicine.setForeground(Color.WHITE);
		lblCmedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmedicine.setBounds(175, 250, 61, 14);
		add(lblCmedicine);

		lblCnarcotics = new JLabel("cNarcotics");
		lblCnarcotics.setForeground(Color.WHITE);
		lblCnarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnarcotics.setBounds(175, 275, 61, 14);
		add(lblCnarcotics);

		lblCore = new JLabel("cOre");
		lblCore.setForeground(Color.WHITE);
		lblCore.setHorizontalAlignment(SwingConstants.CENTER);
		lblCore.setBounds(175, 300, 61, 14);
		add(lblCore);

		lblCrobots = new JLabel("cRobots");
		lblCrobots.setForeground(Color.WHITE);
		lblCrobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrobots.setBounds(175, 325, 61, 14);
		add(lblCrobots);

		lblMwater = new JLabel("mWater");
		lblMwater.setForeground(Color.WHITE);
		lblMwater.setHorizontalAlignment(SwingConstants.CENTER);
		lblMwater.setBounds(300, 100, 61, 14);
		add(lblMwater);

		lblMfurs = new JLabel("mFurs");
		lblMfurs.setForeground(Color.WHITE);
		lblMfurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfurs.setBounds(300, 125, 61, 14);
		add(lblMfurs);

		lblMgames = new JLabel("mGames");
		lblMgames.setForeground(Color.WHITE);
		lblMgames.setHorizontalAlignment(SwingConstants.CENTER);
		lblMgames.setBounds(300, 150, 61, 14);
		add(lblMgames);

		lblMfood = new JLabel("mFood");
		lblMfood.setForeground(Color.WHITE);
		lblMfood.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfood.setBounds(300, 175, 61, 14);
		add(lblMfood);

		lblMfirearms = new JLabel("mFirearms");
		lblMfirearms.setForeground(Color.WHITE);
		lblMfirearms.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfirearms.setBounds(300, 200, 61, 14);
		add(lblMfirearms);

		lblMmachines = new JLabel("mMachines");
		lblMmachines.setForeground(Color.WHITE);
		lblMmachines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMmachines.setBounds(300, 225, 61, 14);
		add(lblMmachines);

		lblMmedicine = new JLabel("mMedicine");
		lblMmedicine.setForeground(Color.WHITE);
		lblMmedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblMmedicine.setBounds(300, 250, 61, 14);
		add(lblMmedicine);

		lblMnarcotics = new JLabel("mNarcotics");
		lblMnarcotics.setForeground(Color.WHITE);
		lblMnarcotics.setHorizontalAlignment(SwingConstants.CENTER);
		lblMnarcotics.setBounds(300, 275, 61, 14);
		add(lblMnarcotics);

		lblMore = new JLabel("mOre");
		lblMore.setForeground(Color.WHITE);
		lblMore.setHorizontalAlignment(SwingConstants.CENTER);
		lblMore.setBounds(300, 300, 61, 14);
		add(lblMore);

		lblMrobots = new JLabel("mRobots");
		lblMrobots.setForeground(Color.WHITE);
		lblMrobots.setHorizontalAlignment(SwingConstants.CENTER);
		lblMrobots.setBounds(300, 325, 61, 14);
		add(lblMrobots);

		waterBuy = new JButton("Buy");
		waterBuy.setBounds(367, 95, 115, 29);
		add(waterBuy);
		waterBuy.addActionListener(buyListener);
		waterBuy.setEnabled(false);

		fursBuy = new JButton("Buy");
		fursBuy.setBounds(367, 120, 115, 29);
		add(fursBuy);
		fursBuy.addActionListener(buyListener);
		fursBuy.setEnabled(false);

		gamesBuy = new JButton("Buy");
		gamesBuy.setBounds(367, 145, 115, 29);
		add(gamesBuy);
		gamesBuy.addActionListener(buyListener);
		gamesBuy.setEnabled(false);

		foodBuy = new JButton("Buy");
		foodBuy.setBounds(367, 170, 115, 29);
		add(foodBuy);
		foodBuy.addActionListener(buyListener);
		foodBuy.setEnabled(false);

		firearmsBuy = new JButton("Buy");
		firearmsBuy.setBounds(367, 195, 115, 29);
		add(firearmsBuy);
		firearmsBuy.addActionListener(buyListener);
		firearmsBuy.setEnabled(false);

		machinesBuy = new JButton("Buy");
		machinesBuy.setBounds(367, 220, 115, 29);
		add(machinesBuy);
		machinesBuy.addActionListener(buyListener);
		machinesBuy.setEnabled(false);

		medicineBuy = new JButton("Buy");
		medicineBuy.setBounds(367, 245, 115, 29);
		add(medicineBuy);
		medicineBuy.addActionListener(buyListener);
		medicineBuy.setEnabled(false);

		narcoticsBuy = new JButton("Buy");
		narcoticsBuy.setBounds(367, 270, 115, 29);
		add(narcoticsBuy);
		narcoticsBuy.addActionListener(buyListener);
		narcoticsBuy.setEnabled(false);

		oreBuy = new JButton("Buy");
		oreBuy.setBounds(367, 295, 115, 29);
		add(oreBuy);
		oreBuy.addActionListener(buyListener);
		oreBuy.setEnabled(false);

		robotsBuy = new JButton("Buy");
		robotsBuy.setBounds(367, 320, 115, 29);
		add(robotsBuy);
		robotsBuy.addActionListener(buyListener);
		robotsBuy.setEnabled(false);

		waterSell = new JButton("Sell");
		waterSell.setBounds(476, 95, 115, 29);
		add(waterSell);
		waterSell.addActionListener(sellListener);
		waterSell.setEnabled(false);

		fursSell = new JButton("Sell");
		fursSell.setBounds(476, 120, 115, 29);
		add(fursSell);
		fursSell.addActionListener(sellListener);
		fursSell.setEnabled(false);

		gamesSell = new JButton("Sell");
		gamesSell.setBounds(476, 145, 115, 29);
		add(gamesSell);
		gamesSell.addActionListener(sellListener);
		gamesSell.setEnabled(false);

		foodSell = new JButton("Sell");
		foodSell.setBounds(476, 170, 115, 29);
		add(foodSell);
		foodSell.addActionListener(sellListener);
		foodSell.setEnabled(false);

		firearmsSell = new JButton("Sell");
		firearmsSell.setBounds(476, 195, 115, 29);
		add(firearmsSell);
		firearmsSell.addActionListener(sellListener);
		firearmsSell.setEnabled(false);

		machinesSell = new JButton("Sell");
		machinesSell.setBounds(476, 220, 115, 29);
		add(machinesSell);
		machinesSell.addActionListener(sellListener);
		machinesSell.setEnabled(false);

		medicineSell = new JButton("Sell");
		medicineSell.setBounds(476, 245, 115, 29);
		add(medicineSell);
		medicineSell.addActionListener(sellListener);
		medicineSell.setEnabled(false);

		narcoticsSell = new JButton("Sell");
		narcoticsSell.setBounds(476, 270, 115, 29);
		add(narcoticsSell);
		narcoticsSell.addActionListener(sellListener);
		narcoticsSell.setEnabled(false);

		oreSell = new JButton("Sell");
		oreSell.setBounds(476, 295, 115, 29);
		add(oreSell);
		oreSell.addActionListener(sellListener);
		oreSell.setEnabled(false);

		robotsSell = new JButton("Sell");
		robotsSell.setBounds(476, 320, 115, 29);
		add(robotsSell);
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
		spaceWarning.setForeground(Color.WHITE);
		spaceWarning.setHorizontalAlignment(SwingConstants.CENTER);
		spaceWarning.setBounds(354, 361, 237, 16);
		add(spaceWarning);
		spaceWarning.setVisible(false);

		lblremaining = new JLabel("[remaining]");
		lblremaining.setForeground(Color.WHITE);
		lblremaining.setBounds(227, 75, 61, 16);
		add(lblremaining);

		spinner = new JSpinner();
		spinner.setBounds(592, 211, 61, 28);
		add(spinner);
		spinner.setValue(1);
		spinner.addChangeListener(new SpinListener());

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(592, 194, 61, 16);
		add(lblAmount);

		JLabel lblCredits = new JLabel("Credits:");
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setBounds(565, 25, 61, 16);
		add(lblCredits);

		lblRemcredits = new JLabel("remCredits");
		lblRemcredits.setForeground(Color.WHITE);
		lblRemcredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemcredits.setBounds(565, 46, 61, 16);
		add(lblRemcredits);

		creditWarning = new JLabel("Not enough credits remaining!");
		creditWarning.setForeground(Color.WHITE);
		creditWarning.setHorizontalAlignment(SwingConstants.CENTER);
		creditWarning.setBounds(364, 381, 227, 16);
		add(creditWarning);

		btnToMap = new JButton("To Map");
		btnToMap.setBounds(6, 20, 117, 29);
		add(btnToMap);

		fuelBuy = new JButton("Buy");
		fuelBuy.setEnabled(false);
		fuelBuy.setBounds(151, 365, 115, 29);
		fuelBuy.addActionListener(fillTank);
		add(fuelBuy);

		JLabel lblFuel = new JLabel("Fuel");
		lblFuel.setForeground(Color.WHITE);
		lblFuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuel.setBounds(55, 372, 61, 16);
		add(lblFuel);

		btnSaveGame = new JButton("Save Game");
		btnSaveGame.setBounds(543, 414, 104, 29);
		add(btnSaveGame);
		
		JLabel lblFuelRemaining = new JLabel("Fuel Remaining:");
		lblFuelRemaining.setForeground(Color.WHITE);
		lblFuelRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelRemaining.setBounds(35, 419, 109, 16);
		add(lblFuelRemaining);
		
		fuelLabel = new JLabel("xxx");
		fuelLabel.setForeground(Color.WHITE);
		fuelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fuelLabel.setBounds(151, 419, 48, 16);
		add(fuelLabel);
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
	 * paints bg
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(image, 0, 0, null);
		image1.paintIcon(this, g, 0, 0);
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
		return this;
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
	
	public void setFuelLabel(int fuel) {
		fuelLabel.setText(""+fuel);
	}
}
