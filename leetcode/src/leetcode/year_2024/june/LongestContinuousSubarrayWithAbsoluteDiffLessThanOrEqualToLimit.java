package leetcode.year_2024.june;

import java.util.Collections;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        int left = 0;
        int right = 0;
        int longest = 0;
        minQueue.add(nums[right]);
        maxQueue.add(nums[right]);

        while (true) {
            int diff = Math.abs(maxQueue.peek() - minQueue.peek());
            if (diff <= limit) {
                longest = Math.max(longest, right - left + 1);
                right++;
                if (right == nums.length) {
                    break;
                }
                minQueue.add(nums[right]);
                maxQueue.add(nums[right]);
            } else {
                minQueue.remove(nums[left]);
                maxQueue.remove(nums[left]);
                left++;
                if (left == nums.length) {
                    break;
                }

            }
        }

        return longest;

    }
}
