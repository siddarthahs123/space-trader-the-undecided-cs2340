package controllers;
import java.awt.Dimension;
import views.*;

import javax.swing.JFrame;

public class MainController {
	private StartController start;
	JFrame frameSpaceTrader = new JFrame();
	MainView mView;
	
	public MainController() {
		start = new StartController();
		
		mView = new MainView();
	}
	
	public static void main(String[] args) {
		MainController main = new MainController();
	}
}
