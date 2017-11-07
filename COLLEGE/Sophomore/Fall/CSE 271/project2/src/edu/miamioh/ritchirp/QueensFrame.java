package edu.miamioh.ritchirp;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class QueensFrame extends JFrame {
	//Instance variables
	private BoardPanel boardPanel;
	private JPanel buttonPanel;
	private JPanel labelPanel;
	private JButton solutionButton;
	private JButton tipButton;
	private JLabel warningLabel;
	
	public QueensFrame(){
		super();
		this.setLayout(new BorderLayout());
		
		//adding components/panels
		boardPanel = new BoardPanel();
		this.add(boardPanel, BorderLayout.CENTER);
		createButtonPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);
		labelPanel = new JPanel();
		warningLabel = new JLabel(" ");
		labelPanel.add(warningLabel);
		warningLabel.setMinimumSize(new Dimension(400, 40));
		this.add(labelPanel, BorderLayout.NORTH);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 460);
	}
	/*
	 * Creates the panel with the tip and solution buttons
	 */
	private void createButtonPanel(){
		buttonPanel = new JPanel();
		tipButton = new JButton("Tip");
		solutionButton = new JButton("Check Solution");
		ActionListener listener = new ButtonListener();
		
		tipButton.addActionListener(listener);
		solutionButton.addActionListener(listener);
		Tile[] tiles = boardPanel.getTiles();
		for(int i=0; i<tiles.length; i++){
			tiles[i].addActionListener(listener);
		}
		
		buttonPanel.add(solutionButton);
		buttonPanel.add(tipButton);
	}
	
	/*
	 * Handles checking for tips, solutions, and the warning label
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boardPanel.clear();
			if(arg0.getSource().equals(solutionButton)){
				if(boardPanel.checkSolution())  warningLabel.setText(" ");
				else  warningLabel.setText("The red queens are in conflict.");
			}
			else if(arg0.getSource().equals(tipButton)){
				if(boardPanel.hint()) warningLabel.setText(" ");
				else warningLabel.setText("There are either eight queens or no safe tiles.");
			}
		}
	}
	
	public static void main(String[] args){
		QueensFrame frame = new QueensFrame();
	}
}
