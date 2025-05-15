package StockTrading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockExchange {
    private final Map<String, Stock> stocks = new ConcurrentHashMap<>();
    private final List<Order> buyOrders = Collections.synchronizedList(new ArrayList<>());
    private final List<Order> sellOrders = Collections.synchronizedList(new ArrayList<>());

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public void placeOrder(Order order) {
        synchronized (this) {
            if (order.type == Order.Type.BUY) {
                buyOrders.add(order);
                buyOrders.sort((a, b) -> Double.compare(b.price, a.price));
            } else {
                sellOrders.add(order);
                sellOrders.sort(Comparator.comparingDouble(a -> a.price));
            }
            matchOrders(order.symbol);
        }
    }

    private void matchOrders(String symbol) {
        synchronized (this) {
            Iterator<Order> buyIter = buyOrders.iterator();
            while (buyIter.hasNext()) {
                Order buy = buyIter.next();
                if (!buy.symbol.equals(symbol)) continue;

                Iterator<Order> sellIter = sellOrders.iterator();
                while (sellIter.hasNext()) {
                    Order sell = sellIter.next();
                    if (!sell.symbol.equals(symbol)) continue;

                    if (buy.price >= sell.price) {
                        int tradedQuantity = Math.min(buy.quantity, sell.quantity);
                        Stock stock = stocks.get(symbol);
                        synchronized (stock) {
                            stock.updateQuantity(-tradedQuantity);
                        }
                        buy.trader.confirmTrade(symbol, tradedQuantity, sell.price);
                        sell.trader.confirmTrade(symbol, tradedQuantity, sell.price);

                        buy.quantity -= tradedQuantity;
                        sell.quantity -= tradedQuantity;

                        if (buy.quantity == 0) buyIter.remove();
                        if (sell.quantity == 0) sellIter.remove();

                        break; // After each match, re-sort and continue
                    }
                }
            }
        }
    }
}
