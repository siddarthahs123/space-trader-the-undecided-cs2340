package views;

import java.awt.*;

import javax.swing.*;

public class MainView {
	
	JFrame frame;
	
	public MainView() {
		frame = new JFrame("TEST");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(639, 473));
		frame.pack();
	}
	
}
