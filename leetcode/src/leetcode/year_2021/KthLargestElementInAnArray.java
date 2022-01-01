package leetcode.year_2021;

public class KthLargestElementInAnArray {
	static int OFFSET = 10000;

	public int findKthLargest(int[] nums, int k) {
		int[] sorted = new int[20002];
		for (int i = 0; i < nums.length; i++) {
			int normalizeIdx = nums[i] + OFFSET;
			sorted[normalizeIdx]++;
		}

		int elementCnt = 0;
		for (int i = sorted.length - 1; i >= 0; i--) {
			elementCnt += sorted[i];
			if (elementCnt >= k) {
				int orgNum = i - OFFSET;
				return orgNum;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
		System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, 2));
		;
	}
}
