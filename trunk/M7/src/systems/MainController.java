package systems;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import models.*;
import views.*;

public class MainController extends JFrame {
	private JFrame frame;
	private Dimension dim;
	private JPanel cards;
	private final String INTRO = "Intro Screen";
	private final String START = "Start Screen";
	
	public MainController() {
		dim = new Dimension(639, 473);
		frame = new JFrame("Space Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(dim);
		
		addViews(frame.getContentPane());
		
		
		
		
		
		frame.setVisible(true);
		frame.pack();
	}
	
	/**
	 * Sets up all of the views and adds panels as cards.
	 * 
	 * @return If cards were successfully added
	 */
	public void addViews(Container pane) {
		IntroView introView = new IntroView();
		JPanel introCard = introView.getPanel();
		introView.getBtnNewGame().addActionListener(new NewGameListener());
		introView.getBtnLoadGame().addActionListener(new LoadGameListener());
		
		StartView startView = new StartView();
		JPanel startCard = startView.getPanel();
		
		
		cards = new JPanel(new CardLayout());
		cards.add(introCard, INTRO);
		cards.add(startCard, START);

        pane.add(cards, BorderLayout.CENTER);
	}

	public void nextState(String next) {
		CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, next);
	}
	
	/**
	 * Listener class for new game selection.
	 * @author Justin
	 */
	public class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nextState(START);
		}
	}
	
	/**
	 * Listener class for load game selection.
	 * @author Justin
	 */
	public class LoadGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	
	
	public static void main(String[] args) {
		MainController main = new MainController();
	}
}
