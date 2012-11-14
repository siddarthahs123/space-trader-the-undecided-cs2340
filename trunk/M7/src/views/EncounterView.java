package views;
import java.awt.Color;
import java.util.Random;
import javax.swing.*;
import systems.MainController.MarketListener;
import models.*;

public class EncounterView extends JPanel {
	
	private JPanel panel;
	private double creditChange = 0;
	private JLabel message = new JLabel();
	private JButton cont =  new JButton("Continue");
	private static Random gen = new Random();
	private String[] randGoods = {"Water", "Furs", "Games", "Food", "Firearms", "Machines",
			"Medicine", "Narcotics", "Ore", "Robots"};
	private TradeGood randomGood;
	private String randomGoodKey;
	
	public EncounterView(MarketListener ml) {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setBackground(Color.black);
		selectEncounter();
		cont.addActionListener(ml);
		message.setForeground(Color.white);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		cont.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(message);
		panel.add(cont);
	}
	
	public void selectEncounter() {
		int chance = gen.nextInt(3);
		if(chance == 0) {
			goodEncounter();
		} else if(chance == 1){
			badEncounter();
		} else { 
			noEncounter();
		}
	}
	
	public void goodEncounter() {
		int chance = gen.nextInt(2);
		if(chance == 0) {
			creditChange = Math.floor(gen.nextDouble()*100);
			message.setText("You found " + creditChange + " credits!");
		} else {
			randomGood = randomTradeGood();
			message.setText("You found " + randomGoodKey);
		}
	}
	
	public void badEncounter() {
		creditChange = -1*Math.floor(gen.nextDouble()*200);
		message.setText("Pirates stole " + -1*creditChange + " credits from you...");
	}
	
	public void noEncounter() {
		message.setText("You have arrived at your destination safely.");
	}
	
	public TradeGood randomTradeGood() {
		int choice = gen.nextInt(randGoods.length - 1);
		TradeGood newObj = null;
		randomGoodKey = randGoods[choice]; 
		if(randomGoodKey.equals("Water")) {
			newObj = new Water();
		} else if(randomGoodKey.equals("Furs")) {
			newObj = new Furs();
		} else if(randomGoodKey.equals("Games")) {
			newObj = new Games();
		} else if(randomGoodKey.equals("Food")) {
			newObj = new Food();
		} else if(randomGoodKey.equals("Firearms")) {
			newObj = new Firearms();
		} else if(randomGoodKey.equals("Machines")) {
			newObj = new Machines();
		} else if(randomGoodKey.equals("Medicine")) {
			newObj = new Medicine();
		} else if(randomGoodKey.equals("Narcotics")) {
			newObj = new Narcotics();
		} else if(randomGoodKey.equals("Ore")) {
			newObj = new Ore();
		} else if(randomGoodKey.equals("Robots")) {
			newObj = new Robots();
		}
		return newObj;
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public double getCreditChange() {
		return creditChange;
	}
	
	public TradeGood getTradeGood() {
		return randomGood;
	}
	
	public String getTradeGoodKey() {
		return randomGoodKey;
	}
	
}
