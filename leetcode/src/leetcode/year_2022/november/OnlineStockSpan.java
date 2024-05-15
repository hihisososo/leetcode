package leetcode.year_2022.november;

import common.Pair;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan {
    public static void main(String[] args) {
        OnlineStockSpan stockSpanner = new OnlineStockSpan();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80);  // return 1
        stockSpanner.next(60);  // return 1
        stockSpanner.next(70);  // return 2
        stockSpanner.next(60);  // return 1
        stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        stockSpanner.next(85);  // return 6

        stockSpanner = new OnlineStockSpan();
        stockSpanner.next(32); // return 1
        stockSpanner.next(82);  // return 1
        stockSpanner.next(73);  // return 1
        stockSpanner.next(99);  // return 2
        stockSpanner.next(91);  // return 1
    }

    private List<Pair<Integer, Integer>> stockPrices;

    public OnlineStockSpan() {
        this.stockPrices = new ArrayList<>();
    }

    public int next(int price) {
        if (!stockPrices.isEmpty()) {
            Pair<Integer, Integer> last = stockPrices.get(stockPrices.size() - 1);
            if (last.getKey() <= price) {
                stockPrices.remove(stockPrices.size() - 1);
                stockPrices.add(new Pair<>(price, last.getValue() + 1));
            } else {
                stockPrices.add(new Pair<>(price, 1));
            }
        } else {
            stockPrices.add(new Pair<>(price, 1));
        }
        int consecutive = 0;
        int maxConsecutive = 1;
        for (int i = stockPrices.size() - 1; i >= 0; i--) {
            if (stockPrices.get(i).getKey() <= price) {
                consecutive += stockPrices.get(i).getValue();
            } else {
                maxConsecutive = Math.max(maxConsecutive, consecutive);
                return maxConsecutive;
            }
        }
        maxConsecutive = Math.max(maxConsecutive, consecutive);
        return maxConsecutive;
    }
}
