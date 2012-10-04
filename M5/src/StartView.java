import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPanel;


public class StartView {

	private JFrame frame;
	private JTextField textField;
	private JSpinner pSpinner, fSpinner, tSpinner, eSpinner;
	private JLabel pointsLabel;
	private boolean done;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView window = new StartView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 651, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmFile = new JMenuItem("File");
		menuBar.add(mntmFile);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 639, 473);
		frame.getContentPane().add(panel);
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
		lblTrader.setBounds(59, 296, 40, 16);
		panel.add(lblTrader);
		
		JLabel lblEngineer = new JLabel("Engineer");
		lblEngineer.setBounds(59, 344, 54, 16);
		panel.add(lblEngineer);
		
		eSpinner = new JSpinner();
		eSpinner.setBounds(162, 332, 57, 28);
		panel.add(eSpinner);
		
		pSpinner = new JSpinner();
		pSpinner.setBounds(162, 183, 57, 28);
		panel.add(pSpinner);
		
		fSpinner = new JSpinner();
		fSpinner.setBounds(162, 236, 57, 28);
		panel.add(fSpinner);
		
		tSpinner = new JSpinner();
		tSpinner.setBounds(162, 284, 57, 28);
		panel.add(tSpinner);
		
		textField = new JTextField();
		textField.setBounds(28, 38, 191, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPointsLeft = new JLabel("Points left:");
		lblPointsLeft.setBounds(250, 248, 68, 16);
		panel.add(lblPointsLeft);
		
		pointsLabel = new JLabel("16");
		pointsLabel.setBounds(277, 273, 16, 16);
		panel.add(pointsLabel);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(85, 397, 77, 29);
		btnDone.addActionListener(new PressListener());
		panel.add(btnDone);
	}
		
	public class PressListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(done == false) {
				done = true;
			}
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

	public int getPilot() {
		return (Integer) pSpinner.getValue();
	}
	
	public JSpinner getpSpinner() {
		return pSpinner;
	}
	
	public void setpSpinner(JSpinner pSpinner) {
		this.pSpinner = pSpinner;
	}

	public int getFighter() {
		return (Integer) fSpinner.getValue();
	}
	
	public JSpinner getfSpinner() {
		return fSpinner;
	}
	
	public void setfSpinner(JSpinner fSpinner) {
		this.fSpinner = fSpinner;
	}

	public int getTrader() {
		return (Integer) tSpinner.getValue();
	}

	public JSpinner gettSpinner() {
		return tSpinner;
	}
	
	public void settSpinner(JSpinner tSpinner) {
		this.tSpinner = tSpinner;
	}

	public int getEngineer() {
		return (Integer) eSpinner.getValue();
	}
	
	public JSpinner geteSpinner() {
		return eSpinner;
	}
	
	public void seteSpinner(JSpinner eSpinner) {
		this.eSpinner = eSpinner;
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
	
	
}
