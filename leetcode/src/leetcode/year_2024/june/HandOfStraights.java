package leetcode.year_2024.june;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class HandOfStraights {
    public static void main(String[] args) {
        System.out.println(new HandOfStraights().isNStraightHand(new int[]{1, 2, 3}, 3));
        System.out.println(new HandOfStraights().isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(new HandOfStraights().isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(new HandOfStraights().isNStraightHand(new int[]{8, 10, 12}, 3));
        System.out.println(new HandOfStraights().isNStraightHand(new int[]{9, 13, 15, 23, 22, 25, 4, 4, 29, 15, 8, 23, 12, 19, 24, 17, 18, 11, 22, 24, 17, 17, 10, 23, 21, 18, 14, 18, 7, 6, 3, 6, 19, 11, 16, 11, 12, 13, 8, 26, 17, 20, 13, 19, 22, 21, 27, 9, 20, 15, 20, 27, 8, 13, 25, 23, 22, 15, 9, 14, 20, 10, 6, 5, 14, 12, 7, 16, 21, 18, 21, 24, 23, 10, 21, 16, 18, 16, 18, 5, 20, 19, 20, 10, 14, 26, 2, 9, 19, 12, 28, 17, 5, 7, 25, 22, 16, 17, 21, 11}, 10));
        System.out.println(new HandOfStraights().isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2));

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            cntMap.put(hand[i], cntMap.getOrDefault(hand[i], 0) + 1);
        }

        int size = 0;
        int lastVal = -1;
        List<Integer> removes = new ArrayList<>();
        while (!cntMap.isEmpty()) {
            lastVal = -1;
            size = 0;
            removes.clear();
            for (int num : cntMap.keySet()) {
                cntMap.put(num, cntMap.get(num) - 1);
                if (cntMap.get(num) == 0) {
                    removes.add(num);
                }

                if (lastVal >= 0 && num - lastVal != 1) {
                    return false;
                }
                lastVal = num;
                size++;
                if (size == groupSize) {
                    break;
                }
            }
            for (int r : removes) {
                cntMap.remove(r);
            }
        }
        return size == groupSize;
    }
}
