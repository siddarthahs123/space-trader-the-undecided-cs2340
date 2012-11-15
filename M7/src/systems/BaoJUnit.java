package systems;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import models.Games;
import models.TradeGood;
import models.Water;

import org.junit.Test;

import systems.MainController.MarketListener;
import views.EncounterView;

public class BaoJUnit {
	
	MainController mc = new MainController();
	MarketListener ml = mc.new MarketListener();
	EncounterView encounter = new EncounterView(ml);
	int choice = (new Random()).nextInt(10);
	
	ArrayList<TradeGood> list = new ArrayList<TradeGood>();
	TradeGood a = encounter.randomTradeGood(2);
	TradeGood b = encounter.randomTradeGood(4);
	TradeGood c = encounter.randomTradeGood(9);
	TradeGood d = encounter.randomTradeGood(7);
	
	@Test
	public void test1() {
		
		TradeGood test = encounter.randomTradeGood(2);
		boolean out = false;
		if (test.getName().equals((new Games()).getName()))
			out = true;
		assertTrue("The trade good is 'Games'", out);
	}
	
	@Test
	public void test2() {
		TradeGood test = encounter.randomTradeGood(2);
		boolean out = false;
		if (test.getName().equals((new Water()).getName()))
			out = true;
		assertFalse("This is the wrong trade good", out);
	}
	
	@Test
	public void test3() {
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		assertEquals(4, list.size());
	}
	
	@Test
	public void test4() {
		TradeGood test = encounter.randomTradeGood(choice);
		boolean out = false;
		if (encounter.getRandGoods()[choice].equals(test.getName()))
			out = true;
		assertTrue("The good matches its key", out);
	}
	
	@Test
	public void test5() {
		boolean out = false;
		if(encounter.randomTradeGood(choice) == null)
			out = true;
		assertFalse("The method does not return a null", out);
	}
}
