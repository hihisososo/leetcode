package leetcode.year_2021;

public class PerfectSquares {
	public static void main(String[] args) {
		int n = 48;
		System.out.println(new PerfectSquares().numSquares(n));
	}

	public int numSquares(int n) {
		int[] dp = new int[n + 1];

		if (n <= 3) {
			return n;
		}
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				min = Math.min(min, dp[i - j * j] + 1);
			}
			dp[i] = Math.min(dp[i - 1] + 1, min);

		}
		return dp[n];

	}

}
