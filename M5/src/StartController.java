import java.util.*;
import java.awt.*;
import javax.swing.*;

public class StartController {
	private StartView sView;
	private Player player;
	
	public StartController() {
		sView = new StartView();
		JFrame frame = sView.getFrame();
		frame.pack();
		frame.setVisible(true);
		player = new Player();
		
		update();
	}
	
	public boolean update() {
		int pointsRem;
		
		while(sView.getDone() == false) {
			
			pointsRem = 16-(sView.getPilot()+sView.getFighter()+sView.getTrader()+sView.getEngineer());
			
			if(pointsRem >= 0) {
				player.setPilot(sView.getPilot());
				player.setFighter(sView.getFighter());
				player.setTrader(sView.getTrader());
				player.setEngineer(sView.getEngineer());
				player.setName(sView.getName());
				
				sView.setPointsLabel(pointsRem);
			}
			else if(pointsRem == 0) {
			
			}
			
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		StartController start = new StartController();
	}
}
