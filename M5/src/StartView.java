import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class StartView {

	private JFrame frmSpaceTrader;
	private JTextField textField;
	private JLabel pointsLabel, pPoints, fPoints, tPoints, ePoints;
	private boolean done;
	private JButton pPlus, fPlus, tPlus, ePlus, pMinus, fMinus, tMinus, eMinus;

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
		
		frmSpaceTrader = new JFrame();
		frmSpaceTrader.setTitle("Space Trader");
		frmSpaceTrader.setBounds(100, 100, 651, 529);
		frmSpaceTrader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSpaceTrader.setJMenuBar(menuBar);
		
		JMenuItem mntmFile = new JMenuItem("File");
		menuBar.add(mntmFile);
		frmSpaceTrader.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(6, 6, 639, 473);
		frmSpaceTrader.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWhatIsYour = new JLabel("What is your name?");
		lblWhatIsYour.setBounds(59, 11, 121, 16);
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
		textField.setBounds(28, 38, 191, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPointsLeft = new JLabel("Points left:");
		lblPointsLeft.setBounds(311, 248, 68, 16);
		panel.add(lblPointsLeft);
		
		pointsLabel = new JLabel("16");
		pointsLabel.setBounds(338, 273, 16, 16);
		panel.add(pointsLabel);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(103, 408, 77, 29);
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
	}
		
	public class PressListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(done == false) {
				done = true;
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
		return frmSpaceTrader;
	}

	public void setFrame(JFrame frame) {
		this.frmSpaceTrader = frame;
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
}
