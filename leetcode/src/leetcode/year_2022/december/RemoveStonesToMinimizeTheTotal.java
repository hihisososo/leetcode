package leetcode.year_2022.december;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public static void main(String[] args) {
        System.out.println(new RemoveStonesToMinimizeTheTotal().minStoneSum(new int[]{5, 4, 9}, 2));
        System.out.println(new RemoveStonesToMinimizeTheTotal().minStoneSum(new int[]{4, 3, 6, 7}, 3));
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
        }

        while (k > 0) {
            Integer poll = queue.poll();
            poll -= poll / 2;
            queue.add(poll);
            k--;
        }

        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }

}
