package leetcode.year_2021;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "06";
        System.out.println(new DecodeWays().numDecodings(s));
    }

    public int numDecodings(String s) {
        return decoding(s);
    }

    private int decoding(String s) {
        if (s.length() == 1) {
            return s.startsWith("0") ? 0 : 1;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.startsWith("0") ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            String numberStr = s.substring(i - 2, i);
            if (!numberStr.startsWith("0")) {
                int number = Integer.parseInt(numberStr);
                if (number <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
