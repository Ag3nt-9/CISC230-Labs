package StockTrading;

import java.util.Random;

public class Trader implements Runnable {
    private final String name;
    private final StockExchange exchange;
    private final Random rand = new Random();

    public Trader(String name, StockExchange exchange) {
        this.name = name;
        this.exchange = exchange;
    }

    public void confirmTrade(String symbol, int quantity, double price) {
        System.out.println(name + " traded " + quantity + " of " + symbol + " at $" + price);
    }

    @Override
    public void run() {
        String[] symbols = {"AAPL", "GOOG", "MSFT"};
        for (int i = 0; i < 10; i++) {
            String symbol = symbols[rand.nextInt(symbols.length)];
            int quantity = rand.nextInt(10) + 1;
            double price = 100 + rand.nextInt(50);
            Order.Type type = rand.nextBoolean() ? Order.Type.BUY : Order.Type.SELL;
            Order order = new Order(this, symbol, quantity, price, type);
            exchange.placeOrder(order);
            try {
                Thread.sleep(rand.nextInt(300));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
