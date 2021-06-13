package leetcode;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int result = new CoinChange().coinChange(coins, 1);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < dp.length)
                dp[coins[i]] = 1;
        }


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] <= 0) {
                    break;
                }
                if (dp[i - coins[j]] == -1) {
                    continue;
                }

                if (dp[i] == -1) {
                    dp[i] = dp[i - coins[j]] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount];
    }

}
