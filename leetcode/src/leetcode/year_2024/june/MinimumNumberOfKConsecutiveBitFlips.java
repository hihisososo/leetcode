package leetcode.year_2024.june;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfKConsecutiveBitFlips {

  public static void main(String[] args) {
    System.out
        .println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{0, 1, 0}, 1));
    System.out
        .println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{1, 1, 0}, 2));
    System.out
        .println(
            new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{0, 1, 0, 0, 1, 0}, 4));
  }

  public int minKBitFlips(int[] nums, int k) {
    int flips = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int flipCnt = flip(nums, i, k, map);
        if (flipCnt < 0) {
          return -1;
        } else {
          i = i + k - 1;
          flips += flipCnt;
        }
      }
    }
    return flips;
  }

  private int flip(int[] nums, int idx, int k, Map<Integer, Integer> map) {
    map.clear();
    int flipCnt = 0;
    int lastFlipIdx = Integer.MAX_VALUE;
    if (idx + k - 1 >= nums.length) {
      return -1;
    }
    for (int i = idx; i < idx + k; i++) {
      if (i - k >= 0) {
        flipCnt -= map.getOrDefault(i - k, 0);
      }
      if (flipCnt % 2 + nums[i] == 1) {
        flipCnt++;
        map.put(i, 1);
        lastFlipIdx = i;
      }
      nums[i] = 0;
    }

    int result = flipCnt + 1;
    for (int i = lastFlipIdx; i < lastFlipIdx + k; i++) {
      if (i - k >= 0) {
        flipCnt -= map.getOrDefault(i - k, 0);
      }
      if (i >= nums.length) {
        return -1;
      }
      nums[i] = (nums[i] + flipCnt % 2) % 2;
    }

    for (int i = idx; i < idx + k; i++) {
      nums[i] = 1;
    }

    return result;

  }

}
