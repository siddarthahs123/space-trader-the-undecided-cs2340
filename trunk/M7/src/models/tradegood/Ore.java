/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 * 
 * This class represents ore
 *
 * @version $Revision: 1.0 $
 */
public class Ore extends TradeGood {

	/**
	 * Price
	 */
	private static final int BASEPRICE = 1250;
	
	/**
	 * Name of trade good
	 */
	private static final String NAME = "Ore";

	/**
	 * Min tech level to produce resource
	 */
	private static final int MTLP = 2;

	/**
	 * Min tech level to use resource
	 */
	private static final int MTLU = 2;

	/**
	 * Tech level that produces the most of this item
	 */
	private static final int TTP = 3;

	/**
	 * Price increase per tech level
	 */
	private static final int IPL = 20;

	/**
	 * Max percent that the price can vary
	 */
	private static final int VAR = 10;

	/**
	 * Radical price increase
	 */
	private static final String IE = "War";

	/**
	 * If true, the resource is cheap
	 */
	private static final String CR = "Mineral Rich";

	/**
	 * If true, the resource is expensive
	 */
	private static final String ER = "Mineral Poor";

	/**
	 * Min price offered in space trade with random trader
	 */
	private static final int MTL = 350;

	/**
	 * Max price offered in space trade with random trader
	 */
	private static final int MTH = 420;
	
	/**
	 * Constructor for the class
	 */
	public Ore() {
		super(BASEPRICE, NAME, MTLP, MTLU, TTP, IPL, VAR, IE, CR, ER, MTL, MTH);
	}
}
