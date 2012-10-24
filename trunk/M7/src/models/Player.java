package models;

/**
 * 
 * @author Samarth
 * 
 * This class is used to create a player
 *
 */
public class Player {
	private int pilot, fighter, trader, engineer, karma, difficulty;
	private double credits;
	private String name;
	private boolean policeRecord;
	
	/**
	 * Constructor that allocates the skills of the player
	 * Constructor is chained to the main constructor
	 * 
	 * @param pilot
	 * @param fighter
	 * @param trader
	 * @param engineer
	 * @param name
	 */
	public Player(int pilot, int fighter, int trader, int engineer, String name) {
		this(pilot, fighter, trader, engineer, 2, name);
	}
	
	/**
	 * Main Constructor allocates the skills of the player and the difficulty level and the name of the player
	 * @param pilot
	 * @param fighter
	 * @param trader
	 * @param engineer
	 * @param difficulty
	 * @param name
	 */
	public Player(int pilot, int fighter, int trader, int engineer, int difficulty, String name) {
		this.pilot = pilot;
		this.fighter = fighter;
		this.trader = trader;
		this.engineer = engineer;
		karma = 0;
		credits = 2000; //default
		this.name = name;
		policeRecord = false;
		this.difficulty = difficulty;
	}
	
	/**
	 * Used to print the data of the player to the console
	 */
	public void printData() {
		System.out.println("Pilot: "+pilot);
		System.out.println("Fighter: "+fighter);
		System.out.println("Trader: "+trader);
		System.out.println("Engineer: "+engineer);
		System.out.println("Name: "+name);
		System.out.println("Credits: "+credits);
		System.out.println("Difficulty: "+difficulty);
	}
	
	/**
	 * Gets the pilot skill level
	 * @return
	 */
	public int getPilot() {
		return pilot;
	}
	
	/**
	 * Sets the pilot skill level
	 * @param pilot
	 */
	public void setPilot(int pilot) {
		this.pilot = pilot;
	}

	/**
	 * Gets the fighter skill level
	 * @return
	 */
	public int getFighter() {
		return fighter;
	}

	/**
	 * Sets the fighter skill level
	 * @param fighter
	 */
	public void setFighter(int fighter) {
		this.fighter = fighter;
	}
	
	/**
	 * Gets the trader skill level
	 * @return
	 */
	public int getTrader() {
		return trader;
	}
	
	/**
	 * Sets the trader skill level
	 * @param trader
	 */
	public void setTrader(int trader) {
		this.trader = trader;
	}

	/**
	 * Gets the engineer skill level
	 * @return
	 */
	public int getEngineer() {
		return engineer;
	}

	/**
	 * Sets the engineer skill level
	 * @param engineer
	 */
	public void setEngineer(int engineer) {
		this.engineer = engineer;
	}
	
	/**
	 * Gets the karma of the player
	 * @return
	 */
	public int getKarma() {
		return karma;
	}

	/**
	 * Sets the karma of the player
	 * @param karma
	 */
	public void setKarma(int karma) {
		this.karma = karma;
	}

	/**
	 * Gets the credits of the player
	 * @return
	 */
	public double getCredits() {
		return credits;
	}

	/**
	 * Sets the credits of the player
	 * @param credits
	 */
	public void setCredits(double credits) {
		this.credits = credits;
	}

	/**
	 * Gets the name of the player
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the player
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets true if the player has a police record
	 * @return
	 */
	public boolean isPoliceRecord() {
		return policeRecord;
	}

	/**
	 * Sets the police record of the player
	 * @param policeRecord
	 */
	public void setPoliceRecord(boolean policeRecord) {
		this.policeRecord = policeRecord;
	}
	
	/**
	 * Sets the difficulty level of the player
	 * @param difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * Gets the difficulty of the player
	 * @return
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
}
