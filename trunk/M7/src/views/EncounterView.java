package views;
import java.awt.Color;
import java.util.Random;
import javax.swing.*;

import systems.MainController.MarketListener;
public class EncounterView extends JPanel {
	
	private JPanel panel;
	private double creditChange;
	private JLabel message = new JLabel();
	private JButton cont =  new JButton("Continue");
	private static Random gen = new Random();
	//private Player player;
	//private 
	
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
//		double chance = gen.nextDouble();
//		if(chance < .5) {
			creditChange = Math.floor(gen.nextDouble()*100);
			message.setText("You have found " + creditChange + " credits!");
	}
	
	
	public void badEncounter() {
		creditChange = -1*Math.floor(gen.nextDouble()*100);
		message.setText("Pirates stole " + -1*creditChange + " credits from you...");
	}
	
	public void noEncounter() {
		message.setText("You have arrived at your destination safely.");
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public double getCreditChange() {
		return creditChange;
	}
	
}
