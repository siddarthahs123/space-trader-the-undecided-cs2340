package views;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;

public class IntroView extends MainView {

	private JButton btnNewGame, btnLoadGame;
	private boolean loadGame, newGame;
	private JPanel panel;
	
	public IntroView() {
		initialize();
	}
	
	public void initialize() {
		
		panel = new JPanel();
		//panel.setBounds(6, 6, frame.getWidth(), frame.getHeight());
		panel.setBounds(6, 6, 679, 473);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(264, 161, 117, 29);
		panel.add(btnNewGame);
		btnNewGame.addActionListener(new NewListener());
		
		btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBounds(264, 231, 117, 29);
		panel.add(btnLoadGame);
		btnLoadGame.addActionListener(new LoadListener());
		
		
		
		frame.setVisible(true);
		
	}
	
	public class NewListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(loadGame == false) {
				newGame = true;
				panel.setVisible(false);
			}
		}
	}
	
	public class LoadListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(newGame == false) {
				loadGame = true;
				panel.setVisible(false);
			}
		}
	}
	
	public boolean getNewGameCondition() {
		return newGame;
	}
	
	public boolean getLoadGameCondition() {
		return loadGame;
	}
}
