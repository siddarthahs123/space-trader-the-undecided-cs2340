/**
 * package that this class is from
 */
package views;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.tradegood.Firearms;
import models.tradegood.Food;
import models.tradegood.Furs;
import models.tradegood.Games;
import models.tradegood.Machines;
import models.tradegood.Medicine;
import models.tradegood.Narcotics;
import models.tradegood.Ore;
import models.tradegood.Robots;
import models.tradegood.TradeGood;
import models.tradegood.Water;
import systems.MainController.MarketListener;

/**
 * Screen for encounters
 * 
 * @author Bao
 * @version 1.0
 */
@SuppressWarnings("serial")
public class EncounterView extends JPanel {

	/**
	 * Panel
	 */
	private JPanel panel = null;

	/**
	 * Change in credits
	 */
	private double creditChange = 0;

	/**
	 * Encounter message
	 */
	private final JLabel message = new JLabel();

	/**
	 * continue button
	 */
	private final JButton CONT = new JButton("Continue");

	/**
	 * Random generator
	 */
	private static final Random GEN = new Random();

	/**
	 * String array of goods
	 */
	private final String[] randGoods = { "Water", "Furs", "Games", "Food",
			"Firearms", "Machines", "Medicine", "Narcotics", "Ore", "Robots" };

	/**
	 * Trade goods
	 */
	private TradeGood randomGood;

	/**
	 * Key for hashmap
	 */
	private String randomGoodKey;

	/**
	 * Random integer value
	 */
	private int random;

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
	 * Credit factor for bad encounters
	 */
	private static final int BADFACTOR = 200;

	/**
	 * Credit factor for good encounters
	 */
	private static final int GOODFACTOR = 100;

	/**
	 * Total options for encounters
	 */
	private static final int TOTAL_CHOICES = 3;
	
	/**
	 * Total options for good encounters
	 */
	private static final int CHOICE_GOOD = 2;
	
	/**
	 * Constructor
	 * 
	 * @param ml
	 */
	public EncounterView(MarketListener ml) {
		new JPanel();
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setBackground(Color.black);
		selectEncounter();
		CONT.setBounds(289, 42, 101, 29);
		CONT.addActionListener(ml);
		message.setBounds(6, 6, 667, 29);
		message.setForeground(Color.white);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		CONT.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(null);
		add(message);
		add(CONT);
	}

	/**
	 * Randomly chooses encounters
	 */
	public void selectEncounter() {
		final int chance = GEN.nextInt(TOTAL_CHOICES);
		if (chance == 0) {
			goodEncounter();
		} else if (chance == 1) {
			badEncounter();
		} else {
			noEncounter();
		}
	}

	/**
	 * Entails what a good encounter may be
	 */
	public void goodEncounter() {
		random = GEN.nextInt(randGoods.length - 1);
		final int chance = GEN.nextInt(CHOICE_GOOD);
		if (chance == 0) {
			creditChange = Math.floor(GEN.nextDouble() * GOODFACTOR);
			message.setText("You found " + creditChange + " credits!");
		} else {
			randomGood = randomTradeGood(random);
			message.setText("You found " + randomGoodKey);
		}
	}

	/**
	 * Entails what a bad encounter may be
	 */
	public void badEncounter() {
		creditChange = -1 * Math.floor(GEN.nextDouble() * BADFACTOR);
		message.setText("Pirates stole " + -1 * creditChange
				+ " credits from you...");
	}

	/**
	 * Nothing happens
	 */
	public void noEncounter() {
		message.setText("You have arrived at your destination safely.");
	}

	/**
	 * Returns a random trade good
	 * 
	 * @param choice
	 * @return random trade good
	 */
	public TradeGood randomTradeGood(int choice) {
		TradeGood newObj = null;
		randomGoodKey = randGoods[choice];
		if (randomGoodKey.equals("Water")) {
			newObj = new Water();
		} else if (randomGoodKey.equals("Furs")) {
			newObj = new Furs();
		} else if (randomGoodKey.equals("Games")) {
			newObj = new Games();
		} else if (randomGoodKey.equals("Food")) {
			newObj = new Food();
		} else if (randomGoodKey.equals("Firearms")) {
			newObj = new Firearms();
		} else if (randomGoodKey.equals("Machines")) {
			newObj = new Machines();
		} else if (randomGoodKey.equals("Medicine")) {
			newObj = new Medicine();
		} else if (randomGoodKey.equals("Narcotics")) {
			newObj = new Narcotics();
		} else if (randomGoodKey.equals("Ore")) {
			newObj = new Ore();
		} else if (randomGoodKey.equals("Robots")) {
			newObj = new Robots();
		}
		return newObj;
	}

	/**
	 * Returns panel
	 * 
	 * @return panel
	 */
	public JPanel getPanel() {
		return this;
	}

	/**
	 * Returns credit change
	 * 
	 * @return credit change
	 */
	public double getCreditChange() {
		return creditChange;
	}

	/**
	 * Returns the random trade good
	 * 
	 * @return random trade good
	 */
	public TradeGood getTradeGood() {
		return randomGood;
	}

	/**
	 * Returns the trade good key
	 * 
	 * @return trade good key
	 */
	public String getTradeGoodKey() {
		return randomGoodKey;
	}

	/**
	 * Returns a string array of the random trade goods
	 * 
	 * @return string array of goods
	 */
	public String[] getRandGoods() {
		return randGoods;
	}

}
