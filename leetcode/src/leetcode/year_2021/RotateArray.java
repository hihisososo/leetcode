package leetcode.year_2021;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -100, 3, 99};
        new RotateArray().rotate(nums, 2);
        Arrays.stream(nums).forEach(System.out::println);

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[getNextIdx(i, nums, k)];
        }
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }

    private int getNextIdx(int idx, int[] nums, int k) {
        if (idx - k < 0) {
            idx = nums.length + (idx - k);
        } else {
            idx = idx - k;
        }
        return idx;
    }
}
