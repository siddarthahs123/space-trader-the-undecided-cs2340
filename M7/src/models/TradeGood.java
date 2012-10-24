package models;

public class TradeGood {
	private int basePrice; // initial price of trade good
	private String name; // name of trade good
	private int MTLP; // min tech level to produce resource
	private int MTLU; // min tech level to use resource
	private int TTP; // tech level that produces the most of this item
	private int IPL; // price increase per tech level
	private int Var; // max percent that the price can vary
	private String IE; // radical price increase
	private String CR; // if true, the resource is cheap
	private String ER; // if true, the resource is expensive
	private int MTL; // min price offered in space trade with random trader
	private int MTH; // max price offered in space trade with random trader

	public TradeGood(int basePrice, String name, int MTLP, int MTLU, int TTP,
			int IPL, int Var, String IE, String CR, String ER, int MTL, int MTH) {
		this.basePrice = basePrice;
		this.name = name;
		this.MTLP = MTLP;
		this.MTLU = MTLU;
		this.TTP = TTP;
		this.IPL = IPL;
		this.Var = Var;
		this.IE = IE;
		this.CR = CR;
		this.ER = ER;
		this.MTL = MTL;
		this.MTH = MTH;
	}

	public int getPrice() {
		return basePrice;
	}

	public String getName() {
		return name;
	}

	public int getMTLP() {
		return MTLP;
	}

	public int getMTLU() {
		return MTLU;
	}

	public int getTTP() {
		return TTP;
	}

	public int getIPL() {
		return IPL;
	}

	public int getVar() {
		return Var;
	}

	public String getIE() {
		return IE;
	}

	public String getCR() {
		return CR;
	}

	public String getER() {
		return ER;
	}

	public int getMTL() {
		return MTL;
	}

	public int getMTH() {
		return MTH;
	}
}