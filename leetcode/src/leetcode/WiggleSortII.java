package leetcode;

import java.util.Arrays;

public class WiggleSortII {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 5, 6};
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        int minIdx = 0;
        int maxidx = nums.length / 2;
        if (nums.length % 2 != 0) {
            maxidx++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = copyNums[minIdx];
                minIdx++;
            } else {
                nums[i] = copyNums[maxidx];
                maxidx++;
            }
        }
    }
}
