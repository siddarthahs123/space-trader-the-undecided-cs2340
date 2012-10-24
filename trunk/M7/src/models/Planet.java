package models;

import java.util.*;

public class Planet { //somehow extends SolarSystem
	private String resources;
	private String name;
	private Hashtable<String, ArrayList<TradeGood>> goods;
	private SolarSystem galaxy;

	public Planet(String name) {
		this.name = name;
		
		goods = new Hashtable<String, ArrayList<TradeGood>>();
	}

	public String getName() {
		return name;
	}

	public void setResources(int num) {
		switch (num) {
		case 0:
			resources = "No Special Resources";
			break;
		case 1:
			resources = "Mineral Rich";
			break;
		case 2:
			resources = "Mineral Poor";
			break;
		case 3:
			resources = "Desert";
			break;
		case 4:
			resources = "Lots of Water";
			break;
		case 5:
			resources = "Rich Soil";
			break;
		case 6:
			resources = "Rich Soil";
			break;
		case 7:
			resources = "Poor Soil";
			break;
		case 8:
			resources = "Lifeless";
			break;
		case 9:
			resources = "Weird Mushrooms";
			break;
		case 10:
			resources = "Lots of Herbs";
			break;
		case 11:
			resources = "Artistic";
			break;
		case 12:
			resources = "Warlike";
			break;
		}
	}
	
	public void setTradeGoods(Hashtable<String, ArrayList<TradeGood>> goods) {
		this.goods = goods;
	}
	
	public Hashtable<String, ArrayList<TradeGood>> getTradeGoods() {
		return goods;
	}
	
	public String getResources() {
		return resources;
	}
	
	public void setGalaxy(SolarSystem galaxy) {
		this.galaxy = galaxy;
	}
}
