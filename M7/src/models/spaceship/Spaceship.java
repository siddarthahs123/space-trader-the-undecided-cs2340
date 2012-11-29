/**
 * package that contains this class
 */
package models.spaceship;

/**
 * This class represents the Spaceships and contains data necessary for
 * space travel and trade
 * 
 * @author Bao
 *
 * @version $Revision: 1.0 $
 */
public class Spaceship {
	
	/**
	 * Spaceship name
	 */
	private String name = "";
	
	/**
	 * Cargo size
	 */
	private int cargo = 0;
	
	/**
	 * Limit of weapons
	 */
	private int weaponSlots = 0;
	
	/**
	 * Limit of shields
	 */
	private int shieldSlots = 0;
	
	/**
	 * Limit of gadgets
	 */
	private int gadgetSlots = 0;
	
	/**
	 * Limit of crew members
	 */
	private int crew = 0;
	
	/**
	 * Fuel usage 
	 */
	private int fuel = 0;
	
	/**
	 * Min tech level to purchase ship
	 */
	private int minTech = 0;
	
	/**
	 * Cost per fuel
	 */
	private int fuelCost = 0;
	
	/**
	 * Price of ship
	 */
	private int price = 0;
	
	/**
	 * Bounty cost
	 */
	private int bounty = 0;
	
	/**
	 * Chance of coming across a bumblebee
	 */
	private int occurance = 0;
	
	/**
	 * Hull strength
	 */
	private int strength = 0;
	
	/**
	 * Cost to repair damages
	 */
	private int repairCost = 0;
	
	/**
	 * Size
	 */
	private int size = 0;
	
	/**
	 * Remaining space
	 */
	private int remSpace;

	/**
	 * Constructor for Spaceship.
	 * @param name String
	 * @param cargo int
	 * @param weaponSlots int
	 * @param shieldSlots int
	 * @param gadgetSlots int
	 * @param crew int
	 * @param fuel int
	 * @param minTech int
	 * @param fuelCost int
	 * @param price int
	 * @param bounty int
	 * @param occurance int
	 * @param strength int
	 * @param repairCost int
	 * @param size int
	 */
	public Spaceship(String name, int cargo, int weaponSlots, int shieldSlots,
			int gadgetSlots, int crew, int fuel, int minTech, int fuelCost,
			int price, int bounty, int occurance, int strength, int repairCost,
			int size) {
		this.name = name;
		this.cargo = cargo;
		this.weaponSlots = weaponSlots;
		this.shieldSlots = shieldSlots;
		this.gadgetSlots = gadgetSlots;
		this.crew = crew;
		this.fuel = fuel;
		this.minTech = minTech;
		this.fuelCost = fuelCost;
		this.price = price;
		this.bounty = bounty;
		this.occurance = occurance;
		this.strength = strength;
		this.repairCost = repairCost;
		this.size = size;
		
		remSpace = cargo;
	}
	
	/**
	 * Returns the name of the spaceship
	
	 * @return the spaceship's name */
	public String getName() {
		return name;
	}

	/**
	 * Returns the cargo size of the spaceship
	
	 * @return the spaceship's cargo size */
	public int getCargo() {
		return cargo;
	}
	
	/**
	 * Returns the maximum slots for weapons on the spaceship
	
	 * @return the spaceship's weapons slots */
	public int getWeaponSlots() {
		return weaponSlots;
	}

	/**
	 * Returns the maximum slots for shields on the spaceship
	
	 * @return the spaceship's shield slots */
	public int getShieldSlots() {
		return shieldSlots;
	}

	/**
	 * Returns the maximum slots for gadgets on the spaceship
	
	 * @return the spaceship's gadget slots */
	public int getGadgetSlots() {
		return gadgetSlots;
	}

	/**
	 * Returns the maximum number of crew members on the spaceship
	
	 * @return the spaceship's max crew members */
	public int getCrew() {
		return crew;
	}

	/**
	 * Returns the fuel for the spaceship
	
	 * @return spaceship's fuel */
	public int getFuel() {
		return fuel;
	}

	/**
	 * Returns the minimum tech level required for the selling this spaceship
	
	 * @return the minimum tech level for the spaceship */
	public int getMinTech() {
		return minTech;
	}

	/**
	 * Returns the fuel cost for the particular spaceship
	
	 * @return the spaceship's fuel cost */
	public int getFuelCost() {
		return fuelCost;
	}
	
	/**
	 * Returns the price of purchasing the spaceship
	
	 * @return the spaceship's price */
	public int getPrice () {
		return price;
	}

	/**
	 * Returns the bounty of the spaceship
	
	 * @return spaceship's bounty */
	public int getBounty() {
		return bounty;
	}

	/**
	 * Returns the occurance of the spaceship
	
	 * @return the spacehip's occurance */
	public int getOccurance() {
		return occurance;
	}

	/**
	 * Returns the hull strength of the spaceship
	
	 * @return spaceship's hull strength */
	public int getStrength() {
		return strength;
	}

	/**
	 * Returns the cost of the repairing the spaceship
	
	 * @return spaceship's repair cost */
	public int getRepairCost() {
		return repairCost;
	}

	/**
	 * Returns the size of the spaceship
	
	 * @return spaceship's size */
	public int getSize() {
		return size;
	}
	
	/**
	 * Method getRemSpace.
	 * @return int
	 */
	public int getRemSpace() {
		return remSpace;
	}
	
	/**
	 * Method setRemSpace.
	 * @param remSpace int
	 */
	public void setRemSpace(int remSpace) {
		this.remSpace = remSpace;
	}
	
	/**
	 * The toString method
	 * @return the name of the spaceship
	 */
	public String toString() {
		return "This is the " + getName();
	}
	
	/**
	 * Method write.
	 * @return String
	 */
	public String write() {
		String out = "";
		out += "ShipType " + name;
		//out += "Cargo Space : " + cargo;
		
		return out;
	}

}
