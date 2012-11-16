package systems;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

import models.*;

public class JustinJUnit {
	MainController main = new MainController();
	SolarSystem[] galaxies = main.getGalaxies();
	
	@Test
	public void test1() {
		SolarSystem galaxy = galaxies[0];
		Planet planet = galaxies[0].getPlanets()[0];
		galaxy.setTech(0);
		main.refreshTradeGoods();
		int list = planet.getTradeGoods().get("Food").size();
		assertTrue("Pre-agricultural planet has no food", list == 0);
	}
	
	@Test
	public void test2() {
		SolarSystem galaxy = galaxies[0];
		Planet planet = galaxies[0].getPlanets()[0];
		galaxy.setTech(5);
		main.refreshTradeGoods();
		int list = planet.getTradeGoods().get("Robots").size();
		assertTrue("Industrial planet has no robots", list == 0);
	}
	
	@Test
	public void test3() {
		SolarSystem galaxy = galaxies[0];
		Planet planet = galaxies[0].getPlanets()[0];
		galaxy.setTech(7);
		Hashtable<String, ArrayList<TradeGood>> tempGoods = new Hashtable<String, ArrayList<TradeGood>>();
		ArrayList<TradeGood> goods = planet.getTradeGoods().get("Water");
		goods.add(new Water()); //in case no water in first place
		tempGoods.put("Water", goods);
		planet.setTradeGoods(tempGoods);
		main.refreshTradeGoods();
		goods = planet.getTradeGoods().get("Water");
		TradeGood good = goods.get(0); //get first item
		int price = good.getTotalPrice();
		int deflated = good.getDeflatedPrice();
		assertTrue("Buying price is greater than selling price", price > deflated);
	}
	
	@Test
	public void test4() {
		SolarSystem galaxy = galaxies[0];
		Planet planet = galaxies[0].getPlanets()[0];
		galaxy.setTech(2);
		main.refreshTradeGoods();
		int list = planet.getTradeGoods().get("Games").size();
		assertTrue("Medieval planet has no games", list == 0);
	}
	
	@Test
	public void test5() {
		SolarSystem galaxy = galaxies[0];
		Planet planet = galaxies[0].getPlanets()[0];
		galaxy.setTech(3);
		main.refreshTradeGoods();
		int list = planet.getTradeGoods().get("Medicine").size();
		assertTrue("Renaissance planet has no medicine", list == 0);
	}
}
