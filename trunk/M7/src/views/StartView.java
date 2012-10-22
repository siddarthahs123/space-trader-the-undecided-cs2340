package views;

import java.awt.event.*;
import javax.swing.*;

public class StartView extends MainView {

	private JPanel panel;
	private JButton fPlus, tPlus, ePlus, pPlus, fMinus, tMinus, eMinus, pMinus, btnDone;
	private JLabel fPoints, tPoints, ePoints, pPoints, pointsWarning, nameWarning, pointsLabel;
	private JTextField textField;
	
	public StartView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		
		JLabel lblWhatIsYour = new JLabel("What is your name?");
		lblWhatIsYour.setBounds(78, 20, 121, 16);
		panel.add(lblWhatIsYour);
		
		JLabel lblPleaseAllocatePoints = new JLabel("Please allocate points:");
		lblPleaseAllocatePoints.setBounds(59, 139, 140, 16);
		panel.add(lblPleaseAllocatePoints);
		
		JLabel lblPilot = new JLabel("Pilot");
		lblPilot.setBounds(59, 196, 28, 16);
		panel.add(lblPilot);
		
		JLabel lblFighter = new JLabel("Fighter");
		lblFighter.setBounds(59, 248, 44, 16);
		panel.add(lblFighter);
		
		JLabel lblTrader = new JLabel("Trader");
		lblTrader.setBounds(59, 300, 40, 16);
		panel.add(lblTrader);
		
		JLabel lblEngineer = new JLabel("Engineer");
		lblEngineer.setBounds(59, 353, 54, 16);
		panel.add(lblEngineer);
		
		textField = new JTextField();
		textField.setBounds(42, 38, 191, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPointsLeft = new JLabel("Points left:");
		lblPointsLeft.setBounds(289, 184, 68, 16);
		panel.add(lblPointsLeft);
		
		pointsLabel = new JLabel("16");
		pointsLabel.setBounds(316, 209, 16, 16);
		panel.add(pointsLabel);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(431, 364, 95, 67);
		panel.add(btnDone);
		
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
		nameWarning.setBounds(71, 67, 128, 16);
		panel.add(nameWarning);
		nameWarning.setVisible(false);
		
		JPanel difficultyLabel = new JPanel();
		difficultyLabel.setBounds(431, 113, 95, 112);
		panel.add(difficultyLabel);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		difficultyLabel.add(lblDifficulty);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		difficultyLabel.add(rdbtnEasy);
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		difficultyLabel.add(rdbtnMedium);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		difficultyLabel.add(rdbtnHard);
		
		ButtonGroup difficultyGroup = new ButtonGroup();
		difficultyGroup.add(rdbtnEasy);
		difficultyGroup.add(rdbtnMedium);
		difficultyGroup.add(rdbtnHard);
		
		pointsWarning = new JLabel("Please allocate all points!");
		pointsWarning.setBounds(59, 407, 159, 16);
		panel.add(pointsWarning);
		pointsWarning.setVisible(false);
	}
	
	public class PlusListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			int pScore = Integer.parseInt(pPoints.getText());
			int fScore = Integer.parseInt(fPoints.getText());
			int tScore = Integer.parseInt(tPoints.getText());
			int eScore = Integer.parseInt(ePoints.getText());
			int remPoints = Integer.parseInt(pointsLabel.getText());
			
			if(remPoints > 0) {
				enablePlusKeys();
				if(((JButton)e.getSource()) == pPlus) {
					pScore++;
					pPoints.setText(""+pScore);
				}
				else if(((JButton)e.getSource()) == fPlus) {
					fScore++;
					fPoints.setText(""+fScore);
				}
				else if(((JButton)e.getSource()) == tPlus) {
					tScore++;
					tPoints.setText(""+tScore);
				}
				else if(((JButton)e.getSource()) == ePlus) {
					eScore++;
					ePoints.setText(""+eScore);
				}
				
				if(pScore > 0) {
					pMinus.setEnabled(true);
				}
				else {
					pMinus.setEnabled(false);
				}
				
				if(fScore > 0) {
					fMinus.setEnabled(true);
				}
				else {
					fMinus.setEnabled(false);
				}
				
				if(tScore > 0) {
					tMinus.setEnabled(true);
				}
				else {
					tMinus.setEnabled(false);
				}
				
				if(eScore > 0) {
					eMinus.setEnabled(true);
				}
				else {
					eMinus.setEnabled(false);
				}
				
				remPoints--;
				pointsLabel.setText(""+remPoints);
			}
			
			if(remPoints == 0) {
				disablePlusKeys();
			}
		}
		
	}
	
	public class MinusListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			int pScore = Integer.parseInt(pPoints.getText());
			int fScore = Integer.parseInt(fPoints.getText());
			int tScore = Integer.parseInt(tPoints.getText());
			int eScore = Integer.parseInt(ePoints.getText());
			int remPoints = Integer.parseInt(pointsLabel.getText());
			
			if(remPoints < 16) {
				if(((JButton)e.getSource()) == pMinus) {
					pScore--;
					pPoints.setText(""+pScore);
				}
				else if(((JButton)e.getSource()) == fMinus) {
					fScore--;
					fPoints.setText(""+fScore);
				}
				else if(((JButton)e.getSource()) == tMinus) {
					tScore--;
					tPoints.setText(""+tScore);
				}
				else if(((JButton)e.getSource()) == eMinus) {
					eScore--;
					ePoints.setText(""+eScore);
				}
				
				remPoints++;
				pointsLabel.setText(""+remPoints);
				
				enablePlusKeys();
			}
			
			if(remPoints == 16) {
				disableMinusKeys();
			}
		}
		
	}
	
	public boolean checkFields() {
		boolean done = true;
		
		if(textField.getText().equals("")) {
			nameWarning.setVisible(true);
			done = false;
		}
		else {
			nameWarning.setVisible(false);
		}
		
		if(Integer.parseInt(pointsLabel.getText()) > 0) {
			pointsWarning.setVisible(true);
			done = false;
		}
		else {
			pointsWarning.setVisible(false);
		}
		
		return done;
	}
	
	public void enableMinusKeys() {
		pMinus.setEnabled(true);
		fMinus.setEnabled(true);
		tMinus.setEnabled(true);
		eMinus.setEnabled(true);
	}
	
	public void disableMinusKeys() {
		pMinus.setEnabled(false);
		fMinus.setEnabled(false);
		tMinus.setEnabled(false);
		eMinus.setEnabled(false);
	}
	
	public void enablePlusKeys() {
		pPlus.setEnabled(true);
		fPlus.setEnabled(true);
		tPlus.setEnabled(true);
		ePlus.setEnabled(true);
	}
	
	public void disablePlusKeys() {
		pPlus.setEnabled(false);
		fPlus.setEnabled(false);
		tPlus.setEnabled(false);
		ePlus.setEnabled(false);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public JButton getBtnDone() {
		return btnDone;
	}
	
}
