package leetcode.year_2023.april;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{1}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(stones[i]);
        }
        while (priorityQueue.size() > 1) {
            int y = priorityQueue.poll();
            int x = priorityQueue.poll();
            if (x != y) {
                priorityQueue.add(y - x);
            }
        }
        if (priorityQueue.isEmpty()) {
            return 0;
        }
        return priorityQueue.poll();
    }
}
