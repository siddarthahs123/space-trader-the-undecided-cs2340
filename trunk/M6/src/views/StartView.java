package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;


public class StartView extends MainView {

	private JTextField textField;
	private JLabel pointsLabel, pPoints, fPoints, tPoints, ePoints, nameWarning, pointsWarning;
	private boolean done;
	private JButton pPlus, fPlus, tPlus, ePlus, pMinus, fMinus, tMinus, eMinus;
	private JRadioButton rdbtnEasy, rdbtnMedium, rdbtnHard;
	private ButtonGroup difficultyGroup;

	/**
	 * Create the application.
	 */
	public StartView() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		done = false;
		

		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//panel.setBounds(6, 6, frame.getWidth(), frame.getHeight());
		panel.setBounds(6, 6, 679, 473);
		frame.getContentPane().add(panel);
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
		lblPointsLeft.setBounds(311, 248, 68, 16);
		panel.add(lblPointsLeft);
		
		pointsLabel = new JLabel("16");
		pointsLabel.setBounds(338, 273, 16, 16);
		panel.add(pointsLabel);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(489, 358, 77, 29);
		btnDone.addActionListener(new PressListener());
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
		
		pPlus = new JButton("+");
		pPlus.setBounds(211, 184, 16, 16);
		pPlus.addActionListener(new PlusListener(pPoints));
		panel.add(pPlus);
		
		pMinus = new JButton("-");
		pMinus.setBounds(211, 209, 16, 16);
		pMinus.addActionListener(new MinusListener(pPoints));
		panel.add(pMinus);
		
		fPlus = new JButton("+");
		fPlus.setBounds(211, 237, 16, 16);
		fPlus.addActionListener(new PlusListener(fPoints));
		panel.add(fPlus);
		
		fMinus = new JButton("-");
		fMinus.setBounds(211, 261, 16, 16);
		fMinus.addActionListener(new MinusListener(fPoints));
		panel.add(fMinus);
		
		tPlus = new JButton("+");
		tPlus.setBounds(211, 289, 16, 16);
		tPlus.addActionListener(new PlusListener(tPoints));
		panel.add(tPlus);
		
		tMinus = new JButton("-");
		tMinus.setBounds(211, 312, 16, 16);
		tMinus.addActionListener(new MinusListener(tPoints));
		panel.add(tMinus);
		
		ePlus = new JButton("+");
		ePlus.setBounds(211, 340, 16, 16);
		ePlus.addActionListener(new PlusListener(ePoints));
		panel.add(ePlus);
		
		eMinus = new JButton("-");
		eMinus.setBounds(211, 364, 16, 16);
		eMinus.addActionListener(new MinusListener(ePoints));
		panel.add(eMinus);
		
		nameWarning = new JLabel("Please enter a name!");
		nameWarning.setBounds(71, 67, 128, 16);
		panel.add(nameWarning);
		nameWarning.setVisible(false);
		
		JPanel difficultyLabel = new JPanel();
		difficultyLabel.setBounds(431, 113, 95, 112);
		panel.add(difficultyLabel);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		difficultyLabel.add(lblDifficulty);
		
		rdbtnEasy = new JRadioButton("Easy");
		difficultyLabel.add(rdbtnEasy);
		
		rdbtnMedium = new JRadioButton("Medium");
		difficultyLabel.add(rdbtnMedium);
		
		rdbtnHard = new JRadioButton("Hard");
		difficultyLabel.add(rdbtnHard);
		
		difficultyGroup = new ButtonGroup();
		difficultyGroup.add(rdbtnEasy);
		difficultyGroup.add(rdbtnMedium);
		difficultyGroup.add(rdbtnHard);
		
		pointsWarning = new JLabel("Please allocate all points!");
		pointsWarning.setBounds(59, 407, 159, 16);
		panel.add(pointsWarning);
		pointsWarning.setVisible(false);
		
		
		
		
		frame.setVisible(true);
	}
		
	public class PressListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(done == false && !(textField.getText().equals("")) && Integer.parseInt(pointsLabel.getText()) == 0) {
				done = true;
				nameWarning.setVisible(false);
				pointsWarning.setVisible(false);
			}
			else if(textField.getText().equals("") && Integer.parseInt(pointsLabel.getText()) > 0) {
				nameWarning.setVisible(true);
				pointsWarning.setVisible(true);
			}
			else if(!(textField.getText().equals("")) && Integer.parseInt(pointsLabel.getText()) > 0) {
				nameWarning.setVisible(false);
				pointsWarning.setVisible(true);
			}
			else if(textField.getText().equals("") && Integer.parseInt(pointsLabel.getText()) == 0) {
				nameWarning.setVisible(true);
				pointsWarning.setVisible(false);
			}
		}
	}
	
	public class PlusListener implements ActionListener {
		JLabel label;
		
		public PlusListener(JLabel label) {
			this.label = label;
		}
		
		public void actionPerformed(ActionEvent e) {
			label.setText((Integer.parseInt(label.getText())+1)+"");
		}
	}
	
	public class MinusListener implements ActionListener {
		JLabel label;
		
		public MinusListener(JLabel label) {
			this.label = label;
		}
		
		public void actionPerformed(ActionEvent e) {
			label.setText((Integer.parseInt(label.getText())-1)+"");
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String getName() {
		return textField.getText();
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getPointsLabel() {
		return pointsLabel;
	}

	public void setPointsLabel(int pointsRem) {
		this.pointsLabel.setText(""+pointsRem);
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public JLabel getpPoints() {
		return pPoints;
	}

	public void setpPoints(JLabel pPoints) {
		this.pPoints = pPoints;
	}

	public JLabel getfPoints() {
		return fPoints;
	}

	public void setfPoints(JLabel fPoints) {
		this.fPoints = fPoints;
	}

	public JLabel gettPoints() {
		return tPoints;
	}

	public void settPoints(JLabel tPoints) {
		this.tPoints = tPoints;
	}

	public JLabel getePoints() {
		return ePoints;
	}

	public void setePoints(JLabel ePoints) {
		this.ePoints = ePoints;
	}

	public JButton getpPlus() {
		return pPlus;
	}

	public JButton getfPlus() {
		return fPlus;
	}

	public JButton gettPlus() {
		return tPlus;
	}

	public JButton getePlus() {
		return ePlus;
	}

	public JButton getpMinus() {
		return pMinus;
	}

	public JButton getfMinus() {
		return fMinus;
	}

	public JButton gettMinus() {
		return tMinus;
	}

	public JButton geteMinus() {
		return eMinus;
	}
	
	public JRadioButton easy() {
		return rdbtnEasy;
	}
	
	public JRadioButton medium() {
		return rdbtnMedium;
	}
	
	public JRadioButton hard() {
		return rdbtnHard;
	}
	
	public ButtonGroup difficultyGroup() {
		return difficultyGroup;
	}
}
