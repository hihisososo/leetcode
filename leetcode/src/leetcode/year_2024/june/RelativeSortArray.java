package leetcode.year_2024.june;

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RelativeSortArray().relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println(Arrays.toString(new RelativeSortArray().relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Map = new HashMap();
        for (int i = 0; i < arr2.length; i++) {
            arr2Map.put(arr2[i], i);
        }
        int[] cnt = new int[arr2.length];
        List<Integer> remain = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr2Map.containsKey(arr1[i])) {
                cnt[arr2Map.get(arr1[i])]++;
            } else {
                remain.add(arr1[i]);
            }
        }
        Collections.sort(remain);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            int c = cnt[i];
            int val = arr2[i];
            for (int j = 0; j < c; j++) {
                result.add(val);
            }
        }

        for (int i = 0; i < remain.size(); i++) {
            result.add(remain.get(i));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
