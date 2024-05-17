package leetcode.year_2021;

import java.util.HashMap;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        String s = "";
        int k = 2;
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring(s, k));
    }

    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        int kCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            charIntMap.putIfAbsent(c, 0);
            charIntMap.put(c, charIntMap.get(c) + 1);
            if (charIntMap.get(c) == k) {
                kCnt++;
            }
        }
        if (kCnt == 0) {
            return 0;
        }

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                if (isDecreaseKcnt(s.charAt(i - 1), charIntMap, k)) {
                    kCnt--;
                }
                decreaseMap(s.charAt(i - 1), charIntMap);
            }
            HashMap<Character, Integer> copyMap = new HashMap<Character, Integer>(charIntMap);
            int copyKcnt = kCnt;
            for (int j = s.length(); j >= i; j--) {
                if (j != s.length()) {
                    if (isDecreaseKcnt(s.charAt(j), copyMap, k)) {
                        copyKcnt--;
                    }
                    decreaseMap(s.charAt(j), copyMap);
                }
                if (copyKcnt == copyMap.keySet().size()) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }

        return maxLen;
    }

    private void decreaseMap(char c, HashMap<Character, Integer> charIntMap) {
        charIntMap.put(c, charIntMap.get(c) - 1);
        if (charIntMap.get(c) == 0) {
            charIntMap.remove(c);
        }
    }

    private boolean isDecreaseKcnt(char c, HashMap<Character, Integer> charIntMap, int k) {
        return charIntMap.get(c) == k;
    }

    private HashMap<Character, Integer> makeHashMap(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        return map;
    }

}
