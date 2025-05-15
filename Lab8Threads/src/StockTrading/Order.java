package StockTrading;

public class Order {
    enum Type { BUY, SELL }
    final Trader trader;
    final String symbol;
    int quantity;
    final double price;
    final Type type;

    public Order(Trader trader, String symbol, int quantity, double price, Type type) {
        this.trader = trader;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }
}
