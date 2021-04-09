package leetcode;

public class HouseRobber {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 1 };
		System.out.println(new HouseRobber().rob(nums));
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] maxMoneys = new int[nums.length];
		maxMoneys[0] = nums[0];
		maxMoneys[1] = nums[1];

		for (int i = 2; i < nums.length; i++) {
			int maxMoney = Math.max((i == 2) ? 0 : maxMoneys[i - 3], maxMoneys[i - 2]);
			maxMoneys[i] = nums[i] + maxMoney;
		}

		int maxMoneyResult = 0;
		for(int i=0;i<maxMoneys.length;i++){
			maxMoneyResult = Math.max(maxMoneyResult, maxMoneys[i]);
		}

		return maxMoneyResult;
	}

}
