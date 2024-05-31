package leetcode.year_2024.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumberIii {

  public static void main(String[] args) {
    System.out
        .println(Arrays.toString(new SingleNumberIii().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    System.out.println(Arrays.toString(new SingleNumberIii().singleNumber(new int[]{-1, 0})));
    System.out.println(Arrays.toString(new SingleNumberIii().singleNumber(new int[]{0, 1})));
  }

  public int[] singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        set.remove(nums[i]);
      } else {
        set.add(nums[i]);
      }
    }

    int[] result = new int[set.size()];
    Iterator<Integer> iter = set.iterator();
    int idx = 0;
    while (iter.hasNext()) {
      result[idx++] = iter.next();
    }
    return result;
  }
}
