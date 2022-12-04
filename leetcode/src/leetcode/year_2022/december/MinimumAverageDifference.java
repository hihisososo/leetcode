package leetcode.year_2022.december;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MinimumAverageDifference {
    public static void main(String[] args) throws IOException {
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(new int[]{0}));
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(new int[]{1}));
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(new int[]{0, 0, 0, 0, 0}));
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(new int[]{1, 3, 5, 9, 1, 3, 5, 9}));
        int[] intArr = Files.readAllLines(Paths.get("C:\\Users\\PC_1\\Desktop\\test.txt")).stream()
                .mapToInt(s -> Integer.parseInt(s))
                .toArray();
        System.out.println(new MinimumAverageDifference().minimumAverageDifference(intArr));
    }

    public int minimumAverageDifference(int[] nums) {
        long allSum = Arrays.stream(nums).mapToLong(Long::new).sum();
        long leftSum = 0;
        int minIdx = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            long left = leftSum / (i + 1);
            long right = i == nums.length - 1 ? 0 : (allSum - leftSum) / (nums.length - 1 - i);
            if (min > Math.abs(left - right)) {
                min = Math.abs(left - right);
                minIdx = i;
            }
        }
        return minIdx;
    }
}
