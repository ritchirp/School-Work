package edu.miamioh.ritchirp;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	// instance variables
	private int queenCount;
	private Tile[] tiles;
	
	public BoardPanel(){
		super();
		this.setLayout(new GridLayout(8,8));
		tiles = new Tile[64];
		createButtons();
		queenCount = 0;
	}
	
	/*
	 * Creates all 64 tiles of the board and adds them to the panel
	 */
	private void createButtons(){
		ActionListener listener = new AddQueenListener();
		for(int i=1; i<=8; i++){
			for(int j=1; j<=8; j++){
				
				Tile tile = new Tile(i,j);
				int position = (i-1)*8 + j;
				tile.addActionListener(listener);
				this.add(tile);
				tiles[position-1] = tile;
				
				if((i-j)%2==0){
					tile.setBackground(Color.BLACK);
					tile.setForeground(Color.WHITE);
				}
			}
		}
	}
	/**
	 * Checks whether the parameterized tile is attacked by other tiles
	 * @param q the tile in question
	 * @return true if q is attacked, false if not
	 */
	public boolean isAttacked(Tile q){
		int row1 = q.getRow();
		int col1 = q.getColumn();
		for(int i=0; i<tiles.length; i++){
			int row2 = tiles[i].getRow();
			int col2 = tiles[i].getColumn();
			if(tiles[i].hasQueen() && !q.equals(tiles[i]) && 
					(row1==row2 || col1==col2 || diagonalAttack(row1,col1,row2,col2))){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the board is currently in a solved/partially solved state
	 * Turns any attacking queens red.
	 * @return true if no queens are attacking each other, false otherwise
	 */
	public boolean checkSolution(){
		int count = 0;
		for(int i=0; i<tiles.length; i++){
			if(tiles[i].hasQueen() && isAttacked(tiles[i])){
				tiles[i].setForeground(Color.RED);
				count++;
			}
		}
		return count==0;
	}
	
	/**
	 * Creates a list of the safe tiles on the board and turns a random safe tile green
	 * @return whether or not there is a safe tile
	 */
	public boolean hint(){
		if(queenCount<8){
			ArrayList<Tile> safeTiles = new ArrayList<Tile>();
			for(int i=0; i<tiles.length; i++){
				if(!tiles[i].hasQueen() && !isAttacked(tiles[i])){
					safeTiles.add(tiles[i]);
				}
			}
			if(safeTiles.size()==0) return false; 
			int rand = (int) (Math.random()*(safeTiles.size()));
			safeTiles.get(rand).setForeground(Color.GREEN);
			safeTiles.get(rand).setText("Q");
			return true;
		}
		return false;
	}
	
	/**
	 * Removes any formatting from tips/warnings
	 */
	public void clear(){
		for(int i=0; i<tiles.length; i++){
			Tile tile = tiles[i];
			if(!tile.hasQueen()){
				tile.setText("");
			}
			
			if((tile.getRow()-tile.getColumn())%2==0){
				tile.setForeground(Color.WHITE);
			}
			else{
				tile.setForeground(Color.BLACK);
			}
		}
	}
	
	public Tile[] getTiles(){
		return this.tiles;
	}
	
	/**
	 * solution taken from lecture notes
	 * @param row1
	 * @param col1
	 * @param row2
	 * @param col2
	 * @return Whether or not the queens at the given positions are attacking each other diagonally
	 */
	public boolean diagonalAttack(int row1, int col1, int row2, int col2){
		double slope = (row2-row1)/(col2-col1);
		if(slope==1 || slope==-1)
			return true;
		return false;
	}
	
	/**
	 * Handles adding/removing queens from tiles
	 * @author Robbie
	 *
	 */
	private class AddQueenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Tile tile = (Tile) e.getSource();
			if(tile.hasQueen()){
				tile.setText("");
				tile.setQueen(false);
				queenCount--;
			}
			else{
				if(queenCount<8){
					tile.setText("Q");
					tile.setQueen(true);
					queenCount++;
				}
				else return;
			}
		}
		
	}
}
