package systems;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

import models.*;
import views.*;

/**
 * Main Controller class for the game. Does all of the labor required.
 * @author Justin
 */
public class MainController extends JFrame {
	private JFrame frame;
	private Dimension dim;
	private JPanel cards;
	private int frameWidth, frameHeight;
	private final String INTRO = "Intro Screen";
	private final String START = "Start Screen";
	private final String UNIVERSE = "Universe Screen";
	private final String MARKET = "Market Screen";
	
	private Hashtable hash;
	private SolarSystem curGalaxy;
	private Planet curPlanet;
	private Universe universe;
	private Planet[] planetList;
	private SolarSystem[] galaxies;
	
	private StartView startView;
	private MarketView marketView;
	
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
		refreshTradeGoods();
		//FOR DEBUGGIN ONLY
		/*for(int i = 0; i < galaxies.length; i++) {
			System.out.println(galaxies[i].toString());
		}*/
		///////////////////
		UniverseView universeView = new UniverseView();
		hash = universeView.drawGalaxies(galaxies, new PlanetListener());
		JPanel universeCard = universeView.getPanel();
		
		//Generate market view
		marketView = new MarketView();
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
		Player player;
		
		public void actionPerformed(ActionEvent e) {
			if(startView.checkFields()) {
				int pilot = startView.getPPoints();
				int fighter = startView.getFPoints();
				int engineer = startView.getEPoints();
				int trader = startView.getTPoints();
				String name = startView.getTextField();
				int difficulty;
				if(startView.difficultyGroup().getSelection() == startView.easy()) {
					difficulty = 1;
				}
				else if(startView.difficultyGroup().getSelection() == startView.medium()) {
					difficulty = 2;
				}
				else {
					difficulty = 3;
				}
				
				player = new Player(pilot, fighter, trader, engineer, difficulty, name);
				nextState(UNIVERSE);
			}
		}
	}
	
	public class PlanetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			curGalaxy = (SolarSystem)hash.get(e.getSource());
			curPlanet = curGalaxy.getPlanets()[0];
			universe.setCurGalaxy(curGalaxy);
			universe.setCurPlanet(curPlanet);
			System.out.println(curGalaxy.toString());
			
			marketView.setPlanetName(curPlanet.getName());
			nextState(MARKET);
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
			int scale = rand.nextInt(names.length-1);
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
	
	public void refreshTradeGoods() {
		Random rand = new Random();
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
		
		for(int i = 0; i < galaxies.length; i++) {
			SolarSystem galaxy = galaxies[i];
			Planet[] planets = galaxy.getPlanets();
			
			for(int j = 0; j < planets.length; j++) {
				Planet planet = planets[j];
				Hashtable<String, ArrayList<TradeGood>> tempGoods = new Hashtable<String, ArrayList<TradeGood>>();
				
				for(int m = 0; m < listGoods.length; m++) {
					int quantity = rand.nextInt(10);
					ArrayList<TradeGood> list = new ArrayList<TradeGood>(quantity);
					for(int n = 0; n < quantity; n++) {
						list.add(listGoods[m]);
					}
					tempGoods.put(listGoods[m].getName(), list);
				}
				
				planet.setTradeGoods(tempGoods);
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
 * +Add listeners for all planets (should make own listener class)
 * +Add marketplace interactions and general economy
 * +Fix location generation of planets to disallow overlapping
 */
