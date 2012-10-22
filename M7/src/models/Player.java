package models;

public class Player {
	private int pilot, fighter, trader, engineer, karma, difficulty;
	private double credits;
	private String name;
	private boolean policeRecord;
	
	public Player(int pilot, int fighter, int trader, int engineer, String name) {
		this(pilot, fighter, trader, engineer, 2, name);
	}
	
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
	
	public void printData() {
		System.out.println("Pilot: "+pilot);
		System.out.println("Fighter: "+fighter);
		System.out.println("Trader: "+trader);
		System.out.println("Engineer: "+engineer);
		System.out.println("Name: "+name);
		System.out.println("Credits: "+credits);
		System.out.println("Difficulty: "+difficulty);
	}
	
	public int getPilot() {
		return pilot;
	}

	public void setPilot(int pilot) {
		this.pilot = pilot;
	}

	public int getFighter() {
		return fighter;
	}

	public void setFighter(int fighter) {
		this.fighter = fighter;
	}

	public int getTrader() {
		return trader;
	}

	public void setTrader(int trader) {
		this.trader = trader;
	}

	public int getEngineer() {
		return engineer;
	}

	public void setEngineer(int engineer) {
		this.engineer = engineer;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPoliceRecord() {
		return policeRecord;
	}

	public void setPoliceRecord(boolean policeRecord) {
		this.policeRecord = policeRecord;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
}
