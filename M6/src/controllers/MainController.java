package controllers;
import java.awt.Dimension;
import views.*;

import javax.swing.JFrame;

public class MainController {
	private MainView mView;
	private IntroController intro;
	
	public MainController() {
		mView = new MainView();
		intro = new IntroController();
	}

}
