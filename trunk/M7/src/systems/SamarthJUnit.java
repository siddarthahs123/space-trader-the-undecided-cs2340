package systems;

import static org.junit.Assert.*;

import models.Planet;
import models.SolarSystem;

import org.junit.Test;

public class SamarthJUnit {
	MainController mc = new MainController();
	SolarSystem[] galaxies = mc.getGalaxies();
	@Test
	public void test() {
		
		boolean out = false;
		if(galaxies.length == 20) {
			out = true;
		}
		assertTrue("Correct number of galaxies generated", out);
	}
	
	public void test1() {
		
		SolarSystem gal = new SolarSystem("Creynolds7", 10, 10);
		boolean out = false;
		for (SolarSystem galaxy : galaxies) {
			if (galaxy.getName().equals(gal.getName())) {
				out = true;
			}
		}
		assertTrue("Creynolds7 is generated", out);
	}
	
	public void test2() {
		SolarSystem gal = new SolarSystem("Fanta Pineapple", 10, 10);
		boolean out = false;
		for (SolarSystem galaxy : galaxies) {
			if (galaxy.getName().equals(gal.getName())) {
				out = true;
			}
		}
		assertTrue("Fanta Pineapple is generated", out);
	}
	
	public void test3() {
		boolean out = false;
		if (galaxies[0].getPlanets()[0] instanceof Planet)
			out = true;
		assertTrue("Universe contains Planets", out);
	}
	
	public void test4() {
		boolean out = false;
		if (galaxies[0].getPlanets().length == 1)
			out = true;
		assertTrue("One planet generated per galaxy", out);
	}
	
	public void test5() {
		boolean out = false;
		if (galaxies[0] instanceof SolarSystem) {
			out = true;
		}
		assertTrue("Galaxy is correctly generated for first position", out);
	}
	
	public void test6() {
		boolean out = false;
		if (galaxies[19] instanceof SolarSystem) {
			out = true;
		}
		assertTrue("Galaxy is correctly generated for last position", out);
	}
	
	public void test7() {
		boolean out = false;
		if (galaxies != null)
			out = true;
		assertTrue("Galaxy is generated", out);
	}
	
	public void test8() {
		boolean out = true;
		for (SolarSystem gal : galaxies) {
			if (gal.getX() < 0)
				out = false;
			if (gal.getX() > mc.frameWidth())
				out = false;
			if (gal.getY() < 0)
				out = false;
			if (gal.getY() > mc.frameWidth())
				out = false;
		}
		assertTrue("Galaxy is generated in the dimensions of the window", out);
	}
	
	public void test9() {
		boolean out = true;
		for (SolarSystem gal : galaxies) {
			if (gal.techLevel() == null) {
				out = false;
			}
		}
		assertTrue("Tech Level set for all planets", out);
	}
}








