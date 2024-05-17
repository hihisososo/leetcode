package leetcode.year_2022.january;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static void main(String[] args) {
        String s = "code";
//        String s = "aab";
//        String s = "carerac";
        System.out.println(new PalindromePermutation().canPermutePalindrome(s));
    }

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> checkMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            checkMap.putIfAbsent(s.charAt(i), 0);
            checkMap.put(s.charAt(i), checkMap.get(s.charAt(i)) + 1);
        }

        if (s.length() % 2 == 0) {
            for (Map.Entry<Character, Integer> entry : checkMap.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    return false;
                }
            }
        } else {
            boolean oddExist = false;
            for (Map.Entry<Character, Integer> entry : checkMap.entrySet()) {
                if (entry.getValue() % 2 == 1) {
                    if (oddExist) {
                        return false;
                    } else {
                        oddExist = true;
                    }
                }

            }
        }

        return true;
    }
}
