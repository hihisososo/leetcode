package leetcode.year_2022.august;

import java.util.Arrays;

public class FindPermutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindPermutation().findPermutation("I")));
        System.out.println(Arrays.toString(new FindPermutation().findPermutation("DI")));
        System.out.println(Arrays.toString(new FindPermutation().findPermutation("DDI")));
        System.out.println(Arrays.toString(new FindPermutation().findPermutation("DID")));
        System.out.println(Arrays.toString(new FindPermutation().findPermutation("DDIIDI")));
        System.out.println(Arrays.toString(new FindPermutation().findPermutation("DDD")));
    }

    public int[] findPermutation(String s) {
        if (s == null) {
            return null;
        }

        int[] arr = new int[s.length() + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'D') {
                int lastDIndex = getLastDIndex(s, i);
                fillReverse(arr, lastDIndex, i);
                i = lastDIndex;
            }
        }

        return arr;
    }

    private void fillReverse(int[] arr, int lastDIndex, int start) {
        int value = lastDIndex + 2;
        for (int i = start; i <= lastDIndex + 1; i++) {
            arr[i] = value--;
        }
    }

    private int getLastDIndex(String s, int start) {
        int lastIdx = -1;
        for (int i = start + 1; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                lastIdx = i;
            }else{
                break;
            }
        }
        if (lastIdx == -1) {
            return start;
        } else {
            return lastIdx;
        }
    }

}
