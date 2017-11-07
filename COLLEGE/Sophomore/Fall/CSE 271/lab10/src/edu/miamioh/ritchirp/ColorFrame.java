package edu.miamioh.ritchirp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ColorFrame extends JFrame {
	
	// Instance variables
	private JMenuBar menuBar;
	private JMenu colorMenu;
	private JMenuItem red;
	private JMenuItem green;
	private JMenuItem blue;
	private JPanel panel;
	public static int WIDTH = 400;
	public static int HEIGHT = 400;
	
	/**
	 * Creates a ColorFrame
	 */
	public ColorFrame(){
		createComponents();
		createPanel();
		
		add(panel);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Creates the components and adds the action listener to 
	 * menu items
	 */
	private void createComponents(){
		menuBar = new JMenuBar();
		colorMenu = new JMenu("Color");
		red = new JMenuItem("Red");
		green = new JMenuItem("Green");
		blue = new JMenuItem("Blue");
		
		ActionListener menuListener = new ColorMenuListener();
		red.addActionListener(menuListener);
		green.addActionListener(menuListener);
		blue.addActionListener(menuListener);
		
		menuBar.add(colorMenu);
		colorMenu.add(red);
		colorMenu.add(green);
		colorMenu.add(blue);
	}
	
	/**
	 * Creates the panel and adds the menubar and mouseListener
	 */
	private void createPanel(){
		panel = new JPanel();
		MouseListener clickListener = new MouseColorListener();
		panel.add(menuBar);
		panel.addMouseListener(clickListener);
	}
	
	/**
	 * Determines the source of the action and changes the background color accordingly
	 * @author Robbie
	 *
	 */
	public class ColorMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource().equals(red))
				panel.setBackground(Color.red);
			else if(arg0.getSource().equals(blue))
				panel.setBackground(Color.BLUE);
			else if(arg0.getSource().equals(green))
				panel.setBackground(Color.GREEN);
		}
		
	}
	
	/**
	 * Rotates the background colors on a mouse click
	 * @author Robbie
	 *
	 */
	public class MouseColorListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			Color old = panel.getBackground();
			if(old.equals(Color.RED))
				panel.setBackground(Color.GREEN);
			else if(old.equals(Color.GREEN))
				panel.setBackground(Color.BLUE);
			else if(old.equals(Color.BLUE))
				panel.setBackground(Color.RED);
			
		}
		// Do nothings
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	// Opens a ColorFrame
	public static void main(String[] args){
		ColorFrame frame = new ColorFrame();
	}
}
