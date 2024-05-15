package leetcode.year_2023.may;

public class CountWaysToBuildGoodStrings {

    public static void main(String[] args) {
        System.out.println(new CountWaysToBuildGoodStrings().countGoodStrings(3, 3, 1, 1));
        System.out.println(new CountWaysToBuildGoodStrings().countGoodStrings(2, 3, 1, 2));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int count = 0;
        for (int i = 1; i < dp.length; i++) {
            int countZero = i - zero >= 0 ? dp[i - zero] : 0;
            int countOne = i - one >= 0 ? dp[i - one] : 0;
            count = (countZero + countOne) % 1000000007;
            dp[i] = count;
        }

        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % 1000000007;
        }
        return result;
    }

}
