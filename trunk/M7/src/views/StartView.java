/**
 * package that contains this class
 */
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Screen for creating player
 * @author Bao
 * @version 1.0
 */
public class StartView extends JPanel {

	/**
	 * JPanel
	 */
	private JPanel panel;

	/**
	 * Buttons for skill points
	 */
	private JButton fPlus, tPlus, ePlus, pPlus, fMinus, tMinus, eMinus, pMinus,
			btnDone, btnRoll;

	/**
	 * Labels to indicate skill points
	 */
	private JLabel fPoints, tPoints, ePoints, pPoints, pointsWarning,
			nameWarning, pointsLabel;

	/**
	 * X coordinate for panel
	 */
	private static final int XCORD = 6;
	
	/**
	 * Y coordinate for panel
	 */
	private static final int YCORD = 6;
	
	/**
	 * Width for panel
	 */
	private static final int WIDTH = 679;
	
	/**
	 * Height for panel
	 */
	
	private static final int HEIGHT = 473;
	/**
	 * Buttons for new/load/continue game
	 */
	
	/**
	 * Text field
	 */
	private JTextField textField;

	/**
	 * Radio buttons for difficulty
	 */
	private JRadioButton rdbtnEasy, rdbtnMedium, rdbtnHard;

	/**
	 * Button group for difficulty setting
	 */
	private ButtonGroup difficultyGroup;

	/**
	 * Random label
	 */
	private JLabel lblRandomly;

	/**
	 * Game difficulty value
	 */
	private int difficulty;

