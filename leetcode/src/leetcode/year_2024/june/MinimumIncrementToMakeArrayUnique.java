package leetcode.year_2024.june;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                int diff = nums[i - 1] - nums[i] + 1;
                nums[i] += diff;
                cnt += diff;
            }
        }
        return cnt;
    }
}
