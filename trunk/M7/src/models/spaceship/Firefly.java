/**
 * package that contains this class
 */
package models.spaceship;

/**
 * This class represents the Firefly spaceship
 * 
 * @author Bao
 * 
 * @version $Revision: 1.0 $
 */
public class Firefly extends Spaceship {
	
	/**
	 * Spaceship name
	 */
	private static final String NAME = "Firefly";

	/**
	 * Cargo size
	 */
	private static final int CARGO = 20;

	/**
	 * Limit of weapons
	 */
	private static final int WEAPONSLOTS = 1;

	/**
	 * Limit of shields
	 */
	private static final int SHIELDSLOTS = 1;

	/**
	 * Limit of gadgets
	 */
	private static final int GADGETSLOTS = 1;

	/**
	 * Limit of crew members
	 */
	private static final int CREW = 1;

	/**
	 * Fuel usage
	 */
	private static final int FUEL = 17;

	/**
	 * Min tech level to purchase ship
	 */
	private static final int MINTECH = 5;

	/**
	 * Cost per fuel
	 */
	private static final int FUELCOST = 3;

	/**
	 * Price of ship
	 */
	private static final int PRICE = 25000;

	/**
	 * Bounty cost
	 */
	private static final int BOUNTY = 75;

	/**
	 * Chance of coming across a bumblebee
	 */
	private static final int OCCURANCE = 20;

	/**
	 * Hull strength
	 */
	private static final int STRENGTH = 100;

	/**
	 * Cost to repair damages
	 */
	private static final int REPAIRCOST = 1;

	/**
	 * Size
	 */
	private static final int SIZE = 1;

	/**
	 * Constructor
	 */
	public Firefly() {
		super(NAME, CARGO, WEAPONSLOTS, SHIELDSLOTS, GADGETSLOTS, CREW, FUEL,
				MINTECH, FUELCOST, PRICE, BOUNTY, OCCURANCE, STRENGTH,
				REPAIRCOST, SIZE);
	}
}
