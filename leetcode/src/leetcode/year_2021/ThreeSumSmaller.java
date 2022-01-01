package leetcode.year_2021;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 1, 3};
        int target = 2;
        System.out.println(new ThreeSumSmaller().threeSumSmaller(nums, target));
    }

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        return findThreeSum(nums, target);
    }

    private int findThreeSum(int[] nums, int target) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += getTwoSum(nums, i, target - nums[i]);
        }
        return cnt;
    }

    private int getTwoSum(int[] nums, int i, int target) {
        int cnt = 0;
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                cnt += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return cnt;
    }
}