	/**
	 * Constructor
	 */
	/**
	 * 
	 */
	public StartView() {
		panel = new JPanel();
		panel.setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		panel.setLayout(null);

		final JLabel lblWhatIsYour = new JLabel("What is your name?");
		lblWhatIsYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatIsYour.setBounds(78, 20, 121, 16);
		panel.add(lblWhatIsYour);

		final JLabel lblPleaseAllocatePoints = new JLabel("Please allocate points:");
		lblPleaseAllocatePoints.setBounds(59, 139, 140, 16);
		panel.add(lblPleaseAllocatePoints);

		final JLabel lblPilot = new JLabel("Pilot");
		lblPilot.setBounds(59, 196, 28, 16);
		panel.add(lblPilot);

		final JLabel lblFighter = new JLabel("Fighter");
		lblFighter.setBounds(59, 248, 44, 16);
		panel.add(lblFighter);

		final JLabel lblTrader = new JLabel("Trader");
		lblTrader.setBounds(59, 300, 40, 16);
		panel.add(lblTrader);

		final JLabel lblEngineer = new JLabel("Engineer");
		lblEngineer.setBounds(59, 353, 54, 16);
		panel.add(lblEngineer);

		textField = new JTextField();
		textField.setBounds(42, 38, 191, 28);
		panel.add(textField);
		textField.setColumns(10);

		final JLabel lblPointsLeft = new JLabel("Points left:");
		lblPointsLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsLeft.setBounds(289, 184, 68, 16);
		panel.add(lblPointsLeft);

		pointsLabel = new JLabel("16");
		pointsLabel.setBounds(316, 209, 16, 16);
		panel.add(pointsLabel);

		btnDone = new JButton("Done");
		btnDone.setBounds(431, 329, 95, 67);
		panel.add(btnDone);

		btnRoll = new JButton("Roll");
		btnRoll.setBounds(278, 329, 95, 67);
		panel.add(btnRoll);
		btnRoll.addActionListener(new RandomListener());

		pPoints = new JLabel("0");
		pPoints.setBounds(183, 196, 16, 16);
		panel.add(pPoints);

		fPoints = new JLabel("0");
		fPoints.setBounds(183, 248, 16, 16);
		panel.add(fPoints);

		tPoints = new JLabel("0");
		tPoints.setBounds(183, 300, 16, 16);
		panel.add(tPoints);

		ePoints = new JLabel("0");
		ePoints.setBounds(183, 353, 16, 16);
		panel.add(ePoints);

		ActionListener plusListener = new PlusListener();
		ActionListener minusListener = new MinusListener();

		pPlus = new JButton("+");
		pPlus.setBounds(211, 184, 22, 16);
		pPlus.addActionListener(plusListener);
		panel.add(pPlus);

		pMinus = new JButton("-");
		pMinus.setBounds(211, 209, 22, 16);
		pMinus.addActionListener(minusListener);
		panel.add(pMinus);

		fPlus = new JButton("+");
		fPlus.setBounds(211, 237, 22, 16);
		fPlus.addActionListener(plusListener);
		panel.add(fPlus);

		fMinus = new JButton("-");
		fMinus.setBounds(211, 261, 22, 16);
		fMinus.addActionListener(minusListener);
		panel.add(fMinus);

		tPlus = new JButton("+");
		tPlus.setBounds(211, 289, 22, 16);
		tPlus.addActionListener(plusListener);
		panel.add(tPlus);

		tMinus = new JButton("-");
		tMinus.setBounds(211, 312, 22, 16);
		tMinus.addActionListener(minusListener);
		panel.add(tMinus);

		ePlus = new JButton("+");
		ePlus.setBounds(211, 340, 22, 16);
		ePlus.addActionListener(plusListener);
		panel.add(ePlus);

		eMinus = new JButton("-");
		eMinus.setBounds(211, 364, 22, 16);
		eMinus.addActionListener(minusListener);
		panel.add(eMinus);

		disableMinusKeys();

		nameWarning = new JLabel("Please enter a name!");
		nameWarning.setHorizontalAlignment(SwingConstants.CENTER);
		nameWarning.setBounds(71, 67, 128, 16);
		panel.add(nameWarning);
		nameWarning.setVisible(false);

		final JPanel difficultyLabel = new JPanel();
		difficultyLabel.setBounds(431, 113, 95, 112);
		panel.add(difficultyLabel);

		final JLabel lblDifficulty = new JLabel("Difficulty:");
		difficultyLabel.add(lblDifficulty);

		// DifficultyListener dListener = new DifficultyListener();

		rdbtnEasy = new JRadioButton("Easy");
		difficultyLabel.add(rdbtnEasy);

		rdbtnMedium = new JRadioButton("Medium");
		difficultyLabel.add(rdbtnMedium);
		rdbtnMedium.setSelected(true);

		rdbtnHard = new JRadioButton("Hard");
		difficultyLabel.add(rdbtnHard);

		difficultyGroup = new ButtonGroup();
		difficultyGroup.add(rdbtnEasy);
		difficultyGroup.add(rdbtnMedium);
		difficultyGroup.add(rdbtnHard);

		// rdbtnMedium.addActionListener(dListener);
		// rdbtnEasy.addActionListener(dListener);
		// rdbtnHard.addActionListener(dListener);

		pointsWarning = new JLabel("Please allocate all points!");
		pointsWarning.setBounds(59, 407, 159, 16);
		panel.add(pointsWarning);

		lblRandomly = new JLabel("Randomize:");
		lblRandomly.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomly.setBounds(278, 311, 95, 16);
		panel.add(lblRandomly);
		pointsWarning.setVisible(false);
	}

	/**
	 * Listener class for adding skill points
	 * @author Bao
	 *
	 */
	public class PlusListener implements ActionListener {

		/** (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			int pScore = 0;
			try {
				pScore = Integer.parseInt(pPoints.getText());
			} catch(NumberFormatException a) {
				System.out.println("Wrong format " + a.getMessage());
			}
			
			int fScore = 0;
			try {
				pScore = Integer.parseInt(fPoints.getText());
			} catch(NumberFormatException b) {
				System.out.println("Wrong format " + b.getMessage());
			}
			
			int tScore = 0;
			try {
				pScore = Integer.parseInt(tPoints.getText());
			} catch(NumberFormatException c) {
				System.out.println("Wrong format " + c.getMessage());
			}
			
			int eScore = 0;
			try {
				pScore = Integer.parseInt(ePoints.getText());
			} catch(NumberFormatException d) {
				System.out.println("Wrong format " + d.getMessage());
			}
			
			int remPoints = 0;
			try {
				remPoints = Integer.parseInt(pointsLabel.getText());
			} catch(NumberFormatException f) {
				System.out.println("Wrong format " + f.getMessage());
			}

			if (remPoints > 0) {
				enablePlusKeys();
				if (((JButton) e.getSource()).equals(pPlus)) {
					pScore++;
					pPoints.setText("" + pScore);
				} else if (((JButton) e.getSource()).equals(fPlus)) {
					fScore++;
					fPoints.setText("" + fScore);
				} else if (((JButton) e.getSource()).equals(tPlus)) {
					tScore++;
					tPoints.setText("" + tScore);
				} else if (((JButton) e.getSource()).equals(ePlus)) {
					eScore++;
					ePoints.setText("" + eScore);
				}

				checkMinus();

				remPoints--;
				pointsLabel.setText("" + remPoints);
			}

			if (remPoints == 0) {
				disablePlusKeys();
			}
		}

		/** (non-Javadoc)
		 * @see java.lang.Object#toString()
		 * @return nothing
		 */
		public String toString() {
			return "";
		}
	}

