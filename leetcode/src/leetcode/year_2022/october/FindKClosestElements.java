package leetcode.year_2022.october;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public static void main(String[] args) {
        System.out.println(
                new FindKClosestElements().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(
                new FindKClosestElements().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closestIdx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < min) {
                closestIdx = i;
                min = Math.abs(arr[i] - x);
            }
        }

        int size = 1;
        int leftIdx = closestIdx - 1;
        int rightIdx = closestIdx + 1;
        while (size < k) {
            int leftDiff = leftIdx >= 0 ? Math.abs(arr[leftIdx] - x) : Integer.MAX_VALUE;
            int rightDiff = rightIdx < arr.length ? Math.abs(arr[rightIdx] - x) : Integer.MAX_VALUE;
            if (leftDiff <= rightDiff) {
                leftIdx--;
            } else {
                rightIdx++;
            }
            size++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = leftIdx + 1; i < leftIdx + 1 + size; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}
