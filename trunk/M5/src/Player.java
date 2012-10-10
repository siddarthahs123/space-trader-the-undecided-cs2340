
public class Player {
	private int pilot, fighter, trader, engineer, karma, difficulty;
	private double credits;
	private String name;
	private boolean policeRecord;
	
	public Player() {
		pilot = 0;
		fighter = 0;
		trader = 0;
		engineer = 0;
		karma = 0;
		credits = 0;
		name = "";
		policeRecord = false;
		difficulty = 0;
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
