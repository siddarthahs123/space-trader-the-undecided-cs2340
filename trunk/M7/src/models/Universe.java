package models;

import models.*;

public class Universe {
	
	private String[] names;
	private String[] pNames;
	private Planet curPlanet;
	private SolarSystem curGalaxy;
	
	public Universe() {
		names = new String[] {
				"Creynolds7",
				"Zamarth",
				"Frappacino",
				"Xerkona",
				"Glosta",
				"Bertonia",
				"Obska",
				"Bud Light",
				"K102YN",
				"Clessentra",
				"Bjornos",
				"Taiwan",
				"Sector 17",
				"Granzia",
				"Baowaters",
				"Rowlinga",
				"Tintiti",
				"Atlanta",
				"Wallaberlo",
				"Fanta Pineapple"
		};
		
		pNames = new String[] {
				"Glenkada",
				"Tyke",
				"Smorpa",
				"X73Z285",
				"Storopa",
				"Silventero",
				"Acrylizia",
				"Sazerac",
				"Bulleit",
				"Grouse",
				"Glenrothes",
				"Laphroaig",
				"Buchantona",
				"Drantofor",
				"Cardaliana",
				"Promentheria",
				"Benzoate",
				"Disodia",
				"Rocalianda",
				"Esterora"
		};
	}
	
	public String[] getNames() {
		return names;
	}
	
	public String[] getPNames() {
		return pNames;
	}
	
	public void setCurPlanet(Planet curPlanet) {
		this.curPlanet = curPlanet;
	}
	
	public void setCurGalaxy(SolarSystem curGalaxy) {
		this.curGalaxy = curGalaxy;
	}
}
