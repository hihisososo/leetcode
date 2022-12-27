package leetcode.year_2022.december;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumBagsWithFullCapacityOfRocks {

  public static void main(String[] args) {
    System.out.println(new MaximumBagsWithFullCapacityOfRocks()
        .maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2));
  }

  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int maxBags = 0;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i = 0; i < capacity.length; i++) {
      if (capacity[i] == rocks[i]) {
        maxBags++;
      } else {
        priorityQueue.add(capacity[i] - rocks[i]);
      }
    }
    while (additionalRocks > 0 && !priorityQueue.isEmpty() && priorityQueue.peek() <= additionalRocks) {
      additionalRocks -= priorityQueue.poll();
      maxBags++;
    }
    return maxBags;
  }
}
