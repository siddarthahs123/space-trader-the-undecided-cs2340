/**
 * package that contains this class
 */
package models.spaceship;

/**
 * This class represents the Flea spaceship
 * @author Bao
 *
 * @version $Revision: 1.0 $
 */
public class Flea extends Spaceship{

	/**
	 * Spaceship name
	 */
	private static final String NAME = "Flea";

	/**
	 * Cargo size
	 */
	private static final int CARGO = 10;

	/**
	 * Limit of weapons
	 */
	private static final int WEAPONSLOTS = 0;

	/**
	 * Limit of shields
	 */
	private static final int SHIELDSLOTS = 0;

	/**
	 * Limit of gadgets
	 */
	private static final int GADGETSLOTS = 0;

	/**
	 * Limit of crew members
	 */
	private static final int CREW = 1;

	/**
	 * Fuel usage
	 */
	private static final int FUEL = 100;

	/**
	 * Min tech level to purchase ship
	 */
	private static final int MINTECH = 4;

	/**
	 * Cost per fuel
	 */
	private static final int FUELCOST = 1;

	/**
	 * Price of ship
	 */
	private static final int PRICE = 2000;

	/**
	 * Bounty cost
	 */
	private static final int BOUNTY = 5;

	/**
	 * Chance of coming across a bumblebee
	 */
	private static final int OCCURANCE = 2;

	/**
	 * Hull strength
	 */
	private static final int STRENGTH = 25;

	/**
	 * Cost to repair damages
	 */
	private static final int REPAIRCOST = 1;

	/**
	 * Size
	 */
	private static final int SIZE = 0;
	
	/**
	 * Constructor
	 */
	public Flea() {
		super(NAME, CARGO, WEAPONSLOTS, SHIELDSLOTS, GADGETSLOTS, CREW, FUEL,
				MINTECH, FUELCOST, PRICE, BOUNTY, OCCURANCE, STRENGTH,
				REPAIRCOST, SIZE);
	}
}
