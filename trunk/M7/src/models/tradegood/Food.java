/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 *
 * This class represents food
 * @version $Revision: 1.0 $
 */
public class Food extends TradeGood {

	/**
	 * Price
	 */
	private static final int BASEPRICE = 100;
	
	/**
	 * Name of trade good
	 */
	private static final String NAME = "Food";

	/**
	 * Min tech level to produce resource
	 */
	private static final int MTLP = 1;

	/**
	 * Min tech level to use resource
	 */
	private static final int MTLU = 0;

	/**
	 * Tech level that produces the most of this item
	 */
	private static final int TTP = 1;

	/**
	 * Price increase per tech level
	 */
	private static final int IPL = 5;

	/**
	 * Max percent that the price can vary
	 */
	private static final int VAR = 20;

	/**
	 * Radical price increase
	 */
	private static final String IE = "Crop Fail";

	/**
	 * If true, the resource is cheap
	 */
	private static final String CR = "Rich Soil";

	/**
	 * If true, the resource is expensive
	 */
	private static final String ER = "Poor Soil";

	/**
	 * Min price offered in space trade with random trader
	 */
	private static final int MTL = 90;

	/**
	 * Max price offered in space trade with random trader
	 */
	private static final int MTH = 160;
	
	/**
	 * Constructor for the class
	 */
	public Food() {
		super(BASEPRICE, NAME, MTLP, MTLU, TTP, IPL, VAR, IE, CR, ER, MTL, MTH);
	}
}
