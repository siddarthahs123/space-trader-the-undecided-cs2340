/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 * 
 * This class represents games
 *
 * @version $Revision: 1.0 $
 */
public class Games extends TradeGood {
	
	/**
	 * Price
	 */
	private static final int BASEPRICE = 250;
	
	/**
	 * Name of trade good
	 */
	private static final String NAME = "Games";

	/**
	 * Min tech level to produce resource
	 */
	private static final int MTLP = 3;

	/**
	 * Min tech level to use resource
	 */
	private static final int MTLU = 1;

	/**
	 * Tech level that produces the most of this item
	 */
	private static final int TTP = 6;

	/**
	 * Price increase per tech level
	 */
	private static final int IPL = -10;

	/**
	 * Max percent that the price can vary
	 */
	private static final int VAR = 5;

	/**
	 * Radical price increase
	 */
	private static final String IE = "Boredom";

	/**
	 * If true, the resource is cheap
	 */
	private static final String CR = "Artistic";

	/**
	 * If true, the resource is expensive
	 */
	private static final String ER = "Never";

	/**
	 * Min price offered in space trade with random trader
	 */
	private static final int MTL = 160;

	/**
	 * Max price offered in space trade with random trader
	 */
	private static final int MTH = 270;
	
	/**
	 * Constructor for the class
	 */
	public Games() {
		super(BASEPRICE, NAME, MTLP, MTLU, TTP, IPL, VAR, IE, CR, ER, MTL, MTH);
	}
}
