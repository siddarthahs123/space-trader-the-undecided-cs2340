/**
 * package that contains this class
 */
package models.spaceship;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import models.tradegood.TradeGood;


/**
 * This class represents the ship's cargo
 * 
 * @author Justin Jackson
 * @version 1.0
 */
public class Cargo {

	/**
	 * Instance variable for spaceship's inventory
	 */
	private Map<String, ArrayList<TradeGood>> inventory;

	/**
	 * Constructor for cargo
	 */
	public Cargo() {
		inventory = new Hashtable<String, ArrayList<TradeGood>>();
	}

	/**
	 * Method getTradeGoods.
	 * 
	 * @return Hashtable<String,ArrayList<TradeGood>>
	 */
	public Map<String, ArrayList<TradeGood>> getTradeGoods() {
		return inventory;
	}

	/**
	 * Method setTradeGoods.
	 * 
	 * @param inventory
	 *            Hashtable<String,ArrayList<TradeGood>>
	 */
	public void setTradeGoods(Map<String, ArrayList<TradeGood>> inventory) {
		this.inventory = inventory;
	}

	/**
	 * Method addTradeGood.
	 * 
	 * @param key
	 *            String
	 * @param obj
	 *            TradeGood
	 */
	public void addTradeGood(String key, TradeGood obj) {
		inventory.get(key).add(obj);
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	public String toString() {
//		String str = "Cargo Inventory\n===============\n";
//		for (Entry<String, ArrayList<TradeGood>> entry : inventory.entrySet()) {
//			str += "Resource: " + entry.getKey() + ", Quantity: "
//					+ entry.getValue().size() + "\n";
//		}
//
//		return str;
		return "";
	}

	/**
	 * Method write.
	 * 
	 * @return String
	 */
	public String write() {
		String out = "";
		for (Entry<String, ArrayList<TradeGood>> entry : inventory.entrySet())
			out += entry.getKey() + " " + entry.getValue().size() + "\n";
		return out;
	}
}
