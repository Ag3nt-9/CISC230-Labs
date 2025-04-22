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
		
	}
	
	public boolean isDraw() {
		
	}
	
	public void switchPlayer() {
		
	}
	
	public void resetGame() {
		
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
