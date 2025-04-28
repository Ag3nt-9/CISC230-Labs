package TicTacToe;

import javax.swing.*;

public class TicTacToeGUI {
	private static JFrame frame = new JFrame("Tic Tac Toe");
	private static JButton[][] buttons = new JButton[3][3];
	private static JLabel statusLabel;
	private static JButton resetButton;
	public TicTacToeGUI(GameController controller) {
		
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].setBounds(100 + 100*j, 150 + 100*i, 100, 100);
				buttons[i][j].addActionListener(null);
				frame.add(buttons[i][j]);
			}
		}

		
		resetButton = new JButton("Reset");
		resetButton.setBounds(300, 510, 200, 50);
		
		frame.add(resetButton);
		
		frame.setSize(500, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public void updateBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				buttons[i][j].setText(String.valueOf(board[i][j]));
			}
		}
	}
	
	public static void showWinner(String playerName) {
		statusLabel = new JLabel(playerName + " Wins!");
		statusLabel.setBounds(200, 250, 300, 100);
		frame.add(statusLabel);
		
	}
	
	public void showDraw() {
		statusLabel = new JLabel("Its a Draw!");
		statusLabel.setBounds(200, 250, 300, 100);
		frame.add(statusLabel);
	}
	
	public void clearBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setText("");
			}
		}
	}
	
	public void showMessage(String message) {
		
	}
}
