package leetcode.year_2023.december;

import java.util.Arrays;

public class BuyTwoChocolates {
    public static void main(String[] args) {
        System.out.println(new BuyTwoChocolates().buyChoco(new int[]{1, 2, 2}, 3));
        System.out.println(new BuyTwoChocolates().buyChoco(new int[]{3, 2, 3}, 3));
    }

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int remain = money - prices[0] - prices[1];
        return remain >= 0 ? remain : money;
    }
}
