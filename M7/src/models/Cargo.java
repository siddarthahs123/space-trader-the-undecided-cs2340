package models;

import java.util.*;

public class Cargo {
	
	private Hashtable<String, ArrayList<TradeGood>> inventory;
	
	public Cargo() {
		inventory = new Hashtable<String, ArrayList<TradeGood>>();
	}
	
	public Hashtable<String, ArrayList<TradeGood>> getTradeGoods() {
		return inventory;
	}
	
	public void setTradeGoods(Hashtable<String, ArrayList<TradeGood>> inventory) {
		this.inventory = inventory;
	}
	
}
