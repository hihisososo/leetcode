package leetcode.year_2022.october;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{1, 2, 1}));
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(new int[]{2, 6, 2, 5, 4, 15, 1}));
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int result = findTriangle(nums, nums[i], i - 1);
            if (result > 0) {
                return result;
            }
        }
        return 0;
    }

    private int findTriangle(int[] nums, int num, int end) {
        int left = end - 1;
        int right = end;
        while (left >= 0) {
            if (num < nums[left] + nums[right]) {
                return nums[left] + nums[right] + num;
            } else {
                int leftMoveDiff = left == 0 ? Integer.MAX_VALUE : nums[left] - nums[left - 1];
                int rightMoveDiff = nums[right] - nums[right - 1];
                if (leftMoveDiff >= rightMoveDiff) {
                    left--;
                } else {
                    right--;
                }
            }
        }
        return -1;
    }
}
