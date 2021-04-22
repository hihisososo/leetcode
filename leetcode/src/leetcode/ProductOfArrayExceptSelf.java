package leetcode;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public int[] productExceptSelf(int[] nums) {
		if (nums.length == 0) {
			return null;
		} else if (nums.length == 1) {
			return new int[nums[0]];
		}

		int[] products = new int[nums.length];
		int zeroIdx = -1;

		int productAll = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (zeroIdx == -1) {
					zeroIdx = i;
				} else {
					return products;
				}
			} else {
				productAll = productAll * nums[i];
			}
		}

		if (zeroIdx >= 0) {
			calcProductContainZeroIdx(nums, products, zeroIdx, productAll);
		} else {
			calcProductNotContainZeroIdx(nums, products, zeroIdx, productAll);
		}

		return products;
	}

	private void calcProductNotContainZeroIdx(int[] nums, int[] products, int zeroIdx, int productAll) {
		for (int i = 0; i < products.length; i++) {
			products[i] = productAll / nums[i];
		}
	}

	private void calcProductContainZeroIdx(int[] nums, int[] products, int zeroIdx, int productAll) {
		for (int i = 0; i < products.length; i++) {
			if (i == zeroIdx) {
				products[i] = productAll;
			} else {
				products[i] = 0;
			}
		}
	}
}
