package leetcode.year_2022.october;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(1, 6, 3));
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(2, 6, 7));
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(2, 2, 7));
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int n, int k, int target) {
        if (n == 1) {
            if (k >= target) {
                return 1;
            } else {
                return 0;
            }
        }
        int[] prevNums = new int[target];
        int[] currNums = new int[target];
        for (int i = 0; i < k && i < target; i++) {
            prevNums[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < target; j++) {
                int prevLeftIdx = j - k < 0 ? 0 : j - k;
                int sum = 0;
                for (int l = prevLeftIdx; l < j; l++) {
                    sum = ((sum + prevNums[l]) % 1000000007);
                }
                currNums[j] = sum;
            }
            prevNums = currNums;
            currNums = new int[target];
        }
        return prevNums[target - 1];
    }

}
