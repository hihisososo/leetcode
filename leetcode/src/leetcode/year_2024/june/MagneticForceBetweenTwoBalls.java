package leetcode.year_2024.june;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        System.out.println(new MagneticForceBetweenTwoBalls().maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(new MagneticForceBetweenTwoBalls().maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int result = Integer.MIN_VALUE;
        int left = 0;
        int right = position[position.length - 1] - position[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (checkSatisfied(position, mid, m)) {
                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private boolean checkSatisfied(int[] position, int diff, int m) {
        m--;
        int lastIdx = 0;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[lastIdx] >= diff) {
                lastIdx = i;
                m--;
                if (m == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
