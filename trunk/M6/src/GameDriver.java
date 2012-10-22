import controllers.*;

public class GameDriver {
	
	public static void main(String[] args) {
		boolean isDone = false;
		boolean newGame = false; //set true if new game is selected (IntroController)
		boolean loadGame = false; //set true if load game is selected (IntroController)
		
		MainController mCont = new MainController();
		//IntroController iCont = new IntroController();
		
		while(isDone == false) {
			newGame = true;
			if(newGame) {
				StartController start = new StartController();
				newGame = false;
			}
			
		}
		
	}
	
}
