package models;

public class Planet { //somehow extends SolarSystem
	private String resources;
	private String name;

	public Planet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setResources(int num) {
		switch (num) {
		case 0:
			resources = "No Special Resources";
			break;
		case 1:
			resources = "Mineral Rich";
			break;
		case 2:
			resources = "Mineral Poor";
			break;
		case 3:
			resources = "Desert";
			break;
		case 4:
			resources = "Lots of Water";
			break;
		case 5:
			resources = "Rich Soil";
			break;
		case 6:
			resources = "Rich Soil";
			break;
		case 7:
			resources = "Poor Soil";
			break;
		case 8:
			resources = "Lifeless";
			break;
		case 9:
			resources = "Weird Mushrooms";
			break;
		case 10:
			resources = "Lots of Herbs";
			break;
		case 11:
			resources = "Artistic";
			break;
		case 12:
			resources = "Warlike";
			break;
		}
	}

	public String getResources() {
		return resources;
	}
}
