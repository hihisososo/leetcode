package leetcode.year_2024.may;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {

  public static void main(String[] args) {
    System.out.println(
        new MaximizeHappinessOfSelectedChildren().maximumHappinessSum(new int[]{1, 2, 3}, 2));
    System.out.println(
        new MaximizeHappinessOfSelectedChildren().maximumHappinessSum(new int[]{1, 1, 1, 1}, 2));
    System.out.println(
        new MaximizeHappinessOfSelectedChildren().maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
  }

  public long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);
    long sum = 0;
    int turn = 0;
    for (int i = happiness.length - 1; i >= 0 && k > turn; i--) {
      if (happiness[i] - turn <= 0) {
        break;
      }
      sum += happiness[i] - turn;
      turn++;
    }
    return sum;
  }
}
