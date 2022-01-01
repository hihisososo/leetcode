package leetcode.year_2021;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "abb";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        if (s.length() == 1) {
            return true;
        }

        int mid;
        if (s.length() % 2 == 0) {
            mid = s.length() / 2;
        } else {
            mid = s.length() / 2;

        }

        for (int i = 0; i < mid; i++) {
            if (!s.substring(i, i + 1).equalsIgnoreCase(s.substring(s.length() - 1 - i, s.length() - i))) {
                return false;
            }
        }

        return true;
    }
}
