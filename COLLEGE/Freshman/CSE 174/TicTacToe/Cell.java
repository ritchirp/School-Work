/**
 * Implements the logic of a cell in a Tic-Tac-Toe game. This class is needed by
 * the TicTacToe class.
 * 
 * @author Ann Sobel
 **/
public class Cell {
	/** This value means empty **/
	public static final int EMPTY = 0;
	/** This value means X **/
	public static final int X = 1;
	/** This value means O **/
	public static final int O = 2;

	private int c;

	/**
	 * constructs an empty cell, the content of which will be Cell.EMPTY
	 **/
	public Cell() {
		c = EMPTY;
	}

	/**
	 * sets the content of this cell
	 * 
	 * @param value
	 *            the desired content of the cell, either Cell.X, Cell.O, or
	 *            Cell.EMPTY
	 **/
	public void setCell(int value) {
		c = value;
	}

	/**
	 * gets the content of this cell
	 * 
	 * @returns an int containing the content of the cell, either Cell.X,
	 *          Cell.O, or Cell.EMPTY
	 **/
	public int getCell() {
		return c;
	}

	/**
	 * indicates whether the parameter contains the same content as this Cell.
	 * 
	 * @param c1
	 *            a cell
	 * @return true if c1 contains the same content as this Cell, false
	 *         otherwise
	 **/
	public boolean equals(Cell cl) {
		return this.c == cl.c;
	}

	/**
	 * returns the contents of a given cell as a String
	 * 
	 * @return a String containing X, O, or a space
	 **/
	public String toString() {
		if (c == X)
			return "X";
		else if (c == O)
			return "O";
		else
			return " ";
	}
}
