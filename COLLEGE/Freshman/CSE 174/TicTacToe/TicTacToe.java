/**
 * Implements the logic of making moves in a tic-tac-toe game.
 * 
 * @author Ann Sobel, Norm Krumpe
 **/
public class TicTacToe {
	/** This value indicates that X has won the game **/
	public static final int X_WINS = 0;
	/** This value indicates that O has won the game **/
	public static final int O_WINS = 1;
	/** This value indicates that the game has ended in a tie **/
	public static final int DRAW = 2;
	/** This value indicates that the game is in progress **/
	public static final int IN_PROGRESS = 3;

	private Cell[][] board;

	/**
	 * Constructs a tic-tac-toe board with no moves yet made.
	 **/
	public TicTacToe() {
		// allocate the board
		board = new Cell[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = new Cell();
		// initialize the board
		reset();
	}

	/**
	 * Resets all 9 squares on the board
	 **/
	public void reset() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j].setCell(Cell.EMPTY);
	}

	/**
	 * Makes a move in the indicated location.
	 * 
	 * @param player
	 *            the player making the move (either Cell.X or Cell.O)
	 * @param row
	 *            the zero-based row where the move is to be made
	 * @param col
	 *            the zero-based column where the move is to be made
	 **/
	public void makeMove(int player, int row, int col) {
		if (player != Cell.X && player != Cell.O)
			throw new IllegalArgumentException("Invalid player value: "
					+ player);
		else if (row < 0 || row > 2)
			throw new IllegalArgumentException("Illegal row value: " + row);
		else if (col < 0 || col > 2)
			throw new IllegalArgumentException("Illegal column value: " + col);
		else
			board[row][col].setCell(player);
	}

	/**
	 * indicates whether a given position is empty for a move
	 * 
	 * @param row
	 *            the zero-based row
	 * @param col
	 *            the zero-based column
	 * @return true if the position is vacant, false otherwise
	 **/
	public boolean isEmpty(int row, int col) {
		return board[row][col].getCell() == Cell.EMPTY;
	}

	/**
	 * indicates the current status of the game
	 * 
	 * @return TicTacToe.X_WINS if X has won,<br>
	 *         TicTacToe.O_WINS if O has won, <br>
	 *         TicTacToe.DRAW if game ended in tie, <br>
	 *         TicTacToe.IN_PROGRESS if game is in progress
	 **/
	public int getStatus() {

		// test for a row of all X's or O's
		for (int i = 0; i < 3; i++)
			if (board[i][0].equals(board[i][1])
					&& board[i][1].equals(board[i][2]))
				if (board[i][0].getCell() == Cell.X)
					return X_WINS;
				else if (board[i][0].getCell() == Cell.O)
					return O_WINS;

		// test for a column of all X's or O's
		for (int i = 0; i < 3; i++)
			if (board[0][i].equals(board[1][i])
					&& board[1][i].equals(board[2][i]))
				if (board[0][i].getCell() == Cell.X)
					return X_WINS;
				else if (board[0][i].getCell() == Cell.O)
					return O_WINS;

		// test for a diagonal of all X's or O's
		if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])
				|| board[0][2].equals(board[1][1])
				&& board[1][1].equals(board[2][0]))
			if (board[1][1].getCell() == Cell.X)
				return X_WINS;
			else if (board[1][1].getCell() == Cell.O)
				return O_WINS;

		// test for the existence of a EMPTY space
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j].getCell() == Cell.EMPTY)
					return IN_PROGRESS;

		// if we hit this point in the method, we've ruled out a win
		// or IN_PROGRESS
		return DRAW;
	}

	/**
	 * Returns the number of moves made in the game so far.
	 * 
	 * @return number of occupied cells in the grid
	 */
	public int moveCount() {
		int playedCellCount = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j].getCell() != Cell.EMPTY)
					playedCellCount++;
		return playedCellCount;
	}

	/**
	 * returns a String representation of the game board, including current move
	 * progress.
	 * 
	 * @return a String containing the game board and current moves
	 **/
	public String toString() {
		return "=============\n| " + board[0][0].toString() + " | "
				+ board[0][1].toString() + " | " + board[0][2].toString()
				+ " |\n=============\n| " + board[1][0].toString() + " | "
				+ board[1][1].toString() + " | " + board[1][2].toString()
				+ " |\n=============\n| " + board[2][0].toString() + " | "
				+ board[2][1].toString() + " | " + board[2][2].toString()
				+ " |\n=============\n";
	}
}
