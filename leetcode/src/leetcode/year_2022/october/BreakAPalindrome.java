package leetcode.year_2022.october;

public class BreakAPalindrome {
    public static void main(String[] args) {
        System.out.println(new BreakAPalindrome().breakPalindrome("abccba"));
        System.out.println(new BreakAPalindrome().breakPalindrome("a"));
        System.out.println(new BreakAPalindrome().breakPalindrome("aa"));
        System.out.println(new BreakAPalindrome().breakPalindrome("aba"));
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        int replaceIdx = -1;
        for (int i = 0; i < palindrome.length(); i++) {
            char c = palindrome.charAt(i);
            if (c != 'a') {
                if (palindrome.length() % 2 == 1 && i == palindrome.length() / 2) {
                    continue;
                }
                replaceIdx = i;
                break;
            }
        }
        if (replaceIdx >= 0) {
            if (replaceIdx == palindrome.length() - 1) {
                return palindrome.substring(0, replaceIdx) + 'a';
            } else if (replaceIdx == 0) {
                return 'a' + palindrome.substring(replaceIdx + 1);
            } else {
                return palindrome.substring(0, replaceIdx) + 'a' + palindrome.substring(replaceIdx + 1);
            }
        } else {
            return palindrome.substring(0, palindrome.length() - 1) + "b";
        }
    }
}
