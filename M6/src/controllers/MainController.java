package controllers;
import java.awt.Dimension;
import views.*;

import javax.swing.JFrame;

public class MainController {
	private StartController start;
	private MainView mView;
	
	public MainController() {
		mView = new MainView();
		start = new StartController();
	}
	
	/*public static void main(String[] args) {
		MainController main = new MainController();
	}*/
}
