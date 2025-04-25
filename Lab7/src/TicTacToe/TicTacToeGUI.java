package TicTacToe;

import javax.swing.*;

public class TicTacToeGUI {
	private static JFrame frame = new JFrame("Tic Tac Toe");
	private static JButton[][] buttons;
	private static JLabel statusLabel;
	private static JButton resetButton;
	public TicTacToeGUI(GameController controller) {
		
	}
	
	public static void main(String[] args) {
		resetButton = new JButton("Reset");
		resetButton.setBounds(300, 510, 200, 50);
		
		frame.add(resetButton);
		
		frame.setSize(500, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public void updateBoard(char[][] board) {
		
	}
	
	public static void showWinner(String playerName) {
		statusLabel = new JLabel(playerName + " Wins!");
		statusLabel.setBounds(200, 250, 300, 100);
		frame.add(statusLabel);
		
	}
	
	public void showDraw() {
		
	}
	
	public void clearBoard() {
		
	}
	
	public void showMessage(String message) {
		
	}
}
