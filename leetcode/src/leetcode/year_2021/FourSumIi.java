package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class FourSumIi {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, -1};
        int[] nums2 = new int[]{-1, 1};
        int[] nums3 = new int[]{-1, 1};
        int[] nums4 = new int[]{1, -1};

        System.out.println(new FourSumIi().fourSumCount(nums1, nums2, nums3, nums4));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> mergeMap1 = getMergeMap(nums1, nums2);
        HashMap<Integer, Integer> mergeMap2 = getMergeMap(nums3, nums4);
        int cnt = 0;

        Set<Integer> keySet = mergeMap1.keySet();
        ArrayList<Integer> mergeKeyList = new ArrayList<>(mergeMap2.keySet());
        Collections.sort(mergeKeyList);
        for (int i : keySet) {
            if (Collections.binarySearch(mergeKeyList, -i) >= 0) {
                cnt += mergeMap1.get(i) * mergeMap2.get(-i);
            }
        }

        return cnt;
    }

    private HashMap<Integer, Integer> getMergeMap(int[] nums1, int[] nums2) {
        ArrayList<Integer> mergeList = new ArrayList<>();
        HashMap<Integer, Integer> numCntMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                numCntMap.putIfAbsent(sum, 0);
                numCntMap.put(sum, numCntMap.get(sum) + 1);
            }
        }
        return numCntMap;
    }
}
