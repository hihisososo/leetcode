package leetcode;

import java.util.Arrays;

public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(new MajorityElement().majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		Arrays.sort(nums);
		int majorCnt = nums.length / 2;
		int cnt = 1;
		int lastNumber = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != lastNumber) {
				cnt = 1;
				lastNumber = nums[i];
			} else {
				cnt++;
				if (cnt > majorCnt) {
					return nums[i];
				}
			}
		}

		return -1;
	}
}
