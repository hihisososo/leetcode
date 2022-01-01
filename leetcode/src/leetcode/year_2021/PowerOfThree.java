package leetcode.year_2021;

public class PowerOfThree {

    public static void main(String[] args) {
        int n = 44;
        System.out.println(new PowerOfThree().isPowerOfThree(n));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }
}
