package leetcode;

public class CountingBits {
    public static void main(String[] args) {
        int[] result = new CountingBits().countBits(5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i] = countingOne(i);
        }
        return result;
    }

    private int countingOne(int n) {
        int cnt = 0;
        while (true) {
            if (n < 2) {
                if (n == 1) {
                    cnt++;
                }
                break;
            }
            if (n % 2 == 1)
                cnt++;
            n = n / 2;
        }

        return cnt;
    }
}
