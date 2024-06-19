package leetcode.year_2024.june;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        System.out.println(new HeightChecker().heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(new HeightChecker().heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(new HeightChecker().heightChecker(new int[]{1, 2, 3, 4, 5}));
    }

    public int heightChecker(int[] heights) {
        int[] sort = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sort);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sort[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
