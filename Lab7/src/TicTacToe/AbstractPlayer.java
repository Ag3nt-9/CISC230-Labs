package TicTacToe;

public abstract class AbstractPlayer implements Player {
	protected String name;
	protected char symbol;
	public AbstractPlayer(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public char getSymbol() {
		return symbol;
	}
}
