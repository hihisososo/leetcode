package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(new PalindromePartitioning().partition(s));
    }

    public List<List<String>> partition(String s) {
        return findPalindrome(s);
    }

    private List<List<String>> findPalindrome(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.isEmpty()) {
            return result;
        }


        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                if (i == s.length() - 1) {
                    result.add(new ArrayList<String>(Arrays.asList(new String[]{s})));
                } else {
                    List<List<String>> subResult = findPalindrome(s.substring(i + 1));
                    for (List<String> list : subResult) {
                        list.add(0, s.substring(0, i + 1));
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int mid = s.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;

    }
}
