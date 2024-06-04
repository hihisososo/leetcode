package leetcode.year_2024.june;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
        System.out.println(new LongestPalindrome().longestPalindrome("a"));

    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int result = 0;
        boolean oddOccur = false;
        for (char c : map.keySet()) {
            int cnt = map.get(c);
            if (cnt % 2 == 0) {
                result += cnt;
            } else {
                oddOccur = true;
                result += cnt - 1;
            }
        }
        return oddOccur ? result + 1 : result;
    }
}
