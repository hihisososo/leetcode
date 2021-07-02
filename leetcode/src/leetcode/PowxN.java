package leetcode;

public class PowxN {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = Integer.MIN_VALUE;
        System.out.println(new PowxN().myPow(x, n));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        } else if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }

        double result2 = 1;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                result2 *= x;
            }
        } else {
            for (int i = n; i < 0; i++) {
                result2 /= x;
                if (result2 == 0) {
                    return result2;
                }
            }
        }

        return result2;
    }

}
