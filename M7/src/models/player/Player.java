/**
 * package that contains this class
 */
package models.player;

/**
 * 
 * @author Samarth
 * 
 *         This class is used to create a player
 * 
 * @version $Revision: 1.0 $
 */
public class Player {
	/**
	 * Player's information
	 */
	private int pilot, fighter, trader, engineer, karma, difficulty, turn;

	/**
	 * Player's fuel
	 */
	private int fuel = 700;

	/**
	 * The player's money
	 */
	private double credits = 2500;

	/**
	 * The player's name
	 */
	private String name;

	/**
	 * Difficulty factor
	 */
	private static final int DIFF_FACT = 750;
	
	/**
	 * The player's record with the police
	 */
	private boolean policeRecord;

	/**
	 * Main Constructor allocates the skills of the player and the difficulty
	 * level and the name of the player
	 * 
	 * @param pilot
	 * @param fighter
	 * @param trader
	 * @param engineer
	 * @param difficulty
	 * @param name
	 */
	public Player(int pilot, int fighter, int trader, int engineer,
			int difficulty, String name) {
		this.pilot = pilot;
		this.fighter = fighter;
		this.trader = trader;
		this.engineer = engineer;
		karma = 0;
		this.name = name;
		policeRecord = false;
		this.difficulty = difficulty;

		turn = 0;
		credits = credits - (difficulty * DIFF_FACT);
	}

	/**
	 * Used to print the data of the player to the console
	 */
	public void printData() {
		System.out.println("Name: " + name);
		System.out.println("Pilot: " + pilot);
		System.out.println("Fighter: " + fighter);
		System.out.println("Trader: " + trader);
		System.out.println("Engineer: " + engineer);
		System.out.println("Credits: " + credits);
		System.out.println("Karma: " + karma);
		System.out.println("Difficulty: " + difficulty);
	}

	/**
	 * Gets the pilot skill level
	 * 
	 * @return int
	 */
	public int getPilot() {
		return pilot;
	}

	/**
	 * Sets the pilot skill level
	 * 
	 * @param pilot
	 */
	public void setPilot(int pilot) {
		this.pilot = pilot;
	}

	/**
	 * Gets the fighter skill level
	 * 
	 * @return int
	 */
	public int getFighter() {
		return fighter;
	}

	/**
	 * Sets the fighter skill level
	 * 
	 * @param fighter
	 */
	public void setFighter(int fighter) {
		this.fighter = fighter;
	}

	/**
	 * Gets the trader skill level
	 * 
	 * @return int
	 */
	public int getTrader() {
		return trader;
	}

	/**
	 * Sets the trader skill level
	 * 
	 * @param trader
	 */
	public void setTrader(int trader) {
		this.trader = trader;
	}

	/**
	 * Gets the engineer skill level
	 * 
	 * @return int
	 */
	public int getEngineer() {
		return engineer;
	}

	/**
	 * Sets the engineer skill level
	 * 
	 * @param engineer
	 */
	public void setEngineer(int engineer) {
		this.engineer = engineer;
	}

	/**
	 * Gets the karma of the player
	 * 
	 * @return int
	 */
	public int getKarma() {
		return karma;
	}

	/**
	 * Sets the karma of the player
	 * 
	 * @param karma
	 */
	public void setKarma(int karma) {
		this.karma = karma;
	}

	/**
	 * Gets the credits of the player
	 * 
	 * @return double
	 */
	public double getCredits() {
		return credits;
	}

	/**
	 * Sets the credits of the player
	 * 
	 * @param credits
	 */
	public void setCredits(double credits) {
		this.credits = credits;
	}

	/**
	 * Gets the name of the player
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the player
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets true if the player has a police record
	 * 
	 * @return boolean
	 */
	public boolean isPoliceRecord() {
		return policeRecord;
	}

	/**
	 * Sets the police record of the player
	 * 
	 * @param policeRecord
	 */
	public void setPoliceRecord(boolean policeRecord) {
		this.policeRecord = policeRecord;
	}

	/**
	 * Sets the difficulty level of the player
	 * 
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Gets the difficulty of the player
	 * 
	 * @return int
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Method getFuel.
	 * 
	 * @return fuel
	 */
	public int getFuel() {
		return fuel;
	}

	/**
	 * Method setFuel.
	 * 
	 * @param fuel
	 * 
	 */
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	/**
	 * Method getTurn.
	 * 
	 * @return Turn
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Method setTurn.
	 * 
	 * @param turn
	 * 
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * Returns the player information
	 * 
	 * @return a string of the player's information
	 */
	public String toString() {
		return "PlayerName " + name + "\n" + "Pilot " + pilot + "\n"
				+ "Fighter " + fighter + "\n" + "Trader " + trader + "\n"
				+ "Engineer " + engineer + "\n" + "Credits " + credits + "\n"
				+ "Karma " + karma + "\n" + "Difficulty " + difficulty + "\n"
				+ "Fuel " + fuel + "\n" + "Turn " + turn + "\n"
				+ "PoliceRecord " + policeRecord + "\n";
	}

	/**
	 * Method write.
	 * 
	 * @return String
	 */
	public String write() {
		String out = "";
		out += "PlayerName " + name + "\n";
		out += "Pilot " + pilot + "\n";
		out += "Fighter " + fighter + "\n";
		out += "Trader " + trader + "\n";
		out += "Engineer " + engineer + "\n";
		out += "Credits " + credits + "\n";
		out += "Karma " + karma + "\n";
		out += "Difficulty " + difficulty + "\n";
		out += "Fuel " + fuel + "\n";
		out += "Turn " + turn + "\n";
		out += "PoliceRecord " + policeRecord + "\n";
		return out;
	}
}
