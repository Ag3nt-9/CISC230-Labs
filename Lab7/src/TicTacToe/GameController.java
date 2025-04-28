package TicTacToe;

public class GameController {
	private GameLogic gameLogic = new GameLogic();
	private TicTacToeGUI view = new TicTacToeGUI(this);
	
	public void onCellClicked(int row, int col) {
		gameLogic.makeMove(row, col);
		updateView();
		if (gameLogic.checkWin()) {
			TicTacToeGUI.showWinner(gameLogic.getCurrentPlayer().getName());
		} else if (gameLogic.isDraw()) {
			view.showDraw();
		}
	}
	
	public void onResetClicked() {
		gameLogic.resetGame();
		view.clearBoard();
	}
	
	private void updateView() {
		view.updateBoard(gameLogic.getGameBoard().getBoard());
	}
}
