package leetcode.year_2023.december;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(1, 6, 3));
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(2, 6, 7));
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(3, 2, 6));
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(4, 2, 6));
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int n, int k, int target) {
        int modulo = 1000000007;
        int[][] targetDp = new int[n + 1][target + 1];

        for (int i = 1; i <= k && i < targetDp[1].length; i++) {
            targetDp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int diceMin = i * 1;
            int diceMax = i * k;
            for (int j = Math.min(diceMax, targetDp[i].length - 1); j >= diceMin; j--) {
                int prevSum = 0;
                for (int l = Math.max(j - k, 0); l < j; l++) {
                    prevSum = (prevSum + targetDp[i - 1][l]) % modulo;
                }
                targetDp[i][j] = prevSum;
            }
        }
        return targetDp[n][target];
    }
}
