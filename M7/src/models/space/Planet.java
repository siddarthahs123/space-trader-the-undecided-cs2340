/**
 * package that contains this class
 */
package models.space;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import models.tradegood.TradeGood;


/**
 * 
 * @author Samarth
 * 
 *         This class represents a planet
 * 
 * @version $Revision: 1.0 $
 */
public class Planet { // somehow extends SolarSystem
	/**
	 * The resources for each planet
	 */
	private String resources;

	/**
	 * Name of the planet
	 */
	private final String name;

	/**
	 * Trade Goods for each planet
	 */
	private Map<String, ArrayList<TradeGood>> goods;

	/**
	 * Price for selling back items
	 */
	private Hashtable<String, Integer> deflatedPrices;

	/**
	 * Galaxy the planet exists in
	 */
	@SuppressWarnings("unused")
	private SolarSystem galaxy;

	/**
	 * Constant for position in array
	 */
	private static final int ZERO = 0;

	/**
	 * Constant for position in array
	 */
	private static final int ONE = 1;

	/**
	 * Constant for position in array
	 */
	private static final int TWO = 2;

	/**
	 * Constant for position in array
	 */
	private static final int THREE = 3;

	/**
	 * Constant for position in array
	 */
	private static final int FOUR = 4;

	/**
	 * Constant for position in array
	 */
	private static final int FIVE = 5;

	/**
	 * Constant for position in array
	 */
	private static final int SIX = 6;

	/**
	 * Constant for position in array
	 */
	private static final int SEVEN = 7;

	/**
	 * Constant for position in array
	 */
	private static final int EIGHT = 8;

	/**
	 * Constant for position in array
	 */
	private static final int NINE = 9;

	/**
	 * Constant for position in array
	 */
	private static final int TEN = 10;

	/**
	 * Constant for position in array
	 */
	private static final int ELEVEN = 11;

	/**
	 * Constructor for the planet class
	 * 
	 * @param name
	 */
	public Planet(String name) {
		this.name = name;

		goods = new Hashtable<String, ArrayList<TradeGood>>();
	}

	/**
	 * Method getDeflatedPrices.
	 * 
	 * @return Hashtable<String,Integer>
	 */
	public Map<String, Integer> getDeflatedPrices() {
		deflatedPrices = new Hashtable<String, Integer>();
		final String[] resources = goods.keySet().toArray(
				new String[goods.size()]);
		for (int i = 0; i < goods.size(); i++) {
			if (!goods.get(resources[i]).isEmpty()) {
				deflatedPrices.put(resources[i], goods.get(resources[i]).get(0)
						.getDeflatedPrice());
			} else {
				deflatedPrices.put(resources[i], 0);
			}
		}

		return deflatedPrices;
	}

	/**
	 * Gets the name of the planet
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method setResources.
	 * 
	 * @param resources
	 *            String
	 */
	public void setResources(String resources) {
		this.resources = resources;
	}

	/**
	 * Sets the resources for the planet
	 * 
	 * @param num
	 */
	public void setRandomResources(int num) {
		switch (num) {
		case ZERO:
			resources = "No Special Resources";
			break;
		case ONE:
			resources = "Mineral Rich";
			break;
		case TWO:
			resources = "Mineral Poor";
			break;
		case THREE:
			resources = "Desert";
			break;
		case FOUR:
			resources = "Lots of Water";
			break;
		case FIVE:
			resources = "Rich Soil";
			break;
		case SIX:
			resources = "Rich Soil";
			break;
		case SEVEN:
			resources = "Poor Soil";
			break;
		case EIGHT:
			resources = "Lifeless";
			break;
		case NINE:
			resources = "Weird Mushrooms";
			break;
		case TEN:
			resources = "Lots of Herbs";
			break;
		case ELEVEN:
			resources = "Artistic";
			break;
		default:
			resources = "Warlike";
			break;
		}
	}

	/**
	 * Sets the trade goods of the planet
	 * 
	 * @param goods
	 */
	public void setTradeGoods(Map<String, ArrayList<TradeGood>> goods) {
		this.goods = goods;
	}

	/**
	 * Gets the trade goods of the planets
	 * 
	 * @return Hashtable<String,ArrayList<TradeGood>>
	 */
	public Map<String, ArrayList<TradeGood>> getTradeGoods() {
		return goods;
	}

	/**
	 * Gets the resources of the planet
	 * 
	 * @return String
	 */
	public String getResources() {
		return resources;
	}

	/**
	 * Gets the galaxy that the planet belongs to
	 * 
	 * @param galaxy
	 */
	public void setGalaxy(SolarSystem galaxy) {
		this.galaxy = galaxy;
	}

	/**
	 * Method write.
	 * 
	 * @return String
	 */
	public String write() {
		String out = "";
		out += "PlanetName " + name + "\n";
		out += "Resources " + resources + "\n\n";
		out += "TradeGoods " + "\n";
		for (Entry<String, ArrayList<TradeGood>> entry : goods.entrySet()) {
			// for (TradeGood good : entry.getValue()) {
			out += entry.getKey() + " " + entry.getValue().size() + " ";
			for (TradeGood good : entry.getValue()) {
				out += good.write();
				break;
			}
			out += "\n";
			// }
		}
		return out;
	}

	/**
	 * The toString method returns the planet's name and it's resource
	 * 
	 * @return String of Planet
	 */
	public String toString() {
		return getName() + ": " + getResources();
	}
}
