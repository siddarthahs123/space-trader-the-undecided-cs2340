package controllers;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainController {
	private StartController start;
	JFrame frameSpaceTrader = new JFrame();
	
	public MainController() {
		start = new StartController();
		frameSpaceTrader = new JFrame();
		frameSpaceTrader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSpaceTrader.setPreferredSize(new Dimension(1920,1080));
		frameSpaceTrader.pack();
		frameSpaceTrader.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainController main = new MainController();
	}
}
