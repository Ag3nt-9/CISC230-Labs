package TicTacToe;

public class GameLogic {
	private Player currentPlayer, player1, player2;
	private GameBoard board;
	
	public void startGame() {
		currentPlayer = player1;
	}
	
	public boolean makeMove(int row, int col) {
		if (board.isCellEmpty(row, col)) {
			return board.placeMove(row, col, currentPlayer.getSymbol());
		} else {
			return false;
		}
	}
	
	public boolean checkWin() {
		return board.checkWin(currentPlayer.getSymbol());
	}
	
	public boolean isDraw() {
		return board.isDraw();
	}
	
	public void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}
	
	public void resetGame() {
		
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
