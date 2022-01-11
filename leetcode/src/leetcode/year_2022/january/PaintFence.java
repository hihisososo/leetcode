package leetcode.year_2022.january;

public class PaintFence {
    public static void main(String[] args) {
        System.out.println(new PaintFence().numWays(1, 1));
    }

    public int numWays(int n, int k) {
        return findNumWays(n, k, -1, -1, 0);
    }

    private int findNumWays(int n, int k, int prevCol1, int prevCol2, int length) {
        if (length == n) {
            return 1;
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (prevCol1 != prevCol2 || prevCol2 != i) {
                sum += findNumWays(n, k, i, prevCol1, length+1);
            }
        }
        return sum;
    }
}
