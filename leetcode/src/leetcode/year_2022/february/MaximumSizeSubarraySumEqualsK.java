package leetcode.year_2022.february;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, -1, 5, -2, 3};int k = 3;
//        int[] nums = new int[]{-2, -1, 2, 1};int k = 1;
        int[] nums = new int[]{-1};
        int k = -1;
        System.out.println(new MaximumSizeSubarraySumEqualsK().maxSubArrayLen(nums, k));
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        int maxLen = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (prefixSum.containsKey(sums[i] - k)) {
                maxLen = Math.max(maxLen, i - prefixSum.get(sums[i] - k));
            }
            prefixSum.putIfAbsent(sums[i], i);
        }
        return maxLen;
    }
}
