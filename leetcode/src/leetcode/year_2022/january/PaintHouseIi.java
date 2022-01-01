package leetcode.year_2022.january;

public class PaintHouseIi {
    public static void main(String[] args) {
        //int[][] costs = new int[][]{{1, 5, 3}, {2, 9, 4}};
        int[][] costs = new int[][]{{10, 15, 12, 14, 18, 5}, {5, 12, 18, 13, 15, 8}, {4, 7, 4, 2, 10, 18}, {20, 9, 9, 19, 20, 5}, {10, 15, 10, 15, 16, 20}, {9, 6, 11, 10, 12, 11}, {7, 10, 6, 12, 20, 8}, {3, 4, 4, 18, 10, 2}};
        System.out.println(new PaintHouseIi().minCostII(costs));
    }

    public int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < costs[i].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    min = Math.min(dp[i - 1][k], min);
                }
                dp[i][j] = (min + costs[i][j]);
            }
        }
        int allMin = Integer.MAX_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            allMin = Math.min(allMin, dp[dp.length - 1][i]);
        }
        return allMin;
    }
}
