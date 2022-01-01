package leetcode.year_2021;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "abaccc";
        int k = 2;
        System.out.println(new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct(s, k));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        int maxLength = 0;
        int length = 0;
        int lastRemoveIdx = -1;
        HashMap<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cntMap.containsKey(c)) {
                cntMap.put(c, cntMap.get(c) + 1);
            } else {
                cntMap.put(c, 1);
            }
            length++;

            if (cntMap.keySet().size() > k) {
                while (cntMap.keySet().size() > k) {
                    lastRemoveIdx++;
                    length--;
                    char removeTargetChar = s.charAt(lastRemoveIdx);
                    cntMap.put(removeTargetChar, cntMap.get(removeTargetChar) - 1);
                    if (cntMap.get(removeTargetChar) == 0) {
                        cntMap.remove(removeTargetChar);
                    }
                }
            } else {
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
