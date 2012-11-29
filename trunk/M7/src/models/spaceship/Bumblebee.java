/**
 * package that contains this class
 */
package models.spaceship;

/**
 * This class represents the Bumblebee spaceship
 * 
 * @author Bao
 * 
 * @version $Revision: 1.0 $
 */
public class Bumblebee extends Spaceship {

	/**
	 * Spaceship name
	 */
	private static final String NAME = "Bumblebee";

	/**
	 * Cargo size
	 */
	private static final int CARGO = 25;

	/**
	 * Limit of weapons
	 */
	private static final int WEAPONSLOTS = 1;

	/**
	 * Limit of shields
	 */
	private static final int SHIELDSLOTS = 2;

	/**
	 * Limit of gadgets
	 */
	private static final int GADGETSLOTS = 2;

	/**
	 * Limit of crew members
	 */
	private static final int CREW = 2;

	/**
	 * Fuel usage
	 */
	private static final int FUEL = 15;

	/**
	 * Min tech level to purchase ship
	 */
	private static final int MINTECH = 5;

	/**
	 * Cost per fuel
	 */
	private static final int FUELCOST = 7;

	/**
	 * Price of ship
	 */
	private static final int PRICE = 60000;

	/**
	 * Bounty cost
	 */
	private static final int BOUNTY = 125;

	/**
	 * Chance of coming across a bumblebee
	 */
	private static final int OCCURANCE = 15;

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
	private static final int SIZE = 2;

	/**
	 * Constructor for the Bumblebee bee spaceship
	 */
	public Bumblebee() {
		super(NAME, CARGO, WEAPONSLOTS, SHIELDSLOTS, GADGETSLOTS, CREW, FUEL,
				MINTECH, FUELCOST, PRICE, BOUNTY, OCCURANCE, STRENGTH,
				REPAIRCOST, SIZE);
		// super("Bumblebee", 25, 1, 2, 2, 2, 15, 5, 7, 60000, 125, 15, 100, 1,
		// 2);
	}
}
