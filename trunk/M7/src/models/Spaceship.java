package models;

/**
 * This class represents the Spaceships and contains data necessary for
 * space travel and trade
 * 
 * @author Bao
 *
 */
public class Spaceship {
	private String name;
	private int cargo;
	private int weaponSlots;
	private int shieldSlots;
	private int gadgetSlots;
	private int crew;
	private int fuel;
	private int minTech;
	private int fuelCost;
	private int price;
	private int bounty;
	private int occurance;
	private int strength;
	private int repairCost;
	private int size;
	private int remSpace;

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
	 * @return the spaceship's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the cargo size of the spaceship
	 * @return the spaceship's cargo size
	 */
	public int getCargo() {
		return cargo;
	}
	
	/**
	 * Returns the maximum slots for weapons on the spaceship
	 * @return the spaceship's weapons slots
	 */
	public int getWeaponSlots() {
		return weaponSlots;
	}

	/**
	 * Returns the maximum slots for shields on the spaceship
	 * @return the spaceship's shield slots
	 */
	public int getShieldSlots() {
		return shieldSlots;
	}

	/**
	 * Returns the maximum slots for gadgets on the spaceship
	 * @return the spaceship's gadget slots
	 */
	public int getGadgetSlots() {
		return gadgetSlots;
	}

	/**
	 * Returns the maximum number of crew members on the spaceship
	 * @return the spaceship's max crew members
	 */
	public int getCrew() {
		return crew;
	}

	/**
	 * Returns the fuel for the spaceship
	 * @return spaceship's fuel
	 */
	public int getFuel() {
		return fuel;
	}

	/**
	 * Returns the minimum tech level required for the selling this spaceship
	 * @return the minimum tech level for the spaceship
	 */
	public int getMinTech() {
		return minTech;
	}

	/**
	 * Returns the fuel cost for the particular spaceship
	 * @return the spaceship's fuel cost
	 */
	public int getFuelCost() {
		return fuelCost;
	}
	
	/**
	 * Returns the price of purchasing the spaceship
	 * @return the spaceship's price
	 */
	public int getPrice () {
		return price;
	}

	/**
	 * Returns the bounty of the spaceship
	 * @return spaceship's bounty
	 */
	public int getBounty() {
		return bounty;
	}

	/**
	 * Returns the occurance of the spaceship
	 * @return the spacehip's occurance
	 */
	public int getOccurance() {
		return occurance;
	}

	/**
	 * Returns the hull strength of the spaceship
	 * @return spaceship's hull strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Returns the cost of the repairing the spaceship
	 * @return spaceship's repair cost
	 */
	public int getRepairCost() {
		return repairCost;
	}

	/**
	 * Returns the size of the spaceship
	 * @return spaceship's size
	 */
	public int getSize() {
		return size;
	}
	
	public int getRemSpace() {
		return remSpace;
	}
	
	public void setRemSpace(int remSpace) {
		this.remSpace = remSpace;
	}

	public String write() {
		String out = "";
		out += "Ship Type : " + name + "\n";
		out += "Cargo Space : " + cargo;
		
		return out;
	}

}
