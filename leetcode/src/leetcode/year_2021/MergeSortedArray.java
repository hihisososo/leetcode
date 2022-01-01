package leetcode.year_2021;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        new MergeSortedArray().merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int resultIdx = 0;
        int nums1Idx = 0;
        int nums2Idx = 0;
        while (resultIdx < m + n) {
            int val1 = getval(nums1, nums1Idx, m);
            int val2 = getval(nums2, nums2Idx, n);
            if (val1 > val2) {
                result[resultIdx] = val2;
                nums2Idx++;
                resultIdx++;
            } else if (val1 < val2) {
                result[resultIdx] = val1;
                nums1Idx++;
                resultIdx++;
            } else {
                result[resultIdx] = val2;
                nums2Idx++;
                resultIdx++;
                result[resultIdx] = val1;
                nums1Idx++;
                resultIdx++;
            }
        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    private int getval(int[] arr, int idx, int limit) {
        if (idx >= limit || idx >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[idx];
    }
}
