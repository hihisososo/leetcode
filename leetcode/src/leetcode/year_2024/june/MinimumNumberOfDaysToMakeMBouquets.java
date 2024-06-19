package leetcode.year_2024.june;

import java.util.*;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }

        Set<Integer> bloomDaySet = new TreeSet<>();
        for (int i = 0; i < bloomDay.length; i++) {
            bloomDaySet.add(bloomDay[i]);
        }
        List<Integer> bloomDays = new ArrayList<>(bloomDaySet);

        boolean[] bloom = new boolean[bloomDay.length];
        int dayMinIdx = 0;
        int dayMaxIdx = bloomDays.size() - 1;
        int result = -1;
        while (dayMinIdx <= dayMaxIdx) {
            int mid = dayMinIdx + (dayMaxIdx - dayMinIdx) / 2;
            int day = bloomDays.get(mid);
            Arrays.fill(bloom, false);
            for (int i = 0; i < bloom.length; i++) {
                if (bloomDay[i] <= day) {
                    bloom[i] = true;
                }
            }

            int mBouquet = 0;
            int adjacent = 0;

            for (int i = 0; i < bloom.length; i++) {
                if (bloom[i]) {
                    adjacent++;
                    if (adjacent % k == 0) {
                        adjacent = 0;
                        mBouquet++;
                    }
                } else {
                    adjacent = 0;
                }
            }
            if (mBouquet >= m) {
                dayMaxIdx = mid - 1;
                result = day;
            } else {
                dayMinIdx = mid + 1;
            }

        }
        return result;
    }
}
