package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import systems.MainController.BuyListener;
import systems.MainController.FillTank;
import systems.MainController.SaveGameListener;
import systems.MainController.SellListener;
import systems.MainController.MapListener;
import systems.MainController.TitleListener;

import systems.*;


public class TitleView extends JPanel {

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
	 * Create the application.
	 */
	public TitleView(TitleListener titleListener) {
		setBackground(Color.BLACK);
		setBounds(XCORD, YCORD, WIDTH, HEIGHT);
		setLayout(null);
		
		this.addMouseListener(titleListener);
		
		JLabel lblNewLabel = new JLabel("\"And then, the Earth being small, mankind will migrate into space, ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(6, 107, 667, 24);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("and will cross the airless Saharas which separate planet from planet ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(6, 130, 667, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("and sun from sun.\" ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 150, 667, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("-Winwood Reade, THE MARTYRDOM OF MAN");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 178, 667, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("[click to continue]");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(6, 418, 667, 16);
		add(lblNewLabel_4);
		
		
	}
	
	public JPanel getPanel() {
		return this;
	}
}
