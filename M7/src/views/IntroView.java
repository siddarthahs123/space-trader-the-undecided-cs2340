package views;

import javax.swing.*;

public class IntroView extends MainView {

	private JPanel panel;
	private JButton btnNewGame, btnLoadGame;
	
	public IntroView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(264, 161, 117, 29);
		panel.add(btnNewGame);
		
		btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBounds(264, 231, 117, 29);
		panel.add(btnLoadGame);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public JButton getBtnNewGame() {
		return btnNewGame;
	}
	
	public JButton getBtnLoadGame() {
		return btnLoadGame;
	}
	
}
