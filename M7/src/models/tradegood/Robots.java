/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 * 
 * This class represents robots
 *
 * @version $Revision: 1.0 $
 */
public class Robots extends TradeGood {

	/**
	 * Price
	 */
	private static final int BASEPRICE = 5000;
	
	/**
	 * Name of trade good
	 */
	private static final String NAME = "Robots";

	/**
	 * Min tech level to produce resource
	 */
	private static final int MTLP = 6;

	/**
	 * Min tech level to use resource
	 */
	private static final int MTLU = 4;

	/**
	 * Tech level that produces the most of this item
	 */
	private static final int TTP = 7;

	/**
	 * Price increase per tech level
	 */
	private static final int IPL = -150;

	/**
	 * Max percent that the price can vary
	 */
	private static final int VAR = 100;

	/**
	 * Radical price increase
	 */
	private static final String IE = "Lack of Workers";

	/**
	 * If true, the resource is cheap
	 */
	private static final String CR = "Never";

	/**
	 * If true, the resource is expensive
	 */
	private static final String ER = "Never";

	/**
	 * Min price offered in space trade with random trader
	 */
	private static final int MTL = 3500;

	/**
	 * Max price offered in space trade with random trader
	 */
	private static final int MTH = 5000;
	
	/**
	 * Constructor for the class
	 */
	public Robots() {
		super(BASEPRICE, NAME, MTLP, MTLU, TTP, IPL, VAR, IE, CR, ER, MTL, MTH);
	}

}
