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

		int maxLengthOfLis = 0;

		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			int lengthOfLis = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > val) {
					lengthOfLis++;
					val = nums[j];
				}
			}

			maxLengthOfLis = Math.max(maxLengthOfLis, lengthOfLis);

		}
		return maxLengthOfLis;
	}
}
