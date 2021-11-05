package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numberCntMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (numberCntMap.containsKey(nums1[i])) {
                numberCntMap.put(nums1[i], numberCntMap.get(nums1[i]) + 1);
            } else {
                numberCntMap.put(nums1[i], 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (numberCntMap.containsKey(nums2[i])) {
                int cnt = numberCntMap.get(nums2[i]);
                list.add(nums2[i]);
                if (cnt == 1) {
                    numberCntMap.remove(nums2[i]);
                } else {
                    numberCntMap.put(nums2[i], numberCntMap.get(nums2[i]) - 1);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
