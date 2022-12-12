package leetcode.year_2022.december;

public class ClimbStairs {
	public int climbStairs(int n) {
		int[] result = new int[n+1];
		result[0] = 1;
		for (int i = 0; i < result.length; i++) {
			int score = 0;
			if (i > 1) {
				score = result[i - 2] + result[i - 1];
			} else if (i == 1) {
				score = result[i - 1];
			} else {
				score = 1;
			}

			result[i] = score;
		}

		return result[result.length - 1];
	}
}
