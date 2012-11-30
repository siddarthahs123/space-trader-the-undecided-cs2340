/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 * 
 * This class represents water
 *
 * @version $Revision: 1.0 $
 */
public class Water extends TradeGood{

	/**
	 * Price
	 */
	private static int BASEPRICE = 25;
	
	/**
	 * Name of trade good
	 */
	private static final String NAME = "Water";

	/**
	 * Min tech level to produce resource
	 */
	private static final int MTLP = 0;

	/**
	 * Min tech level to use resource
	 */
	private static final int MTLU = 0;

	/**
	 * Tech level that produces the most of this item
	 */
	private static final int TTP = 2;

	/**
	 * Price increase per tech level
	 */
	private static final int IPL = 3;

	/**
	 * Max percent that the price can vary
	 */
	private static final int VAR = 4;

	/**
	 * Radical price increase
	 */
	private static final String IE = "Drought";

	/**
	 * If true, the resource is cheap
	 */
	private static final String CR = "Lots of Water";

	/**
	 * If true, the resource is expensive
	 */
	private static final String ER = "Desert";

	/**
	 * Min price offered in space trade with random trader
	 */
	private static final int MTL = 30;

	/**
	 * Max price offered in space trade with random trader
	 */
	private static final int MTH = 50;
	
	/**
	 * Constructor for the class
	 */
	public Water() {
		super(BASEPRICE, NAME, MTLP, MTLU, TTP, IPL, VAR, IE, CR, ER, MTL, MTH);
	}
	
}