	/**
	 * Enables or disable minus buttons depending on conditions
	 */
	public void checkMinus() {
		int pScore = Integer.parseInt(pPoints.getText());
		int fScore = Integer.parseInt(fPoints.getText());
		int tScore = Integer.parseInt(tPoints.getText());
		int eScore = Integer.parseInt(ePoints.getText());

		if (pScore > 0) {
			pMinus.setEnabled(true);
		} else {
			pMinus.setEnabled(false);
		}

		if (fScore > 0) {
			fMinus.setEnabled(true);
		} else {
			fMinus.setEnabled(false);
		}

		if (tScore > 0) {
			tMinus.setEnabled(true);
		} else {
			tMinus.setEnabled(false);
		}

		if (eScore > 0) {
			eMinus.setEnabled(true);
		} else {
			eMinus.setEnabled(false);
		}
	}

	/**
	 * Listener class for subtracting skill points
	 * @author Bao
	 *
	 */
	public class MinusListener implements ActionListener {

		/** (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			int pScore = Integer.parseInt(pPoints.getText());
			int fScore = Integer.parseInt(fPoints.getText());
			int tScore = Integer.parseInt(tPoints.getText());
			int eScore = Integer.parseInt(ePoints.getText());
			int remPoints = Integer.parseInt(pointsLabel.getText());

			if (remPoints < 16) {
				if (((JButton) e.getSource()).equals(pMinus)) {
					pScore--;
					pPoints.setText("" + pScore);
				} else if (((JButton) e.getSource()).equals(fMinus)) {
					fScore--;
					fPoints.setText("" + fScore);
				} else if (((JButton) e.getSource()).equals(tMinus)) {
					tScore--;
					tPoints.setText("" + tScore);
				} else if (((JButton) e.getSource()).equals(eMinus)) {
					eScore--;
					ePoints.setText("" + eScore);
				}

				checkMinus();

				remPoints++;
				pointsLabel.setText("" + remPoints);

				enablePlusKeys();
			}

			if (remPoints == 16) {
				disableMinusKeys();
			}
		}

		/** (non-Javadoc)
		 * @see java.lang.Object#toString()
		 * @return nothing
		 */
		public String toString() {
			return "";
		}
	}

	/**
	 * Listener for randomly allocating skill points
	 * @author Bao
	 *
	 */
	public class RandomListener implements ActionListener {
		/**
		 * Random number generator for skill points
		 */
		/**
		 * 
		 */
		private Random rand;

		/**
		 * Allocates random values for skill points
		 */
		/** (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			rand = new Random();
			int pScore = 0;
			int fScore = 0;
			int tScore = 0;
			int eScore = 0;
			int remPoints = 16;
//			@SuppressWarnings("unused")
//			int placeHolder = 16;
			int[] scores = new int[] { pScore, fScore, tScore, eScore };
			// boolean[] done = new boolean[] { false, false, false, false };
			int tally = 0;

			while (remPoints > 0) {
				int count = rand.nextInt(scores.length);
				int score = rand.nextInt((remPoints >> 1) + 2);
				if (tally == 3 && scores[count] == 0) {
					scores[count] = remPoints;
					// done[count] = true;
					remPoints -= remPoints;
				} else if (scores[count] == 0) {
					scores[count] = score;
					// done[count] = true;
					remPoints -= score;
					tally++;
				}

			}

			pPoints.setText("" + scores[0]);
			fPoints.setText("" + scores[1]);
			tPoints.setText("" + scores[2]);
			ePoints.setText("" + scores[3]);
			pointsLabel.setText("" + remPoints);
			disablePlusKeys();
			checkMinus();
		}

		/** (non-Javadoc)
		 * @see java.lang.Object#toString()
		 * @return nothing
		 */
		public String toString() {
			return "";
		}
	}

