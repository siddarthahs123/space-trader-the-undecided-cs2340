package controllers;

import views.*;

public class IntroController{
	
	private IntroView iView;

	public IntroController() {
		iView = new IntroView();
		update();
	}

	private void update() {
		
		boolean done = false;
		while (!done) {
			System.out.println("Running");
			if (iView.getNewGameCondition()) {
				StartController start = new StartController();
				done = true;
			}
			else if (iView.getLoadGameCondition()) {
//				LoadController load = new LoadController();
//				done = true;
			}
		}
	}
	
	
}
