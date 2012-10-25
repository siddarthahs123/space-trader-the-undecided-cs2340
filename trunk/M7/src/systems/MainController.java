package systems;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import java.util.*;
import java.util.Map.Entry;

import models.*;
import views.*;

/**
 * Main Controller class for the game. Does all of the labor required.
 * @author Justin
 */
public class MainController extends JFrame {
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
		IntroView introView = new IntroView();
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
		marketView = new MarketView(new BuyListener(), new SellListener(), new MapListener());
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
	 * @author Justin
	 */
	public class LoadGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
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
				int difficulty;
				if(startView.easy().isSelected()) {
					difficulty = 0;
				}
				else if(startView.medium().isSelected()) {
					difficulty = 1;
				}
				else {
					difficulty = 2;
				}
				
				player = new Player(pilot, fighter, trader, engineer, 0, name);
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
			double distance = 0;
			universeView.getFuelWarning().setVisible(false);
			
			if(player.getTurn() > 0) {
				JButton tempButton = (JButton)e.getSource();
				SolarSystem destSystem = hash.get(tempButton);
				if(!destSystem.equals(curGalaxy)) {
					int sX = destSystem.getX();
					int sY = destSystem.getY();
					int dX = sY - curGalaxy.getX();
					int dY = sX - curGalaxy.getY();
					distance = Math.pow((dX*dX)+(dY*dY), 1d/2d);
					prevButton = curButton;
					curButton = tempButton;
				}
			}
			else {
				curButton = (JButton)e.getSource();
			}
			
			if(player.getFuel() >= distance) {
				Border thickBorder = new LineBorder(Color.RED, 1);
				curButton.setBorder(thickBorder); //sets current galaxy's border
				curGalaxy = (SolarSystem)hash.get(e.getSource());
				curPlanet = curGalaxy.getPlanets()[0];
				
				//System.out.println("CurGalaxy: "+curGalaxy.name()+" CurPlanet: "+curPlanet.getName());
				
				universe.setCurGalaxy(curGalaxy);
				universe.setCurPlanet(curPlanet);
				
				System.out.println(curGalaxy.toString());
				
				setMarketValues();
				marketView.setPlanetName(curPlanet.getName());
				if(!curButton.equals(prevButton)) { //if selecting a different galaxy
					player.setTurn(player.getTurn()+1);
					player.setFuel(player.getFuel()-(int)distance);
				}
				showRange();
				System.out.println("Fuel Remaining: "+player.getFuel()+"\n");
				deflatedPrices = curPlanet.getDeflatedPrices();
				nextState(MARKET);
			}
			else {
				
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
	
	public void showRange() { //utilize this for determining if a ship can make it to a galaxy
		JButton[] buttons = (JButton[])hash.keySet().toArray(new JButton[hash.size()]);
		Border closeBorder = new LineBorder(Color.GREEN, 1);
		Border farBorder = new LineBorder(Color.YELLOW, 1);
		Border curBorder = new LineBorder(Color.RED, 1);
		
		for(int i = 0; i < buttons.length; i++) {
			if(!buttons[i].equals(curButton)) {
				int dX = buttons[i].getX() - curButton.getX();
				int dY = buttons[i].getY() - curButton.getY();
				int distance = (int)Math.pow((dX*dX)+(dY*dY), 1d/2d);
				System.out.println(hash.get(buttons[i]).name()+": "+distance);
				
				if(distance <= player.getFuel()/2) { //green means close range
					buttons[i].setBorder(closeBorder);
				}
				else if(distance > player.getFuel()/2 && distance <= player.getFuel()) { //yellow means far range
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
