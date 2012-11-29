package systems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import models.space.SolarSystem;

import org.junit.Test;



public class ChrisJUnit {
	
	String str = "Creynolds7";
	SolarSystem solar = new SolarSystem(str, 100, 100);
	int random = (new Random()).nextInt(8);
	
	@Test
	public void test1() {
		solar.setTech(random);
		boolean test = false;
		if(solar.getTechLevelNum() == random)
			test = true;
		assertTrue("Tech Level is the same as the randomly generated number", test);
	}
	
	@Test
	public void test2() {
		solar.setTech(0);
		assertEquals("Pre-Agriculture", solar.techLevel());
	}
	
	@Test
	public void test3() {
		solar.setTech(1);
		assertEquals("Agriculture", solar.techLevel());
	}
	
	@Test
	public void test4() {
		solar.setTech(2);
		assertEquals("Medieval", solar.techLevel());
	}
	
	@Test
	public void test5() {
		solar.setTech(3);
		assertEquals("Renaissance", solar.techLevel());
	}
	
	@Test
	public void test6() {
		solar.setTech(4);
		assertEquals("Early Industrial", solar.techLevel());
	}
	
	@Test
	public void test7() {
		solar.setTech(5);
		assertEquals("Industrial", solar.techLevel());
	}
	
	@Test
	public void test8() {
		solar.setTech(6);
		assertEquals("Post-Industrial", solar.techLevel());
	}
	
	@Test
	public void test9() {
		solar.setTech(7);
		assertEquals("Hi-Tech", solar.techLevel());
	}

}
