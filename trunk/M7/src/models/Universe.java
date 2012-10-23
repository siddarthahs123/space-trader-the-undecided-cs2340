package models;

public class Universe {
	
	private String[] names;
	private String[] pNames;
	
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
				"1",
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"11",
				"12",
				"13",
				"14",
				"15",
				"16",
				"17",
				"18",
				"19",
				"20"
		};
	}
	
	public String[] getNames() {
		return names;
	}
	
	public String[] getPNames() {
		return pNames;
	}
}
