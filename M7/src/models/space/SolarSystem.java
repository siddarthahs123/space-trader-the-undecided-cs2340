/**
 * package that contains this class
 */
package models.space;



/**
 * This class represents the SolarSystem model that stores all the information
 * about the galaxy.
 * 
 * @author Justin
 * @version $Revision: 1.0 $
 */
public class SolarSystem {

	/**
	 * All the planets that exist in a Solar System
	 */
	private Planet[] planets;

	/**
	 * The tech level of a particular planet
	 */
	private String techLevel;

	/**
	 * The tech level number of a particular planet when used in calculated
	 * price
	 */
	private int techLevelNum;

	/**
	 * Name of solar system
	 */
	private final String name;

	/**
	 * Coordinate information
	 */
	private int x = 0, y = 0, distance = 0;
	
	/**
	 * Constant for position in array
	 */
	private static final int ZERO = 0;
	
	/**
	 * Constant for position in array
	 */
	private static final int ONE = 1;
	
	/**
	 * Constant for position in array
	 */
	private static final int TWO = 2;

	/**
	 * Constant for position in array
	 */
	private static final int THREE = 3;

	/**
	 * Constant for position in array
	 */
	private static final int FOUR = 4;

	/**
	 * Constant for position in array
	 */
	private static final int FIVE = 5;

	/**
	 * Constant for position in array
	 */
	private static final int SIX = 6;

	/**
	 * This is the constructor for this class.
	 * 
	 * @param name
	 *            The name of the Solar System
	 * @param x
	 *            The X coordinate of the planet
	 * @param y
	 *            The Y coordinate of the planet
	 */
	public SolarSystem(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets the tech level for the solar system
	 * 
	 * @param num
	 */
	public void setTech(int num) {
		techLevelNum = num;
		switch (num) {
		case ZERO:
			techLevel = "Pre-Agriculture";
			break;
		case ONE:
			techLevel = "Agriculture";
			break;
		case TWO:
			techLevel = "Medieval";
			break;
		case THREE:
			techLevel = "Renaissance";
			break;
		case FOUR:
			techLevel = "Early Industrial";
			break;
		case FIVE:
			techLevel = "Industrial";
			break;
		case SIX:
			techLevel = "Post-Industrial";
			break;
		default:
			techLevel = "Hi-Tech";
			break;
		}
	}

	/**
	 * Method setTechLevel.
	 * 
	 * @param techLevel
	 *            String
	 */
	public void setTechLevel(String techLevel) {
		this.techLevel = techLevel;
	}

	/**
	 * A getter for the string version of the TechLevel
	 * 
	 * @return The TechLevel as a string
	 */
	public String techLevel() {
		return techLevel;
	}

	/**
	 * A getter for the int version of the TechLevel
	 * 
	 * @return The TechLevel as a number
	 */
	public int getTechLevelNum() {
		return techLevelNum;
	}

	/**
	 * A getter for the name of the Solar System
	 * 
	 * @return String
	 */
	public String name() {
		return name;
	}

	/**
	 * A getter for the X coordinate of the Solar System
	 * 
	 * @return The X coordinate of the solar system
	 */
	public int getX() {
		return x;
	}

	/**
	 * A getter for the Y coordinate of the Solar System
	 * 
	 * @return The Y coordinate of the solar system
	 */
	public int getY() {
		return y;
	}

	/**
	 * A setter for the array of Planets in the solar system
	 * 
	 * @param planets
	 *            An array of Planets
	 */
	public void setPlanets(Planet[] planets) {
		final Planet[] copy = planets;
		this.planets = copy;
	}

	/**
	 * A getter for the array of Planets in the Solar System
	 * 
	 * @return An array of Planets in the Solar System
	 */
	public Planet[] getPlanets() {
		return planets;
	}

	/**
	 * Method getDistanceTo.
	 * 
	 * @return int
	 */
	public int getDistanceTo() {
		return distance;
	}

	/**
	 * Method setDistanceTo.
	 * 
	 * @param distance
	 *            int
	 */
	public void setDistanceTo(int distance) {
		this.distance = distance;
	}

	/**
	 * A getter for the information of the Solar System
	 * 
	 * @return A string representation of the Solar System and it's planets
	 */
	public String toString() {
//		String systemInfo = "Galaxy Information\n==================\n";
//		systemInfo += "Name: " + name + ", Tech Level: " + techLevel
//				+ ", Location: " + x + ", " + y + "\n";
//		String planetInfo = "";
//		for (Planet planet : planets) {
//			planetInfo += "-->   Name: " + planet.getName() + ", Resources: "
//					+ planet.getResources() + "\n";
//		}
//		return systemInfo + planetInfo;
		return "";
	}

	/**
	 * Write method for saving
	 * @return String of solar system information
	 */
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

	/**
	 * Method getName.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
}
