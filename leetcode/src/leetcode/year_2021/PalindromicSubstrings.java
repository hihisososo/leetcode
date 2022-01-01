package leetcode.year_2021;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new PalindromicSubstrings().countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (checkPalindromic(s, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean checkPalindromic(String s, int startIdx, int endIdx) {
        for (int i = startIdx; i <= endIdx; i++) {
            if (s.charAt(i) != s.charAt(endIdx - i + startIdx)) {
                return false;
            }
        }
        return true;
    }
}
