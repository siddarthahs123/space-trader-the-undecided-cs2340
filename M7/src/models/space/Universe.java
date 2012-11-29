/**
 * package that contains this class
 */
package models.space;


/**
 * Class for the solar systems in the Universe
 * 
 * @author Justin Jackson
 * @version 1.0
 */
public class Universe {

	/**
	 * Universe Names
	 */
	private final String[] names = new String[] { "Creynolds7", "Zamarth",
			"Frappacino", "Xerkona", "Glosta", "Bertonia", "Obska",
			"Bud Light", "K102YN", "Clessentra", "Bjornos", "Taiwan",
			"Sector 17", "Granzia", "Baowaters", "Rowlinga", "Tintiti",
			"Atlanta", "Wallaberlo", "Fanta Pineapple" };;

	/**
	 * Planet names
	 */
	private final String[] pNames = new String[] { "Glenkada", "Tyke",
			"Smorpa", "X73Z285", "Storopa", "Silventero", "Acrylizia",
			"Sazerac", "Bulleit", "Grouse", "Glenrothes", "Laphroaig",
			"Buchantona", "Drantofor", "Cardaliana", "Promentheria",
			"Benzoate", "Disodia", "Rocalianda", "Esterora" };;

	/**
	 * Name of current planet
	 */
	@SuppressWarnings("unused")
	private Planet curPlanet;

	/**
	 * Name of current galaxy
	 */
	@SuppressWarnings("unused")
	private SolarSystem curGalaxy;

	/**
	 * Method getNames.
	 * 
	 * @return String[]
	 */
	public String[] getNames() {
		return names;
	}

	/**
	 * Method getPNames.
	 * 
	 * @return String[]
	 */
	public String[] getPNames() {
		return pNames;
	}

	/**
	 * Method setCurPlanet.
	 * 
	 * @param curPlanet
	 *            Planet
	 */
	public void setCurPlanet(Planet curPlanet) {
		this.curPlanet = curPlanet;
	}

	/**
	 * Method setCurGalaxy.
	 * 
	 * @param curGalaxy
	 *            SolarSystem
	 */
	public void setCurGalaxy(SolarSystem curGalaxy) {
		this.curGalaxy = curGalaxy;
	}

	/**
	 * Returns the galaxy names and planet names
	 * 
	 * @return String of galaxy information
	 */
	public String toString() {
//		String ret1 = "[";
//		String ret2 = "[";
//		for (int i = 0; i < names.length; i++) {
//			if (i != names.length - 1) {
//				ret1 = ret1 + names[i] + ", ";
//			} else {
//				ret1 = ret1 + names[i];
//			}
//		}
//
//		for (int i = 0; i < pNames.length; i++) {
//			if (i != pNames.length - 1) {
//				ret2 = ret2 + pNames[i] + ", ";
//			} else {
//				ret2 = ret2 + pNames[i];
//			}
//		}
//
//		return "Galaxies: " + ret1 + "\n" + "Planets: " + ret2;
		return "";
	}
}
