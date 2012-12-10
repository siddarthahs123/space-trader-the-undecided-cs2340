/**
 * package that contains this class
 */
package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import systems.MainController.IntroListener;

/**
 * Screen for starting the game
 * 
 * @author Bao
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IntroView extends JPanel {

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
	@SuppressWarnings("unused")
	private static final int BUTX = 264;

	/**
	 * Y coordinate for new game button
	 */
	@SuppressWarnings("unused")
	private static final int NEW_BUTY = 161;

	/**
	 * Y coordinate for new game button
	 */
	@SuppressWarnings("unused")
	private static final int LD_BUTY = 231;

	/**
	 * Y coordinate for new game button
	 */
	@SuppressWarnings("unused")
	private static final int CON_BUTY = 302;

	/**
	 * Width for button
	 */
	@SuppressWarnings("unused")
	private static final int BUT_WIDTH = 117;

	/**
	 * Height for button
	 */

	@SuppressWarnings("unused")
	private static final int BUT_HEIGHT = 29;
	

	//private BufferedImage image;

	private ImageIcon image1, title1, newgame, loadgame, contgame;
	
	private JLabel newLabel, loadLabel, contLabel;
	
	/**
	 * Constructor
	 */
	public IntroView(IntroListener introListener) {
		
		/*File file = new File ("src/views/startscreen.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		image1 = new ImageIcon(getClass().getResource("/views/startscreen.png"));
		title1 = new ImageIcon(getClass().getResource("/views/title1.png"));
		
		newgame = new ImageIcon(getClass().getResource("/views/newgame.png"));
		loadgame = new ImageIcon(getClass().getResource("/views/loadgame.png"));
		contgame = new ImageIcon(getClass().getResource("/views/continue.png"));
		
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setLayout(null);
		
		newLabel = new JLabel("");
		newLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newLabel.setIcon(newgame);
		newLabel.setBounds(248, 247, 170, 36);
		newLabel.addMouseListener(introListener);
		add(newLabel);
		
		loadLabel = new JLabel("");
		loadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadLabel.setIcon(loadgame);
		loadLabel.setBounds(248, 295, 170, 36);
		loadLabel.addMouseListener(introListener);
		add(loadLabel);
		
		contLabel = new JLabel("");
		contLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contLabel.setIcon(contgame);
		contLabel.setBounds(248, 343, 170, 36);
		contLabel.addMouseListener(introListener);
		
		add(contLabel);
	}

	/**
	 * Returns the panel for intro screen
	 * 
	 * @return intro screen panel
	 */
	public JPanel getPanel() {
		return this;
	}

	/**
	 * The toString method
	 * 
	 * @return nothing
	 */
	public String toString() {
		return "";
	}
	
	public JLabel getNewGame() {
		return newLabel;
	}
	
	public JLabel getLoadGame() {
		return loadLabel;
	}
	
	public JLabel getContGame() {
		return contLabel;
	}
	
	/**
	 * paints bg
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(image, 0, 0, null);
		image1.paintIcon(this, g, 0, 0);
		title1.paintIcon(this, g, 140, 20);
	}
}
