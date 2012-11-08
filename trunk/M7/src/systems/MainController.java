package systems;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import models.Cargo;
import models.Firearms;
import models.Flea;
import models.Food;
import models.Furs;
import models.Games;
import models.Machines;
import models.Medicine;
import models.Narcotics;
import models.Ore;
import models.Planet;
import models.Player;
import models.Robots;
import models.SolarSystem;
import models.Spaceship;
import models.TradeGood;
import models.Universe;
import models.Water;
import views.IntroView;
import views.MarketView;
import views.StartView;
import views.UniverseView;

/**
 * Main Controller class for the game. Does all of the labor required.
 * @author Justin
 */
public class MainController {
	private JButton curButton, prevButton;
	private JFrame frame;
	private Dimension dim;
	private JPanel cards;
	private int frameWidth, frameHeight;
	private final String INTRO = "Intro Screen";
	private final String START = "Start Screen";
	private final String UNIVERSE = "Universe Screen";
	private final String MARKET = "Market Screen";
	
	private Hashtable<JButton, SolarSystem> hash;
	private Hashtable<String, Integer> deflatedPrices;
	private SolarSystem curGalaxy;
	private Planet curPlanet;
	private Universe universe;
	private Planet[] planetList;
	private SolarSystem[] galaxies;
	
	private IntroView introView;
	private StartView startView;
	private MarketView marketView;
	private UniverseView universeView;
	private Cargo cargo;
	private Spaceship playerShip;
	private Player player;
	
	/**
	 * Constructor for Main Controller
	 */
	public MainController() {
		dim = new Dimension(679, 473);
		frameWidth = (int)dim.getWidth();
		frameHeight = (int)dim.getHeight();
		frame = new JFrame("Space Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(dim);
		frame.setResizable(false);
		
		addViews(frame.getContentPane());
		
		
		
		frame.setVisible(true);
		frame.pack();
	}
	
	/**
	 * Sets up all of the views and adds panels as cards.
	 * 
	 * @return If cards were successfully added
	 */
	public void addViews(Container pane) {
		//Generate intro view
		introView = new IntroView();
		JPanel introCard = introView.getPanel();
		introView.getBtnNewGame().addActionListener(new NewGameListener());
		introView.getBtnLoadGame().addActionListener(new LoadGameListener());
		
		//Generate start view
		startView = new StartView();
		JPanel startCard = startView.getPanel();
		startView.getBtnDone().addActionListener(new PlayerDoneListener());
		
		//Generate galaxy map
		universe = new Universe();
		generateGalaxies();
		//FOR DEBUGGIN ONLY
		/*for(int i = 0; i < galaxies.length; i++) {
			System.out.println(galaxies[i].toString());
		}*/
		///////////////////
		universeView = new UniverseView();
		hash = universeView.drawGalaxies(galaxies, new PlanetListener());
		JPanel universeCard = universeView.getPanel();
		
		//Generate market view
		cargo = new Cargo();
		playerShip = new Flea();
		refreshCargoGoods();
		
		marketView = new MarketView(new BuyListener(), new SellListener(), new MapListener(), new SaveGameListener());
		JPanel marketCard = marketView.getPanel();
		
		//Add cards to card layout
		cards = new JPanel(new CardLayout());
		cards.add(introCard, INTRO);
		cards.add(startCard, START);
		cards.add(universeCard, UNIVERSE);
		cards.add(marketCard, MARKET);

        pane.add(cards, BorderLayout.CENTER);
	}

	public void nextState(String next) {
		CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, next);
	}
	
