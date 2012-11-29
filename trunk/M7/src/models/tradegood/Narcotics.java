/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 * 
 * This class represents narcotics
 *
 * @version $Revision: 1.0 $
 */
public class Narcotics extends TradeGood {

	/**
	 * Price
	 */
	private static final int BASEPRICE = 3500;
	
	/**
	 * Name of trade good
	 */
	private static final String NAME = "Narcotics";

	/**
	 * Min tech level to produce resource
	 */
	private static final int MTLP = 5;

	/**
	 * Min tech level to use resource
	 */
	private static final int MTLU = 0;

	/**
	 * Tech level that produces the most of this item
	 */
	private static final int TTP = 5;

	/**
	 * Price increase per tech level
	 */
	private static final int IPL = -125;

	/**
	 * Max percent that the price can vary
	 */
	private static final int VAR = 150;

	/**
	 * Radical price increase
	 */
	private static final String IE = "Boredom";

	/**
	 * If true, the resource is cheap
	 */
	private static final String CR = "Weird Mushrooms";

	/**
	 * If true, the resource is expensive
	 */
	private static final String ER = "Never";

	/**
	 * Min price offered in space trade with random trader
	 */
	private static final int MTL = 2000;

	/**
	 * Max price offered in space trade with random trader
	 */
	private static final int MTH = 3000;
	
	/**
	 * Constructor for the class
	 */
	public Narcotics() {
		super(BASEPRICE, NAME, MTLP, MTLU, TTP, IPL, VAR, IE, CR, ER, MTL, MTH);
	}
}
