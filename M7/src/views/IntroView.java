/**
 * package that contains this class
 */
package views;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Screen for starting the game
 * 
 * @author Bao
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IntroView extends JPanel {

	/**
	 * JPanel
	 */
	private JPanel panel = null;

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
	 * X coordinate for button
	 */
	private static final int BUTX = 264;

	/**
	 * Y coordinate for new game button
	 */
	private static final int NEW_BUTY = 161;

	/**
	 * Y coordinate for new game button
	 */
	private static final int LD_BUTY = 231;

	/**
	 * Y coordinate for new game button
	 */
	private static final int CON_BUTY = 302;

	/**
	 * Width for button
	 */
	private static final int BUT_WIDTH = 117;

	/**
	 * Height for button
	 */

	private static final int BUT_HEIGHT = 29;
	
	/**
	 * Buttons for new/load/continue game
	 */
	private final JButton btnNewGame, btnLoadGame, btnContinueGame;

	/**
	 * Constructor
	 */
	public IntroView() {
		panel = new JPanel();
		panel.setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		panel.setLayout(null);

		btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(BUTX, NEW_BUTY, BUT_WIDTH, BUT_HEIGHT);
		panel.add(btnNewGame);

		btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBounds(BUTX, LD_BUTY, BUT_WIDTH, BUT_HEIGHT);
		panel.add(btnLoadGame);

		btnContinueGame = new JButton("Continue");
		btnContinueGame.setBounds(BUTX, CON_BUTY, BUT_WIDTH, BUT_HEIGHT);
		panel.add(btnContinueGame);
		btnContinueGame.setEnabled(false);
	}

	/**
	 * Returns the panel for intro screen
	 * 
	 * @return intro screen panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Returns new game button
	 * 
	 * @return new game button
	 */
	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	/**
	 * Returns load game button
	 * 
	 * @return load game button
	 */
	public JButton getBtnLoadGame() {
		return btnLoadGame;
	}

	/**
	 * Returns continue game button
	 * 
	 * @return continue game button
	 */
	public JButton getBtnContinueGame() {
		return btnContinueGame;
	}

	/**
	 * The toString method
	 * 
	 * @return nothing
	 */
	public String toString() {
		return "";
	}
}