	/**
	 * Listener class for new game selection.
	 * @author Justin
	 */
	public class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nextState(START);
		}
	}
	
	/**
	 * Listener class for load game selection.
	 * @author Samarth Agarwal
	 */
	public class LoadGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == introView.getBtnLoadGame()) {
				try {
					load();
				} 
				catch (FileNotFoundException e1) {
					System.out.println("No such file found. Try again.");
				}
			}
		}
	}
	
	/**
	 * Helper method to load game
	 * @author Samarth Agarwal
	 * @throws FileNotFoundException
	 */
	public void load() throws FileNotFoundException {
		JFileChooser choose = new JFileChooser();
		choose.showOpenDialog(introView.getPanel());
		File f = choose.getSelectedFile();
		Scanner scan;
		try{
			scan = new Scanner(f);
		}
		catch(NullPointerException e){
			return;
		}
		
		boolean loadingDone = false;
		while (!loadingDone) {
			String ret;
			
			boolean playerSettingDone = false;
			boolean playerShipSettingDone = false;
			boolean playerCargoSettingDone = false;
			boolean currentPositionSettingDone = false;
			boolean universeSettingDone = false;
			
			//Player Details
			String playerName = "";
			int pilot = 0;
			int fighter = 0;
			int trader = 0;
			int engineer = 0;
			double credits = 0.0;
			int karma = 0;
			int difficulty = -1;
			int fuel = 0;
			int turn = 0;
			boolean policeRecord;
			//Player Details
			
			//Player ship
			String shipType = "";
			//Player ship
			
			//Player Cargo
			Hashtable<String, ArrayList<TradeGood>> inventory = new Hashtable<String, ArrayList<TradeGood>>();
			//Player Cargo
			
			//Player's current position
			String currentGalaxy = "";
			String currentPlanet = "";
			//Player's current position
			
			//Universe Generation
			galaxies = new SolarSystem[universe.getNames().length];
			String galaxyName = "";
			String techLevel = "";
			int x = 0, y=0;
			int galaxyCounter = 0;
			
			String planetName = "";
			String resources = "";
			Hashtable<String, ArrayList<TradeGood>> planetGoods = new Hashtable<String, ArrayList<TradeGood>>();
			//Universe Generation
			while (!playerSettingDone) {
				ret = scan.next();
				
				if (ret.equals("PlayerName"))
					playerName = scan.nextLine().trim();
				else if (ret.equals("Pilot"))
					pilot = scan.nextInt();
				else if (ret.equals("Fighter"))
					fighter = scan.nextInt();
				else if (ret.equals("Trader"))
					trader = scan.nextInt();
				else if (ret.equals("Engineer"))
					engineer = scan.nextInt();
				else if (ret.equals("Credits"))
					credits = scan.nextDouble();
				else if (ret.equals("Karma"))
					karma = scan.nextInt();
				else if (ret.equals("Difficulty"))
					difficulty = scan.nextInt();
				else if (ret.equals("Fuel"))
					fuel = scan.nextInt();
				else if (ret.equals("Turn"))
					turn = scan.nextInt();
				else if (ret.equals("PoliceRecord")) {
					policeRecord = scan.nextBoolean();
					//System.out.println(policeRecord);
					player = new Player(pilot, fighter, trader, engineer, difficulty, playerName);
					player.setCredits(credits);
					player.setKarma(karma);
					player.setFuel(fuel);
					player.setTurn(turn);
					player.setPoliceRecord(policeRecord);
					//System.out.println(player.write());
					playerSettingDone = true;
				}
			}
			
			while (!playerShipSettingDone) {
				ret = scan.next();
				if (ret.equals("ShipType")) {
					shipType = scan.next();
					if (shipType.equals("Flea")) {
						playerShip = new Flea();
						playerShipSettingDone = true;
						//System.out.println(playerShip.write());
					}
				}
			}
			
			while (!playerCargoSettingDone) {
				if (scan.next().equals("Firearms")) {
					int firearms = scan.nextInt();
					inventory.put("Firearms", new ArrayList<TradeGood>());
					for (int i = 0; i < firearms; i++)
						inventory.get("Firearms").add(new Firearms());
				}
				if (scan.next().equals("Games")) {
					int games = scan.nextInt();
					inventory.put("Games", new ArrayList<TradeGood>());
					for (int i = 0; i < games; i++)
						inventory.get("Games").add(new Games());
				}
				if (scan.next().equals("Ore")) {
					int ore = scan.nextInt();
					inventory.put("Ore", new ArrayList<TradeGood>());
					for (int i = 0; i < ore; i++)
						inventory.get("Ore").add(new Ore());
				}
				if (scan.next().equals("Water")) {
					int water = scan.nextInt();
					inventory.put("Water", new ArrayList<TradeGood>());
					for (int i = 0; i < water; i++)
						inventory.get("Water").add(new Water());
				}
				if (scan.next().equals("Machines")) {
					int machines = scan.nextInt();
					inventory.put("Machines", new ArrayList<TradeGood>());
					for (int i = 0; i < machines; i++)
						inventory.get("Machines").add(new Machines());
				}
				if (scan.next().equals("Furs")) {
					int furs = scan.nextInt();
					inventory.put("Furs", new ArrayList<TradeGood>());
					for (int i = 0; i < furs; i++)
						inventory.get("Furs").add(new Furs());
				}
				if (scan.next().equals("Robots")) {
					int robots = scan.nextInt();
					inventory.put("Robots", new ArrayList<TradeGood>());
					for (int i = 0; i < robots; i++)
						inventory.get("Robots").add(new Robots());
				}
				if (scan.next().equals("Medicine")) {
					int medicine = scan.nextInt();
					inventory.put("Medicine", new ArrayList<TradeGood>());
					for (int i = 0; i < medicine; i++)
						inventory.get("Medicine").add(new Medicine());
				}
				if (scan.next().equals("Food")) {
					int food = scan.nextInt();
					inventory.put("Food", new ArrayList<TradeGood>());
					for (int i = 0; i < food; i++)
						inventory.get("Food").add(new Food());
				}
				if (scan.next().equals("Narcotics")) {
					int narcotics = scan.nextInt();
					inventory.put("Narcotics", new ArrayList<TradeGood>());
					for (int i = 0; i < narcotics; i++)
						inventory.get("Narcotics").add(new Narcotics());
					playerCargoSettingDone = true;
				}
			}
			
			while (!currentPositionSettingDone) {
				ret = scan.next();
				if (ret.equals("CurrentGalaxy")) {
					String galaxy = scan.next();
					currentGalaxy = galaxy;
				}
				else if (ret.equals("CurrentPlanet")) {
					String planet = scan.next();
					currentPlanet = planet;
					currentPositionSettingDone = true;
				}
			}
			//System.out.println(universe.getNames().length);
			while (!universeSettingDone) {
				ret = scan.next();
				if (ret.equals("GalaxyName")) {
					
					galaxyName = scan.nextLine().trim();
					//System.out.println("GalaxyName " + galaxyName);
					//String techLevel = "";
					//int x = 0, y = 0;
					
					if (scan.next().equals("TechLevel"))
						techLevel = scan.nextLine().trim();
					if (scan.next().equals("Xcoordinate"))
						x = scan.nextInt();
					if (scan.next().equals("Ycoordinate"))
						y = scan.nextInt();
					//System.out.println("TechLevel " + techLevel + "X " + x + "Y " + y);
					galaxies[galaxyCounter] = new SolarSystem (galaxyName, x, y);
					galaxies[galaxyCounter].setTechLevel(techLevel);
					//galaxyCounter++;
					
					boolean galaxyDone = false;
					Planet[] planets = new Planet[1]; 
					while (!galaxyDone) {
						if (scan.next().equals("PlanetName")) {
							planetName = scan.next();
							//System.out.println(planetName);
							planets[0] = new Planet(planetName);
						}
						if (scan.next().equals("Resources")) {
							resources = scan.nextLine().trim();
							planets[0].setResources(resources);
						}
						if (scan.next().equals("TradeGoods")) {
							boolean planetGoodsSettingDone = false;
							while (!planetGoodsSettingDone) {
								ret = scan.next();
								if (ret.equals("Firearms")) {
									int firearms = scan.nextInt();
									planetGoods.put("Firearms", new ArrayList<TradeGood>());
									for (int i = 0; i < firearms; i++)
										planetGoods.get("Firearms").add(new Firearms());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> firearmsList = planetGoods.get("Firearms");
										int totalPrice = scan.nextInt();
										for (TradeGood item : firearmsList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Games")) {
									int games = scan.nextInt();
									planetGoods.put("Games", new ArrayList<TradeGood>());
									for (int i = 0; i < games; i++)
										planetGoods.get("Games").add(new Games());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> gamesList = planetGoods.get("Games");
										int totalPrice = scan.nextInt();
										for (TradeGood item : gamesList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Ore")) {
									int ore = scan.nextInt();
									planetGoods.put("Ore", new ArrayList<TradeGood>());
									for (int i = 0; i < ore; i++)
										planetGoods.get("Ore").add(new Ore());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> oreList = planetGoods.get("Ore");
										int totalPrice = scan.nextInt();
										for (TradeGood item : oreList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Water")) {
									int water = scan.nextInt();
									planetGoods.put("Water", new ArrayList<TradeGood>());
									for (int i = 0; i < water; i++)
										planetGoods.get("Water").add(new Water());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> waterList = planetGoods.get("Water");
										int totalPrice = scan.nextInt();
										for (TradeGood item : waterList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Machines")) {
									int machines = scan.nextInt();
									planetGoods.put("Machines", new ArrayList<TradeGood>());
									for (int i = 0; i < machines; i++)
										planetGoods.get("Machines").add(new Machines());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> machinesList = planetGoods.get("Machines");
										int totalPrice = scan.nextInt();
										for (TradeGood item : machinesList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Furs")) {
									int furs = scan.nextInt();
									planetGoods.put("Furs", new ArrayList<TradeGood>());
									for (int i = 0; i < furs; i++)
										planetGoods.get("Furs").add(new Furs());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> fursList = planetGoods.get("Furs");
										int totalPrice = scan.nextInt();
										for (TradeGood item : fursList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Robots")) {
									int robots = scan.nextInt();
									planetGoods.put("Robots", new ArrayList<TradeGood>());
									for (int i = 0; i < robots; i++)
										planetGoods.get("Robots").add(new Robots());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> robotsList = planetGoods.get("Robots");
										int totalPrice = scan.nextInt();
										for (TradeGood item : robotsList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Medicine")) {
									int medicine = scan.nextInt();
									planetGoods.put("Medicine", new ArrayList<TradeGood>());
									for (int i = 0; i < medicine; i++)
										planetGoods.get("Medicine").add(new Medicine());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> medicineList = planetGoods.get("Medicine");
										int totalPrice = scan.nextInt();
										for (TradeGood item : medicineList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Food")) {
									int food = scan.nextInt();
									planetGoods.put("Food", new ArrayList<TradeGood>());
									for (int i = 0; i < food; i++)
										planetGoods.get("Food").add(new Food());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> foodList = planetGoods.get("Food");
										int totalPrice = scan.nextInt();
										for (TradeGood item : foodList) {
											item.setTotalPrice(totalPrice);
										}
									}
								}
								if (ret.equals("Narcotics")) {
									int narcotics = scan.nextInt();
									//System.out.println("Narcotics " + narcotics);
									planetGoods.put("Narcotics", new ArrayList<TradeGood>());
									for (int i = 0; i < narcotics; i++)
										planetGoods.get("Narcotics").add(new Narcotics());
									ret = scan.next();
									if (ret.equals("TotalPrice")) {
										ArrayList<TradeGood> narcoticsList = planetGoods.get("Narcotics");
										int totalPrice = scan.nextInt();
										//System.out.println("Price " + totalPrice);
										for (TradeGood item : narcoticsList) {
											item.setTotalPrice(totalPrice);
										}
										ret = scan.next();
									}
									planetGoodsSettingDone = true;
								}
							}
							planets[0].setTradeGoods(planetGoods);
						}
						if (ret.equals("GalaxyDone")) {
							//System.out.println("Galaxy done for planet " + planets[0].getName());
							galaxies[galaxyCounter].setPlanets(planets);
							//System.out.println(galaxies[galaxyCounter].write());
							galaxyCounter++;
							//System.out.println(galaxyCounter);
							galaxyDone = true;
						}
					}
				}
				if (ret.equals("GalaxySettingDone")) {
					//System.out.println("Done");
					universeSettingDone = true;
					loadingDone = true;
				}
			}
		}
		for (SolarSystem galaxy : galaxies) {
			System.out.println(galaxy.write());
		}
	}
	
	/**
	 * Private class used to save game
	 * @author Samarth Agarwal
	 *
	 */
	public class SaveGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == marketView.getSaveButton()) {
				try {
					String f = (String)JOptionPane.showInputDialog(null, "Enter file name : ", "Save", JOptionPane.PLAIN_MESSAGE, null, null, "");
					FileWriter fw = new FileWriter(f + ".txt");
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw);
					out.println(player.write());
					out.println(playerShip.write() +"\n");
					out.println(cargo.write());
					out.println("CurrentGalaxy " + curGalaxy.name());
					out.println("CurrentPlanet " + curPlanet.getName() + "\n");
					for (SolarSystem system : galaxies) {
						out.println(system.write());
						out.println("GalaxyDone" + "\n");
					}
					out.println("GalaxySettingDone");
					out.flush();
					out.close();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Listener class for finishing character creation.
	 * @author Justin
	 */
	public class PlayerDoneListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(startView.checkFields()) {
				int pilot = startView.getPPoints();
				int fighter = startView.getFPoints();
				int engineer = startView.getEPoints();
				int trader = startView.getTPoints();
				String name = startView.getTextField();
				int difficulty = startView.getDifficulty();
				System.out.println("Difficulty : " + difficulty);
				
				player = new Player(pilot, fighter, trader, engineer, difficulty, name);
				player.printData();
				nextState(UNIVERSE);
			}
		}
	}
	
	/**
	 * Listener class for moving into the market view
	 * @author Justin
	 */
	public class PlanetListener implements ActionListener { //make sure clicking on current planet doesn't add a turn
		public void actionPerformed(ActionEvent e) {
			int distance = 0;
			universeView.getFuelWarning().setVisible(false);
			
			if(player.getTurn() > 0) {
				JButton tempButton = (JButton)e.getSource();
				SolarSystem destSystem = hash.get(tempButton);
				if(!destSystem.equals(curGalaxy)) {
					distance = destSystem.getDistanceTo();
					prevButton = curButton;
					curButton = tempButton;
				}
			}
			else {
				curButton = (JButton)e.getSource();
			}
			
			if(player.getFuel() >= distance) {
				curGalaxy = (SolarSystem)hash.get(e.getSource());
				curPlanet = curGalaxy.getPlanets()[0];
				
				universe.setCurGalaxy(curGalaxy);
				universe.setCurPlanet(curPlanet);
				
				System.out.println(curGalaxy.toString());
				
				setMarketValues();
				marketView.setPlanetName(curPlanet.getName());
				if(!curButton.equals(prevButton)) { //if selecting a different galaxy
					player.setTurn(player.getTurn()+1);
					System.out.println(distance);
					player.setFuel(player.getFuel()-distance);
				}
				showRange();
				System.out.println("Fuel Remaining: "+player.getFuel()+"\n");
				deflatedPrices = curPlanet.getDeflatedPrices();
				nextState(MARKET);
			}
			else {
				System.out.println("Distance travelled : " + distance);
				universeView.getFuelWarning().setVisible(true);
			}
		}
	}
	
	/**
	 * A listener determining whether an item was bought and if it can be bought
	 * @author Justin
	 */
	public class BuyListener implements ActionListener {
		Hashtable<String, ArrayList<TradeGood>> iPlanet;
		Hashtable<String, ArrayList<TradeGood>> iPlayer;
		
		public void actionPerformed(ActionEvent e) {
			marketView.getCreditWarning().setVisible(false);
			iPlanet = curPlanet.getTradeGoods();
			iPlayer = cargo.getTradeGoods();
			int amount = marketView.getAmount();
			int remaining = playerShip.getRemSpace();
			
			if(remaining - amount >= 0) {
				marketView.getSpaceWarning().setVisible(false);
				String resource = "";
				if(e.getSource() == marketView.getWaterBuy())
					resource = "Water";
				else if(e.getSource() == marketView.getFursBuy())
					resource = "Furs";
				else if(e.getSource() == marketView.getGamesBuy())
					resource = "Games";
				else if(e.getSource() == marketView.getFoodBuy())
					resource = "Food";
				else if(e.getSource() == marketView.getFirearmsBuy())
					resource = "Firearms";
				else if(e.getSource() == marketView.getMachinesBuy())
					resource = "Machines";
				else if(e.getSource() == marketView.getMedicineBuy())
					resource = "Medicine";
				else if(e.getSource() == marketView.getNarcoticsBuy())
					resource = "Narcotics";
				else if(e.getSource() == marketView.getOreBuy())
					resource = "Ore";
				else if(e.getSource() == marketView.getRobotsBuy())
					resource = "Robots";
				
				ArrayList<TradeGood> tPlayer = iPlayer.get(resource);
				ArrayList<TradeGood> tPlanet = iPlanet.get(resource);
				
				TradeGood tempSource;
				if(tPlanet.size() > 0) {
					tempSource = tPlanet.get(0);
				
					if(player.getCredits() < amount*tempSource.getTotalPrice()) {
						marketView.getCreditWarning().setVisible(true);
					}
					else if(tPlanet.size() >= amount) {
						
						for(int i = 0; i < amount; i++) {
							TradeGood tempGood = tPlanet.remove(tPlanet.size()-1);
							tPlayer.add(tempGood);
						}
						player.setCredits(player.getCredits() - (amount*tempSource.getTotalPrice()));
						playerShip.setRemSpace(remaining - amount);
						setMarketValues();
					}
					else {
						marketView.getSpaceWarning().setText("Not enough of that to buy!");
						marketView.getSpaceWarning().setVisible(true);
					}
				}
			}
			else {
				marketView.getSpaceWarning().setText("No space remaining in cargo hold!");
				marketView.getSpaceWarning().setVisible(true);
			}
			
			System.out.println(cargo.toString());
		}
		
	}
	
	/**
	 * A listener determining whether an item was sold and if it can be sold
	 * @author Justin
	 */
	public class SellListener implements ActionListener {
		Hashtable<String, ArrayList<TradeGood>> iPlanet;
		Hashtable<String, ArrayList<TradeGood>> iPlayer;
		
		public void actionPerformed(ActionEvent e) {
			iPlanet = curPlanet.getTradeGoods();
			iPlayer = cargo.getTradeGoods();
			int amount = marketView.getAmount();
			int remaining = playerShip.getRemSpace();
			String resource = "";
			
			if(e.getSource() == marketView.getWaterSell())
				resource = "Water";
			else if(e.getSource() == marketView.getFursSell())
				resource = "Furs";
			else if(e.getSource() == marketView.getGamesSell())
				resource = "Games";
			else if(e.getSource() == marketView.getFoodSell())
				resource = "Food";
			else if(e.getSource() == marketView.getFirearmsSell())
				resource = "Firearms";
			else if(e.getSource() == marketView.getMachinesSell())
				resource = "Machines";
			else if(e.getSource() == marketView.getMedicineSell())
				resource = "Medicine";
			else if(e.getSource() == marketView.getNarcoticsSell())
				resource = "Narcotics";
			else if(e.getSource() == marketView.getOreSell())
				resource = "Ore";
			else if(e.getSource() == marketView.getRobotsSell())
				resource = "Robots";
			
			ArrayList<TradeGood> tPlanet = iPlanet.get(resource);
			ArrayList<TradeGood> tPlayer = iPlayer.get(resource);
			if(tPlayer.size() >= amount) {
				marketView.getSpaceWarning().setVisible(false);
				for(int i = 0; i < amount; i++) {
					TradeGood tempGood = tPlayer.remove(tPlayer.size()-1);
					tPlanet.add(tempGood);
				}
				
				player.setCredits(player.getCredits() + (amount*tPlanet.get(0).getDeflatedPrice())); //!
				playerShip.setRemSpace(remaining + amount);
				setMarketValues();
			}
			else {
				marketView.getSpaceWarning().setText("Not enough of that to sell!");
				marketView.getSpaceWarning().setVisible(true);
			}
		
			System.out.println(cargo.toString());
		}
	}
	
	public class MapListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			nextState(UNIVERSE);
		}
		
	}
	
	
	
	
	
	/**
	 * Method to generate all of the galaxies.
	 * @return A list of galaxies in order to draw to map
	 */
	public SolarSystem[] generateGalaxies() {
		String[] names = universe.getNames();
		galaxies = new SolarSystem[names.length];
		String name = "";
		int x;
		int y;
		int tech;
		Random rand = new Random();
		
		for(int i = 0; i < names.length; i++) {
			x = rand.nextInt((frameWidth/names.length)-20) + (i*(frameWidth-20)/names.length);
			int scale = rand.nextInt(names.length-2)+1; //!
			y = rand.nextInt((frameHeight/names.length)-20) + (scale*(frameHeight-20)/names.length);
			tech = rand.nextInt(8);
			name = names[i];
			SolarSystem galaxy = new SolarSystem(name, x, y);
			galaxy.setTech(tech);
			galaxies[i] = galaxy;
		}
		
		planetList = generatePlanets();
		return galaxies;
	}
	
	/**
	 * Method to generate planets called once all of the galaxies are created.
	 * @return An array of all the planets for record
	 */
	public Planet[] generatePlanets() {
		Random rand = new Random();
		String[] planetNames = universe.getPNames();
		Planet[] allPlanets = new Planet[planetNames.length];
		
		for(int i = 0; i < planetNames.length; i++) {
				int num = rand.nextInt(13);
				Planet[] planets = new Planet[1]; //change to more to add more planets
				planets[0] = new Planet(planetNames[i]); //loop through to create more planets
				planets[0].setResources(num);
				planets[0].setGalaxy(galaxies[i]);
				galaxies[i].setPlanets(planets);
				allPlanets[i] = planets[0];
		}
		refreshTradeGoods();
		return allPlanets;
	}
	
	/**
	 * A method that resets the trade goods in the Universe
	 */
	public void refreshTradeGoods() {
		Random rand = new Random();
		
		//System.out.println(galaxies.length);
		for(int i = 0; i < galaxies.length; i++) {
			SolarSystem galaxy = galaxies[i];
			Planet[] planets = galaxy.getPlanets();
			TradeGood[] listGoods = new TradeGood[] {
					new Water(),
					new Furs(),
					new Games(),
					new Food(),
					new Firearms(),
					new Machines(),
					new Medicine(),
					new Narcotics(),
					new Ore(),
					new Robots()
			};
			
			for(int j = 0; j < planets.length; j++) {
				
				//System.out.println("Galaxy: "+galaxies[i].name()+" Planet: "+planets[j].getName()); //!
				
				Planet planet = planets[j];
				Hashtable<String, ArrayList<TradeGood>> tempGoods = new Hashtable<String, ArrayList<TradeGood>>();
				
				for(TradeGood resource : listGoods) {
					int quantity;
					TradeGood tempResource = resource;
					if(galaxies[i].getTechLevelNum() >= resource.getMTLP())
						quantity = rand.nextInt(10) + 3; //produces at least 3 of each possible resource
					else
						quantity = 0;
					
					//calculate price
					double fract = rand.nextInt(resource.getVar()+1)/100d;
					int offset = (int)(fract*(double)resource.getPrice());
					int flux = resource.getIPL()*(galaxies[i].getTechLevelNum()-resource.getMTLP());
					int price = resource.getPrice() + flux + offset;
					tempResource.setTotalPrice(price);
					//System.out.println(price);
					
					//System.out.println("Resource: "+resource.getName()+" Price: "+price); //!
					
					ArrayList<TradeGood> list = new ArrayList<TradeGood>(quantity);
					for(int n = 0; n < quantity; n++) {
						list.add(tempResource);
					}
					tempGoods.put(resource.getName(), list);
				}
				
				planet.setTradeGoods(tempGoods);
				
			}
		}
		
	}
	
	/**
	 * A method that resets the resources in the cargo bay
	 */
	public void refreshCargoGoods() {
		TradeGood[] listGoods = new TradeGood[] {
				new Water(),
				new Furs(),
				new Games(),
				new Food(),
				new Firearms(),
				new Machines(),
				new Medicine(),
				new Narcotics(),
				new Ore(),
				new Robots()
		};
		
		Hashtable<String, ArrayList<TradeGood>> tempGoods = new Hashtable<String, ArrayList<TradeGood>>();
				
		for(TradeGood resource : listGoods) {
			int quantity = 0;
			ArrayList<TradeGood> list = new ArrayList<TradeGood>(quantity);
			for(int n = 0; n < quantity; n++) {
				list.add(resource);
			}
			tempGoods.put(resource.getName(), list);
		}
				
		cargo.setTradeGoods(tempGoods);
	}

	/**
	 * A method that sets the market values on the market view
	 */
	public void setMarketValues() {
		Hashtable<String, ArrayList<TradeGood>> iPlanet = curPlanet.getTradeGoods();
		Hashtable<String, ArrayList<TradeGood>> iPlayer = cargo.getTradeGoods();
		
		
		marketView.setLblRemaining(""+playerShip.getRemSpace());

		for(Entry entry : iPlanet.entrySet()) {
			ArrayList<TradeGood> mResource = (ArrayList<TradeGood>)entry.getValue();
			int quantity = mResource.size();
			
			if((String)entry.getKey() == "Water") {
				marketView.getLblMwater().setText(""+quantity);
				if(quantity == 0)
					marketView.getWaterBuy().setEnabled(false);
				else {
					marketView.getWaterBuy().setEnabled(true);
					marketView.getWaterBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Furs") {
				marketView.getLblMfurs().setText(""+quantity);
				if(quantity == 0)
					marketView.getFursBuy().setEnabled(false);
				else {
					marketView.getFursBuy().setEnabled(true);
					marketView.getFursBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Games") {
				marketView.getLblMgames().setText(""+quantity);
				if(quantity == 0)
					marketView.getGamesBuy().setEnabled(false);
				else {
					marketView.getGamesBuy().setEnabled(true);
					marketView.getGamesBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Firearms") {
				marketView.getLblMfirearms().setText(""+quantity);
				if(quantity == 0)
					marketView.getFirearmsBuy().setEnabled(false);
				else {
					marketView.getFirearmsBuy().setEnabled(true);
					marketView.getFirearmsBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Food") {
				marketView.getLblMfood().setText(""+quantity);
				if(quantity == 0)
					marketView.getFoodBuy().setEnabled(false);
				else {
					marketView.getFoodBuy().setEnabled(true);
					marketView.getFoodBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Machines") {
				marketView.getLblMmachines().setText(""+quantity);
				if(quantity == 0)
					marketView.getMachinesBuy().setEnabled(false);
				else {
					marketView.getMachinesBuy().setEnabled(true);
					marketView.getMachinesBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Robots") {
				marketView.getLblMrobots().setText(""+quantity);
				if(quantity == 0)
					marketView.getRobotsBuy().setEnabled(false);
				else {
					marketView.getRobotsBuy().setEnabled(true);
					marketView.getRobotsBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Medicine") {
				marketView.getLblMmedicine().setText(""+quantity);
				if(quantity == 0)
					marketView.getMedicineBuy().setEnabled(false);
				else {
					marketView.getMedicineBuy().setEnabled(true);
					marketView.getMedicineBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Narcotics") {
				marketView.getLblMnarcotics().setText(""+quantity);
				if(quantity == 0)
					marketView.getNarcoticsBuy().setEnabled(false);
				else {
					marketView.getNarcoticsBuy().setEnabled(true);
					marketView.getNarcoticsBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
			else if((String)entry.getKey() == "Ore") {
				marketView.getLblMore().setText(""+quantity);
				if(quantity == 0)
					marketView.getOreBuy().setEnabled(false);
				else {
					marketView.getOreBuy().setEnabled(true);
					marketView.getOreBuy().setText("Buy["+mResource.get(0).getTotalPrice()+"]");
				}
			}
		}

		for(Entry entry : iPlayer.entrySet()) { //deflated price working for only one planet!
			ArrayList<TradeGood> pResource = (ArrayList<TradeGood>)entry.getValue();
			int quantity = pResource.size();
			boolean disable = false;
			
			if(pResource.size() > 0 && curGalaxy.getTechLevelNum() < pResource.get(0).getMTLU())
				disable = true;
			
			if((String)entry.getKey() == "Water") {
				marketView.getLblCwater().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getWaterSell().setEnabled(false);
				else {
					marketView.getWaterSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getWaterSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Furs") {
				marketView.getLblCfurs().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getFursSell().setEnabled(false);
				else {
					marketView.getFursSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getFursSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Games") {
				marketView.getLblCgames().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getGamesSell().setEnabled(false);
				else {
					marketView.getGamesSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getGamesSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Firearms") {
				marketView.getLblCfirearms().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getFirearmsSell().setEnabled(false);
				else {
					marketView.getFirearmsSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getFirearmsSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Food") {
				marketView.getLblCfood().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getFoodSell().setEnabled(false);
				else {
					marketView.getFoodSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getFoodSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Machines") {
				marketView.getLblCmachines().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getMachinesSell().setEnabled(false);
				else {
					marketView.getMachinesSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getMachinesSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Robots") {
				marketView.getLblCrobots().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getRobotsSell().setEnabled(false);
				else {
					marketView.getRobotsSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getRobotsSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Medicine") {
				marketView.getLblCmedicine().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getMedicineSell().setEnabled(false);
				else {
					marketView.getMedicineSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getMedicineSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Narcotics") {
				marketView.getLblCnarcotics().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getNarcoticsSell().setEnabled(false);
				else {
					marketView.getNarcoticsSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getNarcoticsSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			else if((String)entry.getKey() == "Ore") {
				marketView.getLblCore().setText(""+quantity);
				if(quantity == 0 || disable)
					marketView.getOreSell().setEnabled(false);
				else {
					marketView.getOreSell().setEnabled(true);
					//adds deflation to items in inventory
					if(!deflatedPrices.get(pResource.get(0).getName()).equals(null)) {
						marketView.getOreSell().setText("Sell["+deflatedPrices.get(pResource.get(0).getName())+"]");
					}
				}
			}
			
			marketView.getLblRemcredits().setText(""+player.getCredits());
		}
		
	}
	
	public void showRange() {
		JButton[] buttons = (JButton[])hash.keySet().toArray(new JButton[hash.size()]);
		Border closeBorder = new LineBorder(Color.YELLOW, 1);
		Border farBorder = new LineBorder(Color.RED, 1);
		Border curBorder = new LineBorder(Color.GREEN, 1);
		
		for(int i = 0; i < buttons.length; i++) {
			if(!buttons[i].equals(curButton)) {
				int dX = buttons[i].getX() - curButton.getX();
				int dY = buttons[i].getY() - curButton.getY();
				int distance = (int)Math.pow((dX*dX)+(dY*dY), 1d/2d);
				
				hash.get(buttons[i]).setDistanceTo(distance); //set distance to galaxy
				
				System.out.println(hash.get(buttons[i]).name()+": "+distance);
				
				if(distance <= player.getFuel()/2) { //yellow means close range
					buttons[i].setBorder(closeBorder);
				}
				else if(distance > player.getFuel()/2 && distance <= player.getFuel()) { //red means far range
					buttons[i].setBorder(farBorder);
				}
				else {
					buttons[i].setBorder(null);
				}
			}
			else {
				curButton.setBorder(curBorder); //sets current galaxy's border
			}
		}
		
	}
	
	/**
	 * Main method (should move to own driver class)
	 */
	public static void main(String[] args) {
		new MainController();
	}
}

/**
 * To Do
 * =====
 * +In MarketView, disallow spinner to go below 0 with listener
 * +Fix location generation of planets to disallow overlapping
 * +Fix issues with displaying the same price in market [FIXED]
 * +Make quantity of items per planet dependent on situation
 * 
 * Quote:
 * "And then, the Earth being small, mankind will migrate into space, 
 * and will cross the airless Saharas which separate planet from planet and sun from sun."
 * -Winwood Reade, THE MARTYRDOM OF MAN, 1872
 */