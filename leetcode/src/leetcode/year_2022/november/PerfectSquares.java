package leetcode.year_2022.november;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
    }

    public int numSquares(int n) {
        List<Integer> perfects = new ArrayList<>();

        int pow = 1;
        while (pow * pow <= n) {
            perfects.add(pow * pow);
            pow++;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            int min = i;
            for (int j = 0; j < perfects.size(); j++) {
                if (i - perfects.get(j) < 0) {
                    break;
                }
                min = Math.min(min, dp[i - perfects.get(j)] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}