package edu.miamioh.ritchirp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class OlympicRings extends JComponent {
	
	private static final int DIAMETER  = 100; 
	
	// Draws the rings in position
	public void paintComponent(Graphics g){
		drawRing(50, 50, Color.BLUE, g);
		drawRing(150, 50, Color.BLACK, g);
		drawRing(250, 50, Color.RED, g);
		drawRing(100, 100, Color.YELLOW, g);
		drawRing(200, 100, Color.GREEN, g);
	}
	
	// Draws a ring of a given position and color
	public void drawRing(int x, int y, Color c, Graphics g){
		g.setColor(c);
		g.drawOval(x, y, DIAMETER, DIAMETER);
	}
	
	// Creates and displays the frame with the rings
	public static void main(String[] args){
		JFrame frame = new JFrame("Olympic Rings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.add(new OlympicRings());
		
		frame.setVisible(true);
	}

}
