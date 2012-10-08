import java.awt.Dimension;

import javax.swing.*;

public class StartController {
	private StartView sView;
	private Player player;
	
	public StartController() {
		sView = new StartView();
		JFrame frame = sView.getFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(670, 550));
		frame.pack();
		frame.setVisible(true);
		player = new Player();
		
		update();
	}
	
	public boolean update() {
		int pointsRem = 16;
		
		int pilot = 0;
		int fighter = 0;
		int trader = 0;
		int engineer = 0;
		
		while(sView.getDone() == false) {
			pilot = Integer.parseInt(sView.getpPoints().getText());
			fighter = Integer.parseInt(sView.getfPoints().getText());
			trader = Integer.parseInt(sView.gettPoints().getText());
			engineer = Integer.parseInt(sView.getePoints().getText());
			
			pointsRem = 16-(pilot+fighter+trader+engineer);
			
			if(pilot == 0) {
				sView.getpMinus().setEnabled(false);
			}
			else {
				sView.getpMinus().setEnabled(true);
			}
			
			if(fighter == 0) {
				sView.getfMinus().setEnabled(false);
			}
			else {
				sView.getfMinus().setEnabled(true);
			}
			
			if(trader == 0) {
				sView.gettMinus().setEnabled(false);
			}
			else {
				sView.gettMinus().setEnabled(true);
			}
			
			if(engineer == 0) {
				sView.geteMinus().setEnabled(false);
			}
			else {
				sView.geteMinus().setEnabled(true);
			}
			
			if(pointsRem > 0) {
				sView.getpPlus().setEnabled(true);
				sView.getfPlus().setEnabled(true);
				sView.gettPlus().setEnabled(true);
				sView.getePlus().setEnabled(true);
				
				player.setPilot(pilot);
				player.setFighter(fighter);
				player.setTrader(trader);
				player.setEngineer(engineer);
				player.setName(sView.getName());
				
				
			}
			else {
				sView.getpPlus().setEnabled(false);
				sView.getfPlus().setEnabled(false);
				sView.gettPlus().setEnabled(false);
				sView.getePlus().setEnabled(false);
			}
			sView.getPointsLabel().setText(pointsRem+"");
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		StartController start = new StartController();
	}
}
