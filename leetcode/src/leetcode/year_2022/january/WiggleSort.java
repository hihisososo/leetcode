package leetcode.year_2022.january;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 2, 1, 6, 4};
        new WiggleSort().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int midIdx = 0;
        if (nums.length % 2 == 0) {
            midIdx = nums.length / 2;
        } else {
            midIdx = nums.length / 2 + 1;
        }

        int leftIdx = 0;
        int rightIdx = midIdx;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = copy[leftIdx++];
            } else {
                nums[i] = copy[rightIdx++];
            }
        }
    }
}
