package leetcode.year_2024.june;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubArrays {

  public static void main(String[] args) {
    System.out
        .println(new CountNumberOfNiceSubArrays().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    System.out.println(new CountNumberOfNiceSubArrays().numberOfSubarrays(new int[]{2, 4, 6}, 1));
    System.out.println(new CountNumberOfNiceSubArrays()
        .numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
  }

  public int numberOfSubarrays(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = nums[i] % 2;
    }

    int result = 0;
    int prefixSum = 0;
    Map<Integer, Integer> indexCnt = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      if (prefixSum == k) {
        result++;
        result += indexCnt.getOrDefault(0, 0);
      } else if (prefixSum > k) {
        result += indexCnt.getOrDefault(prefixSum - k, 0);
      }
      indexCnt.put(prefixSum, indexCnt.getOrDefault(prefixSum, 0) + 1);

    }
    return result;
  }

}
