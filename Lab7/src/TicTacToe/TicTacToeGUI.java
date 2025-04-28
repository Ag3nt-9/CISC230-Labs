package TicTacToe;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToeGUI {
	private JFrame frame = new JFrame("Tic Tac Toe");
	private JButton[][] buttons = new JButton[3][3];
	private JLabel statusLabel;
	private JButton resetButton;
	private GameController controller;
	public TicTacToeGUI(GameController controller) {
		this.controller = controller;
	}

	public void generateWindow() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton("");
				buttons[i][j].setBounds(100 + 100*j, 150 + 100*i, 100, 100);
				final int row = i;
				final int col = j;
				buttons[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						controller.onCellClicked(row, col);
					}
				});
				frame.add(buttons[i][j]);
			}
		}

		
		resetButton = new JButton("Reset");
		resetButton.setBounds(300, 510, 200, 50);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onResetClicked();
			}
		});
		
		statusLabel = new JLabel("");
		statusLabel.setBounds(120, 70, 300, 100);
		statusLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
		frame.add(statusLabel);


		
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
	
	public void showWinner(String playerName) {
		statusLabel.setText(playerName+" Wins!");
	}
	
	public void showDraw() {
		statusLabel.setText("It's a Draw!");
	}
	
	public void clearBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setText("");
			}
		}
		statusLabel.setText("");
	}
	
	public void showMessage(String message) {
		
	}
}
