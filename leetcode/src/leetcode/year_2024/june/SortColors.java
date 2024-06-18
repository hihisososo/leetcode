package leetcode.year_2024.june;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2, 0, 1};
        new SortColors().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (cnt[idx] == 0) {
                idx++;
            }
            nums[i] = idx;
            cnt[idx]--;
        }
    }
}
