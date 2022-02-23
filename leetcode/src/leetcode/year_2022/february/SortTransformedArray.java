package leetcode.year_2022.february;

import java.util.Arrays;

public class SortTransformedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -2, 2, 4};int a = 1;int b = 3;int c = 5;
//        int[] nums = new int[]{-4, -2, 2, 4};int a = -1;int b = 3;int c = 5;
        System.out.println(Arrays.toString(new SortTransformedArray().sortTransformedArray(nums, a, b, c)));
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 1) {
            return new int[]{calc(nums[0], a, b, c)};
        }
        int[] result = new int[nums.length];

        double mid = -b / (2 * a);
        if (a < 0) {
            int maxIdx = 0;
            double minVal = Double.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(mid - nums[i]) < minVal) {
                    maxIdx = i;
                    minVal = Math.abs(mid - nums[i]);
                }
            }
            int resultIdx = nums.length;
            result[--resultIdx] = calc(nums[maxIdx], a, b, c);
            int leftIdx = maxIdx - 1;
            int rightIdx = maxIdx + 1;
            int leftVal = leftIdx > 0 ? calc(nums[leftIdx], a, b, c) : Integer.MIN_VALUE;
            int rightVal = rightIdx < nums.length ? calc(nums[rightIdx], a, b, c) : Integer.MIN_VALUE;
            while (leftIdx >= 0 || rightIdx < nums.length) {
                if (leftVal >= rightVal) {
                    result[--resultIdx] = leftVal;
                    leftIdx--;
                    leftVal = leftIdx < 0 ? Integer.MIN_VALUE : calc(nums[leftIdx], a, b, c);
                } else {
                    result[--resultIdx] = rightVal;
                    rightIdx++;
                    rightVal = rightIdx >= nums.length ? Integer.MIN_VALUE : calc(nums[rightIdx], a, b, c);
                }
            }
        }else{
            int minIdx = 0;
            double minVal = Double.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(mid - nums[i]) < minVal) {
                    minIdx = i;
                    minVal = Math.abs(mid - nums[i]);
                }
            }
            int resultIdx = 0;
            result[resultIdx++] = calc(nums[minIdx], a, b, c);
            int leftIdx = minIdx - 1;
            int rightIdx = minIdx + 1;
            int leftVal = leftIdx > 0 ? calc(nums[leftIdx], a, b, c) : Integer.MAX_VALUE;
            int rightVal = rightIdx < nums.length ? calc(nums[rightIdx], a, b, c) : Integer.MAX_VALUE;
            while (leftIdx >= 0 || rightIdx < nums.length) {
                if (leftVal <= rightVal) {
                    result[resultIdx++] = leftVal;
                    leftIdx--;
                    leftVal = leftIdx < 0 ? Integer.MAX_VALUE : calc(nums[leftIdx], a, b, c);
                } else {
                    result[resultIdx++] = rightVal;
                    rightIdx++;
                    rightVal = rightIdx >= nums.length ? Integer.MAX_VALUE : calc(nums[rightIdx], a, b, c);
                }
            }
        }
        return result;

    }

    private int calc(int num, int a, int b, int c) {
        return (a * num * num + b * num + c);
    }
}
