package models;

/**
 * This class represents the SolarSystem model that stores all the information about
 * the galaxy.
 * @author Justin
 */
public class SolarSystem {
	private Planet[] planets;
	private String techLevel;
	private int techLevelNum;
	private String name;
	private int x, y, distance;
	
	/**
	 * This is the constructor for this class.
	 * @param name The name of the Solar System
	 * @param x The X coordinate of the planet
	 * @param y The Y coordinate of the planet
	 */
	public SolarSystem(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the tech level for the solar system
	 * @param num
	 */
	public void setTech(int num) {
		techLevelNum = num;
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
	
	public void setTechLevel(String techLevel) {
		this.techLevel = techLevel;
	}
	/**
	 * A getter for the string version of the TechLevel
	 * @return The TechLevel as a string
	 */
	public String techLevel() {
		return techLevel;
	}
	
	/**
	 * A getter for the int version of the TechLevel
	 * @return The TechLevel as a number
	 */
	public int getTechLevelNum(){
		return techLevelNum;
	}

	/**
	 * A getter for the name of the Solar System
	 * @return
	 */
	public String name() {
		return name;
	}
	
	/**
	 * A getter for the X coordinate of the Solar System
	 * @return The X coordinate of the solar system
	 */
	public int getX() {
		return x;
	}

	/**
	 * A getter for the Y coordinate of the Solar System
	 * @return The Y coordinate of the solar system
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * A setter for the array of Planets in the solar system
	 * @param planets An array of Planets
	 */
	public void setPlanets(Planet[] planets) {
		this.planets = planets;
	}
	
	/**
	 * A getter for the array of Planets in the Solar System
	 * @return An array of Planets in the Solar System
	 */
	public Planet[] getPlanets() {
		return planets;
	}
	
	public int getDistanceTo() {
		return distance;
	}
	
	public void setDistanceTo(int distance) {
		this.distance = distance;
	}
	
	/**
	 * A getter for the information of the Solar System
	 * @return A string representation of the Solar System and it's planets
	 */
//	public String toString() {
//		String systemInfo = "Galaxy Information\n==================\n";
//		systemInfo += "Name: "+name+", Tech Level: "+techLevel+", Location: "+x+", "+y+"\n";
//		String planetInfo = "";
//		for(Planet planet : planets) {
//			planetInfo += "-->   Name: "+planet.getName()+", Resources: "+planet.getResources()+"\n";
//		}
//		return systemInfo+planetInfo;
//	}
	
	public String write() {
		String out = "";
		out += "GalaxyName " + name + "\n";
		out += "TechLevel " + techLevel + "\n";
		out += "Xcoordinate " + x + "\n";
		out += "Ycoordinate " + y + "\n\n";
		for (Planet planet : planets)
			out += planet.write();
		return out;
	}

	public String getName() {
		return name;
	}
}
