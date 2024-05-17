package leetcode.year_2021;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(n));
    }

    public int trailingZeroes(int n) {
        int zeroCnt = 0;
        int powerof5 = 5;
        while (n >= powerof5) {
            zeroCnt += (n / powerof5);
            powerof5 *= 5;
        }
        return zeroCnt;
    }
}
