package leetcode.year_2022.april;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int length = new RemoveElement().removeElement(nums, 3);
        System.out.println(Arrays.toString(nums));
        System.out.println(length);
    }

    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[idx++] = nums[i];
        }
        return idx;
    }
}
