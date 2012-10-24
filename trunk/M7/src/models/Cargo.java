package models;

import java.util.*;
import java.util.Map.*;

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
	
	public String toString() {
		String str = "Cargo Inventory\n===============\n";
		for(Entry entry : inventory.entrySet()) {
			str += "Resource: "+entry.getKey()+", Quantity: "+((ArrayList<TradeGood>)entry.getValue()).size()+"\n";
		}
		
		return str;
	}
}