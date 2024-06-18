package leetcode.year_2024.june;

import common.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        System.out.println(new MostProfitAssigningWork().maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}));
        System.out.println(new MostProfitAssigningWork().maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25}));
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> diffProfits = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            diffProfits.add(new Pair<>(difficulty[i], profit[i]));
        }
        Collections.sort(diffProfits, (o1, o2) -> o2.getValue() - o1.getValue());

        int maxProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            for (int j = 0; j < diffProfits.size(); j++) {
                if (worker[i] >= diffProfits.get(j).getKey()) {
                    maxProfit += diffProfits.get(j).getValue();
                    break;
                }
            }
        }
        return maxProfit;
    }
}
