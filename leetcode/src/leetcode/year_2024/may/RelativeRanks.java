package leetcode.year_2024.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks {

  public static void main(String[] args) {
    System.out
        .println(Arrays.toString(new RelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    System.out
        .println(Arrays.toString(new RelativeRanks().findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
  }

  public String[] findRelativeRanks(int[] score) {

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < score.length; i++) {
      pq.add(score[i]);
    }

    Map<Integer, String> map = new HashMap<>();
    int rank = 1;
    while (!pq.isEmpty()) {

      map.put(pq.poll(), getRankMessage(rank));
      rank++;
    }

    String[] ranks = new String[score.length];
    for (int i = 0; i < score.length; i++) {
      ranks[i] = map.get(score[i]);
    }
    return ranks;
  }

  private String getRankMessage(int rank) {
    if (rank == 1) {
      return "Gold Medal";
    } else if (rank == 2) {
      return "Silver Medal";
    } else if (rank == 3) {
      return "Bronze Medal";
    } else {
      return String.valueOf(rank);
    }
  }

}