	/**
	 * 
	 * @return fields
	 */
	public boolean equalsFields() {
		boolean done = true;

		if (textField.getText().equals("")) {
			nameWarning.setVisible(true);
			done = false;
		} else {
			nameWarning.setVisible(false);
		}

		if (Integer.parseInt(pointsLabel.getText()) > 0) {
			pointsWarning.setVisible(true);
			done = false;
		} else {
			pointsWarning.setVisible(false);
		}

		return done;
	}

	/**
	 * Enables all minus buttons
	 */
	public void enableMinusKeys() {
		pMinus.setEnabled(true);
		fMinus.setEnabled(true);
		tMinus.setEnabled(true);
		eMinus.setEnabled(true);
	}

	/**
	 * Disables all minus buttons
	 */
	public void disableMinusKeys() {
		pMinus.setEnabled(false);
		fMinus.setEnabled(false);
		tMinus.setEnabled(false);
		eMinus.setEnabled(false);
	}

	/**
	 * Enables all plus keys
	 */
	public void enablePlusKeys() {
		pPlus.setEnabled(true);
		fPlus.setEnabled(true);
		tPlus.setEnabled(true);
		ePlus.setEnabled(true);
	}

	/**
	 * Disables all plus keys
	 */
	public void disablePlusKeys() {
		pPlus.setEnabled(false);
		fPlus.setEnabled(false);
		tPlus.setEnabled(false);
		ePlus.setEnabled(false);
	}

	/**
	 * @return The panel for the start view 
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @return The "Done" button
	 */
	public JButton getBtnDone() {
		return btnDone;
	}

	/**
	 * Gets fighter points
	 * @return fighter points
	 */
	public int getFPoints() {
		int points = 0;
		try {
			points = Integer.parseInt(fPoints.getText());
		} catch(NumberFormatException e) {
			System.out.println("Wrong format " + e.getMessage());
		}
		return points;
	}

	/**
	 * Gets trader points
	 * @return trader points
	 */
	public int getTPoints() {
		int points = 0;
		try {
			points = Integer.parseInt(tPoints.getText());
		} catch(NumberFormatException e) {
			System.out.println("Wrong format " + e.getMessage());
		}
		return points;
	}

	/**
	 * Gets engineering points
	 * @return engineering points
	 */
	public int getEPoints() {
		int points = 0;
		try {
			points = Integer.parseInt(ePoints.getText());
		} catch(NumberFormatException e) {
			System.out.println("Wrong format " + e.getMessage());
		}
		return points;
	}

	/**
	 * Gets pilot points
	 * @return pilot points
	 */
	public int getPPoints() {
		int points = 0;
		try {
			points = Integer.parseInt(pPoints.getText());
		} catch(NumberFormatException e) {
			System.out.println("Wrong format " + e.getMessage());
		}
		return points;
	}

	/**
	 * @return The textfield
	 */
	public String getTextField() {
		return textField.getText();
	}

	/**
	 * @return the easy radio button
	 */
	public JRadioButton easy() {
		return rdbtnEasy;
	}

	/**
	 * 
	 * @return the medium radio button
	 */
	public JRadioButton medium() {
		return rdbtnMedium;
	}

	/**
	 * 
	 * @return the hard radio button
	 */
	public JRadioButton hard() {
		return rdbtnHard;
	}

	/**
	 * 
	 * @return difficultygroup
	 */
	public ButtonGroup difficultyGroup() {
		return difficultyGroup;
	}
	
	// private class DifficultyListener implements ActionListener {
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	// if (e.getSource() == rdbtnEasy)
	// difficulty = 0;
	// else if (e.getSource() == rdbtnHard)
	// difficulty = 2;
	// else
	// difficulty = 1;
	//
	// }
	//
	// }
	/**
	 * 
	 * @return the difficulty setting as an int
	 */
	public int getDifficulty() {
		if (rdbtnEasy.isSelected()) {
			difficulty = 0;
		} else if (rdbtnMedium.isSelected()) {
			difficulty = 1;
		} else {
			difficulty = 2;
		}
		return difficulty;
	}

	/**
	 * The StartView's toString method
	 * @return string
	 */
	public String toString() {
		return "";
	}
}
