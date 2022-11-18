package leetcode.year_2022.november;

public class UglyNumber {
    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(6));
        System.out.println(new UglyNumber().isUgly(1));
        System.out.println(new UglyNumber().isUgly(14));
        System.out.println(new UglyNumber().isUgly(-6));
        System.out.println(new UglyNumber().isUgly(-1));
        System.out.println(new UglyNumber().isUgly(-14));
    }

    public boolean isUgly(int n) {
        if(n == 0){
            return false;
        }
        int[] factors = new int[]{5, 3, 2};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
