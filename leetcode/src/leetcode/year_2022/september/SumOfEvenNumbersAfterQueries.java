package leetcode.year_2022.september;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
        System.out.println(Arrays.toString(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(new int[]{1}, new int[][]{{4, 0}})));
        System.out.println(Arrays.toString(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(new int[]{5,5,4}, new int[][]{{0,1},{1,0},{4,1}})));
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenSum += nums[i];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int index = query[1];
            int val = query[0];
            int afterSum = nums[index] + val;
            if (afterSum % 2 == 0) {
                if (nums[index] % 2 == 0) {
                    evenSum += afterSum - nums[index];
                } else {
                    evenSum += afterSum;
                }
            } else {
                if (nums[index] % 2 == 0) {
                    evenSum -= nums[index];
                }
            }
            nums[index] = afterSum;
            result[i] = evenSum;
        }
        return result;
    }

}
