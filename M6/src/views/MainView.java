package views;

import java.awt.*;

import javax.swing.*;

public class MainView {
	
	JFrame frame;
	
	public MainView() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1920,1080));
		frame.pack();
		frame.setVisible(true);
	}
	
}
