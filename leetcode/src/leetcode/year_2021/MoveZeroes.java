package leetcode.year_2021;

public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		new MoveZeroes().moveZeroes(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	public void moveZeroes(int[] nums) {

		int nonZeroIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[nonZeroIdx] = nums[i];
				nonZeroIdx++;
			}
		}
		for (int i = nonZeroIdx; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
