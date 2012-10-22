package models;

public class SolarSystem {
	private String techLevel;
	private String name;
	private int x, y;

	public SolarSystem(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public void setTech(int num) {
		switch (num) {
		case 0:
			techLevel = "Pre-Agriculture";
			break;
		case 1:
			techLevel = "Agriculture";
			break;
		case 2:
			techLevel = "Medieval";
			break;
		case 3:
			techLevel = "Renaissance";
			break;
		case 4:
			techLevel = "Early Industrial";
			break;
		case 5:
			techLevel = "Industrial";
			break;
		case 6:
			techLevel = "Post-Industrial";
			break;
		case 7:
			techLevel = "Hi-Tech";
			break;
		}
	}

	public String techLevel() {
		return techLevel;
	}

	public String name() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
