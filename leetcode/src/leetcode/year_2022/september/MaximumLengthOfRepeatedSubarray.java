package leetcode.year_2022.september;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
    }

    public int findLength(int[] nums1, int[] nums2) {
        Map<Integer, Set<Integer>> valuePointMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            valuePointMap.putIfAbsent(nums1[i], new HashSet<>());
            valuePointMap.get(nums1[i]).add(i);
        }

        int maxLen = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (valuePointMap.get(nums2[i]) != null) {
                Set<Integer> indxes = valuePointMap.get(nums2[i]);
                for (Integer index : indxes) {
                    if (maxLen < nums2.length - i - 1) {
                        maxLen = Math.max(maxLen, getContinuousMax(index, valuePointMap, nums2, i));
                    }
                }
            }
        }
        return maxLen;
    }

    private int getContinuousMax(Integer nums1Idx, Map<Integer, Set<Integer>> valuePointMap, int[] nums2, int nums2Idx) {
        int cont = 0;
        while (true) {
            nums1Idx++;
            nums2Idx++;
            cont++;
            if (nums2Idx >= nums2.length) {
                break;
            }
            if (valuePointMap.get(nums2[nums2Idx]) == null) {
                break;
            }
            if (!valuePointMap.get(nums2[nums2Idx]).contains(nums1Idx)) {
                break;
            }
        }
        return cont;
    }
}
