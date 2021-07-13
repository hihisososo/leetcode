package leetcode;

public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println(new BestTimeToBuyAndSellStockIi().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, getMaxProfit(prices, i));
        }
        return maxProfit;
    }

    private int getMaxProfit(int[] prices, int idx) {
        boolean isBuy = true;
        int myStockPrice = prices[idx];
        int profit = 0;
        for (int i = idx + 1; i < prices.length; i++) {
            if (isBuy) {
                if (myStockPrice < prices[i]) {
                    int maxIdx = getMaxContinueIncreaseIdx(prices, i);
                    i = maxIdx;
                    profit += prices[i] - myStockPrice;
                    isBuy = false;
                }
            } else {
                if (prices[i - 1] > prices[i]) {
                    int minIdx = getMaxContinueDecreaseIdx(prices, i);
                    i = minIdx;
                    isBuy = true;
                    myStockPrice = prices[i];
                }
            }
        }
        return profit;
    }

    private int getMaxContinueDecreaseIdx(int[] prices, int i) {
        int price = prices[i];
        int idx = i;
        while (prices.length > idx && prices[idx] <= price) {
            price = prices[idx];
            idx++;
        }
        return idx - 1;
    }

    private int getMaxContinueIncreaseIdx(int[] prices, int i) {
        int price = prices[i];
        int idx = i;
        while (prices.length > idx && prices[idx] >= price) {
            price = prices[idx];
            idx++;
        }
        return idx - 1;
    }

}
