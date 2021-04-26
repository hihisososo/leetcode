package leetcode;

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 4, 2, 2 };
		System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
	}

	public int findDuplicate(int[] nums) {
		int[] numsCnt = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			numsCnt[nums[i]]++;
			if (numsCnt[nums[i]] > 1) {
				return nums[i];
			}
		}
		return -1;
	}
}
