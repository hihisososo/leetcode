package leetcode.year_2022.january;

public class PaintFence {
    public static void main(String[] args) {
        System.out.println(new PaintFence().numWays(1, 1));
    }

    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }

        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n - 1];
    }
}
