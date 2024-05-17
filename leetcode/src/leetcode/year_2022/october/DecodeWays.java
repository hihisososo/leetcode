package leetcode.year_2022.october;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("27"));
        System.out.println(new DecodeWays().numDecodings("10"));
        System.out.println(new DecodeWays().numDecodings("06"));
        System.out.println(new DecodeWays().numDecodings("12"));
        System.out.println(new DecodeWays().numDecodings("226"));
        System.out.println(new DecodeWays().numDecodings("2101"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (validAlphabet(s.substring(0, 1))) {
            dp[0] = 1;
        } else {
            dp[0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            if (validAlphabet(s.substring(i - 1, i + 1))) {
                if (i - 2 < 0) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
            if (validAlphabet(s.substring(i, i + 1))) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }


    private boolean validAlphabet(String alphabetInt) {
        if (alphabetInt.startsWith("0")) {
            return false;
        }

        if (0 < Integer.parseInt(alphabetInt) && Integer.parseInt(alphabetInt) <= 26) {
            return true;
        }
        return false;
    }

}
