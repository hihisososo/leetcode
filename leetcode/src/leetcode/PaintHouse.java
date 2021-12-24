package leetcode;

import java.util.*;

public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = new int[][]{{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}};
        System.out.println(new PaintHouse().minCost(costs));
    }

    public int minCost(int[][] costs) {
        if (costs.length == 1) {
            Arrays.sort(costs[0]);
            return costs[0][0];
        }

        HashMap<Integer, Integer> memo = new HashMap<>();
        findCost(costs, 0, -1, 0, memo);

        return memo.get(costs.length - 1);
    }


    private void findCost(int[][] costs, int costIdx, int prevIdx, int sum, HashMap<Integer, Integer> memo) {
        if (costIdx == costs.length) {
            return;
        }
        for (int i = 0; i < costs[costIdx].length; i++) {
            if (i != prevIdx) {
                int newSum = sum + costs[costIdx][i];
                memo.putIfAbsent(costIdx, newSum);
                if (memo.get(costIdx) > newSum) {
                    memo.put(costIdx, newSum);
                    findCost(costs, costIdx + 1, i, newSum, memo);
                } else {
                    if (memo.get(costIdx) > newSum - 20) {
                        findCost(costs, costIdx + 1, i, newSum, memo);
                    }
                }

            }
        }
    }
}
