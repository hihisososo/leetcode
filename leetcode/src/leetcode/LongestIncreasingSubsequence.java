package leetcode;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 2, 3 };
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) { 
			return 1;
		}

		int[] maxLength = new int[nums.length];
		for (int i = 0; i < maxLength.length; i++) {
			maxLength[i] = Integer.MIN_VALUE;
		}

		int maxLengthOfLis = 0;
		for (int i = 0; i < nums.length; i++) {
			maxLengthOfLis = Math.max(maxLengthOfLis, findLIS(i, nums, 1, maxLength));
		}

		return maxLengthOfLis;
	}

	private int findLIS(int idx, int[] nums, int length, int[] maxLength) {
		if (length <= maxLength[idx]) {
			return 0;
		}
		maxLength[idx] = length;

		int maxLIS = length;
		for (int i = idx; i < nums.length; i++) {
			if (nums[idx] < nums[i]) {
				maxLIS = Math.max(maxLIS, findLIS(i, nums, length + 1, maxLength));
			}
		}
		return maxLIS;
	}
}
