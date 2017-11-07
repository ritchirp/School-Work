package edu.miamioh.ritchirp;

import javax.swing.JButton;

public class Tile extends JButton {
	// instance variables
	private int row;
	private int column;
	private boolean hasQueen;
	
	/**
	 * Creates a new tile with the given coordinates
	 * @param row the row on the board of the tile
	 * @param column the column on the board of the tile
	 */
	public Tile(int row, int column){
		super();
		this.row = row;
		this.column = column;
		hasQueen = false;
	}
	/**
	 * @return Whether or not a queen occupies the tile
	 */
	public boolean hasQueen(){
		return hasQueen;
	}
	/**
	 * Sets whether or not the tile has a queen
	 * @param queen whether or not the tile has a queen
	 */
	public void setQueen(boolean queen){
		hasQueen = queen;
	}
	/**
	 * @return the row of the tile
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * @return the column of the tile
	 */
	public int getColumn(){
		return this.column;
	}
}
