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
			movesCount += 1;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        
        return false;
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
		movesCount = 0;
	}
	
	public char[][] getBoard() {
		final char[][] result = new char[board.length][];
	    for (int i = 0; i < board.length; i++) {
	        result[i] = Arrays.copyOf(board[i], board[i].length);
	    }
	    return result;

	}
}
