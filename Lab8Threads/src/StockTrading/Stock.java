package StockTrading;

public class Stock {
    private final String symbol;
    private double price;
    private int quantity;

    public Stock(String symbol, double price, int quantity) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    public synchronized String getSymbol() {
        return symbol;
    }

    public synchronized double getPrice() {
        return price;
    }

    public synchronized void setPrice(double price) {
        this.price = price;
    }

    public synchronized int getQuantity() {
        return quantity;
    }

    public synchronized void updateQuantity(int delta) {
        this.quantity += delta;
    }
}
