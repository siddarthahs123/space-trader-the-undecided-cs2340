package views;

import java.awt.*;
import javax.swing.*;

public class UniverseView extends MainView {
	
	private JPanel panel;
	
	public UniverseView() {
		panel = new JPanel();
		panel.setBounds(6, 6, 679, 473);
		panel.setLayout(null);
		
		
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
}
