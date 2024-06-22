package leetcode.year_2024.june;

import java.util.ArrayList;
import java.util.List;

public class GrumpyBookstoreOwner {

  public static void main(String[] args) {
    System.out.println(new GrumpyBookstoreOwner()
        .maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    System.out.println(new GrumpyBookstoreOwner().maxSatisfied(new int[]{1}, new int[]{0}, 1));
  }

  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int sum = 0;
    List<Integer> ones = new ArrayList<>();
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 0) {
        sum += customers[i];
      } else {
        ones.add(i);
      }
    }

    int result = sum;
    for (int i = 0; i < ones.size(); i++) {
      int subSum = 0;
      int idx = i;
      while (idx < ones.size() && ones.get(i) + minutes - 1 >= ones.get(idx)) {
        subSum += customers[ones.get(idx)];
        idx++;
      }

      result = Math.max(result, sum + subSum);
    }
    return result;
  }
}
