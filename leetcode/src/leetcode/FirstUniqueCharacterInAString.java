package leetcode;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int cnt = map.get(s.charAt(i));
            if (cnt == 1) {
                return i;
            }
        }
        return -1;
    }
}
