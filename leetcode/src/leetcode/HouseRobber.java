package leetcode;

public class HouseRobber {
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 9, 3, 1 };
		System.out.println(new HouseRobber().rob(nums));
	}

	public int rob(int[] nums) {
		int maxMoney = 0;
		for (int i = 0; i < nums.length; i++) {
			maxMoney = Math.max(maxMoney, getMaxRob(nums, nums[i], i));
		}
		return maxMoney;
	}

	private int getMaxRob(int[] nums, int money, int curIdx) {
		int maxMoney = money;
		for (int i = curIdx + 2; i < nums.length; i++) {
			maxMoney = Math.max(maxMoney, getMaxRob(nums, money + nums[i], i));
		}
		return maxMoney;
	}
}
