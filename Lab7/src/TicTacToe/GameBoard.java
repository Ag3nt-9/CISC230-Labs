package TicTacToe;

import java.util.Arrays;

public class GameBoard {
	private char[][] board;
	private int movesCount;
	public GameBoard() {
		board = new char[3][3];
		movesCount = 0;
	}
	
	public boolean isCellEmpty(int row, int col) {
		return board[row][col] == '\u0000';
	}
	
	public boolean placeMove(int row, int col, char symbol) {
		if (isCellEmpty(row, col)) {
			board[row][col] = symbol;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkWin(char symbol) {
		for (char[] row: board) {
			
		}
	}
	
	public boolean isDraw() {
		for (char[] row: board) {
			for (char cell: row) {
				if (cell == '\u0000') {
					return false;
				}
			}
		}
		return true;
	}
	
	public void resetBoard() {
		board = new char[3][3];
	}
	
	public char[][] getBoard() {
		final char[][] result = new char[board.length][];
	    for (int i = 0; i < board.length; i++) {
	        result[i] = Arrays.copyOf(board[i], board[i].length);
	    }
	    return result;

	}
}
