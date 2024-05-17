package leetcode.year_2021;

import java.util.Arrays;
import java.util.HashMap;

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

        HashMap<String, Integer> memo = new HashMap<>();
        findCost(costs, 0, -1, 0, memo);

        int color0 = memo.get(costs.length + "/" + 0);
        int color1 = memo.get(costs.length + "/" + 1);
        int color2 = memo.get(costs.length + "/" + 2);
        return Math.min(color2, Math.min(color0, color1));
    }

    private void findCost(int[][] costs, int costIdx, int prevIdx, int sum, HashMap<String, Integer> memo) {
        if (costIdx == costs.length) {
            String key = costIdx + "/" + prevIdx;
            memo.putIfAbsent(key, sum);
            memo.put(key, Math.min(memo.get(key), sum));
            return;
        }
        String key = costIdx + "/" + prevIdx;
        if (memo.containsKey(key)) {
            if (memo.get(key) > sum) {
                memo.put(key, sum);
                for (int i = 0; i < costs[costIdx].length; i++) {
                    if (i == prevIdx) {
                        continue;
                    }
                    findCost(costs, costIdx + 1, i, sum + costs[costIdx][i], memo);
                }
            }
        } else {
            memo.put(key, sum);
            for (int i = 0; i < costs[costIdx].length; i++) {
                if (i == prevIdx) {
                    continue;
                }
                findCost(costs, costIdx + 1, i, sum + costs[costIdx][i], memo);
            }
        }
    }

}
