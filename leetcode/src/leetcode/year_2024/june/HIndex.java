package leetcode.year_2024.june;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex().hIndex(new int[]{1, 3, 1}));
        System.out.println(new HIndex().hIndex(new int[]{100}));
    }

    public int hIndex(int[] citations) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            max = Math.max(max, citations[i]);
        }

        int[] citCnt = new int[max + 1];
        for (int i = 0; i < citations.length; i++) {
            citCnt[citations[i]]++;
        }

        int citSum = 0;
        for (int i = citCnt.length - 1; i >= 0; i--) {
            citCnt[i] += citSum;
            citSum = citCnt[i];
            if (citCnt[i] >= i) {
                return i;
            }
        }
        return 1;
    }
}
