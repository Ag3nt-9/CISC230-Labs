package TicTacToe;

public class GameLogic {
	private Player currentPlayer, player1, player2;
	private GameBoard board = new GameBoard();
	private boolean playerWon = false;
	
	public GameLogic() {
		player1 = new HumanPlayer("X-Human", 'X');
		player2 = new HumanPlayer("O-Person", 'O');
		startGame();
	}
	
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
		playerWon = board.checkWin(currentPlayer.getSymbol());
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
		board.resetBoard();
		playerWon = false;
		currentPlayer = player1;
	}
	
	public boolean hasPlayerWon() {
		return playerWon;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public GameBoard getGameBoard() {
		return board;
	}
}
