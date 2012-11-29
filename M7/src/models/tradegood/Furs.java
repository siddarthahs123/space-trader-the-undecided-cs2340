/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 * 
 * This class represents furs
 *
 * @version $Revision: 1.0 $
 */
public class Furs extends TradeGood{
	
	/**
	 * Price
	 */
	private static final int BASEPRICE = 250;
	
	/**
	 * Name of trade good
	 */
	private static final String NAME = "Furs";

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
	private static final int TTP = 0;

	/**
	 * Price increase per tech level
	 */
	private static final int IPL = 10;

	/**
	 * Max percent that the price can vary
	 */
	private static final int VAR = 10;

	/**
	 * Radical price increase
	 */
	private static final String IE = "Cold";

	/**
	 * If true, the resource is cheap
	 */
	private static final String CR = "Rich Fauna";

	/**
	 * If true, the resource is expensive
	 */
	private static final String ER = "Lifeless";

	/**
	 * Min price offered in space trade with random trader
	 */
	private static final int MTL = 230;

	/**
	 * Max price offered in space trade with random trader
	 */
	private static final int MTH = 280;
	
	/**
	 * Constructor for the class
	 */
	public Furs() {
		super(BASEPRICE, NAME, MTLP, MTLU, TTP, IPL, VAR, IE, CR, ER, MTL, MTH);
	}
}
