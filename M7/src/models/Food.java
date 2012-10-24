package models;

/**
 * 
 * @author Samarth
 *
 * This class represents food
 */
public class Food extends TradeGood {

	/**
	 * Constructor for the class
	 */
	public Food() {
		super(100, "Food", 1, 0, 1, 5, 20, "Crop Fail", "Rich Soil",
				"Poor Soil", 90, 160);
	}
}
