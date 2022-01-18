package leetcode.year_2022.january;

import java.util.HashMap;

public class WordPatternIi {
    public static void main(String[] args) {
//        String pattern = "aabb";
//        String s = "xyzabcxzyabc";
        String pattern = "ab";
        String s = "aa";
        System.out.println(new WordPatternIi().wordPatternMatch(pattern, s));
    }

    public boolean wordPatternMatch(String pattern, String s) {
        return findMatch(pattern, s, new HashMap<Character, String>());
    }

    private boolean findMatch(String pattern, String s, HashMap<Character, String> patternMap) {
        if (pattern.isEmpty()) {
            return s.isEmpty();
        }

        Character p = pattern.charAt(0);
        if (patternMap.containsKey(p)) {
            if (s.startsWith(patternMap.get(p))) {
                return findMatch(pattern.substring(1), s.replaceFirst(patternMap.get(p), ""), patternMap);
            } else {
                return false;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (patternMap.containsValue(s.substring(0, i + 1))) {
                    continue;
                }
                patternMap.put(p, s.substring(0, i + 1));
                if (findMatch(pattern.substring(1), s.replaceFirst(patternMap.get(p), ""), patternMap)) {
                    return true;
                }
                patternMap.remove(p);
            }
            return false;
        }
    }
}
