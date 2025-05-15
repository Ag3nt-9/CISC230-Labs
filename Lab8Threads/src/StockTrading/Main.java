package StockTrading;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		StockExchange exchange = new StockExchange();
        exchange.addStock(new Stock("AAPL", 150, 100));
        exchange.addStock(new Stock("GOOG", 120, 100));
        exchange.addStock(new Stock("MSFT", 130, 100));

        List<Thread> traders = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new Trader("Trader" + i, exchange));
            traders.add(t);
            t.start();
        }

        for (Thread t : traders) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
	}

}
