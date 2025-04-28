package TicTacToe;

public class GameController {
	private GameLogic gameLogic = new GameLogic();
	private static TicTacToeGUI view;
	
	public GameController() {
		view = new TicTacToeGUI(this);
	}
	
	public static void main(String[] args) {
		new GameController();
		view.generateWindow();
	}
	
	public void onCellClicked(int row, int col) {
		if (gameLogic.makeMove(row, col) && !gameLogic.hasPlayerWon()) {
			updateView();
			gameLogic.switchPlayer();
		}
	}
	
	public void onResetClicked() {
		gameLogic.resetGame();
		view.clearBoard();
	}
	
	private void updateView() {
		view.updateBoard(gameLogic.getGameBoard().getBoard());
		if (gameLogic.checkWin()) {
			view.showWinner(gameLogic.getCurrentPlayer().getName());
		} else if (gameLogic.isDraw()) {
			view.showDraw();
		}

	}
}
