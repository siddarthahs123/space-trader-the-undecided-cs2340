/**
 * package that contains this class
 */
package models.tradegood;

/**
 * 
 * @author Samarth
 * 
 *         This class represents the trade goods
 * 
 * @version $Revision: 1.0 $
 */
public class TradeGood {
	/**
	 * initial price of trade good
	 */
	private int basePrice = 0;

	/**
	 * Name of trade good
	 */
	private String name = "";

	/**
	 * Min tech level to produce resource
	 */
	private int mtlp = 0;

	/**
	 * Min tech level to use resource
	 */
	private int mtlu = 0;

	/**
	 * Tech level that produces the most of this item
	 */
	private int ttp = 0;

	/**
	 * Price increase per tech level
	 */
	private int ipl = 0;

	/**
	 * Max percent that the price can vary
	 */
	private int var = 0;

	/**
	 * Radical price increase
	 */
	private String ie = "";

	/**
	 * If true, the resource is cheap
	 */
	private String cr = "";

	/**
	 * If true, the resource is expensive
	 */
	private String er = "";

	/**
	 * Min price offered in space trade with random trader
	 */
	private int mtl = 0;

	/**
	 * Max price offered in space trade with random trader
	 */
	private int mth = 0;

	/**
	 * Total price
	 */
	private int totalPrice = 0;

	/**
	 * Deflated price
	 */
	private int deflatedPrice = 0;
	
	/**
	 * Constructor
	 * @param basePrice
	 * @param name
	 * @param mtlp
	 * @param mtlu
	 * @param ttp
	 * @param ipl
	 * @param var
	 * @param ie
	 * @param cr
	 * @param er
	 * @param mtl
	 * @param mth
	 */
	public TradeGood(int basePrice, String name, int mtlp, int mtlu, int ttp,
			int ipl, int var, String ie, String cr, String er, int mtl, int mth) {
		this.basePrice = basePrice;
		this.name = name;
		this.mtlp = mtlp;
		this.mtlu = mtlu;
		this.ttp = ttp;
		this.ipl = ipl;
		this.var = var;
		this.ie = ie;
		this.cr = cr;
		this.er = er;
		this.mtl = mtl;
		this.mth = mth;
		totalPrice = basePrice; // starting out
		deflatedPrice = totalPrice; // starting out
	}

	/**
	 * Method getPrice.
	 * 
	 * @return int
	 */
	public int getPrice() {
		return basePrice;
	}

	/**
	 * Method getName.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method getMTLP.
	 * 
	 * @return Min tech level to produce
	 */
	public int getMTLP() {
		return mtlp;
	}

	/**
	 * Method getMTLU.
	 * 
	 * @return Min tech level to sell
	 */
	public int getMTLU() {
		return mtlu;
	}

	/**
	 * Method getTTP.
	 * 
	 * @return Tech level the produces most of this item
	 */
	public int getTTP() {
		return ttp;
	}

	/**
	 * Method getIPL.
	 * 
	 * @return Price increase per tech level
	 */
	public int getIPL() {
		return ipl;
	}

	/**
	 * Method getVar.
	 * 
	 * @return int
	 */
	public int getVar() {
		return var;
	}

	/**
	 * Method getIE.
	 * 
	 * @return Radical price increase
	 */
	public String getIE() {
		return ie;
	}

	/**
	 * Method getCR.
	 * 
	 * @return The good is cheap
	 */
	public String getCR() {
		return cr;
	}

	/**
	 * Method getER.
	 * 
	 * @return The good is expensive
	 */
	public String getER() {
		return er;
	}

	/**
	 * Method getMTL.
	 * 
	 * @return The min tech level
	 */
	public int getMTL() {
		return mtl;
	}

	/**
	 * Method getMTH.
	 * 
	 * @return The max price offered
	 */
	public int getMTH() {
		return mth;
	}

	/**
	 * Method getTotalPrice.
	 * 
	 * @return The total price
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Method getDeflatedPrice.
	 * 
	 * @return The Deflated Price
	 */
	public int getDeflatedPrice() {
		return deflatedPrice;
	}

	/**
	 * Method setTotalPrice.
	 * 
	 * @param totalPrice
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
		this.deflatedPrice = (totalPrice - (totalPrice >> 1));
	}

	/**
	 * @return Trade good name
	 */
	public String toString() {
		return "This is " + getName();
	}

	/**
	 * Method write.
	 * 
	 * @return String
	 */
	public String write() {
		String out = "";
		// out += "Good Name : " + name + "\n";
		out += "TotalPrice " + totalPrice;
		// out += "Deflated Price : " + deflatedPrice + "\n";
		return out;
	}
}
