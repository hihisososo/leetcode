package leetcode.year_2021;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (sMap.get(sArr[i]) == null) {
                sMap.put(sArr[i], 1);
            } else {
                sMap.put(sArr[i], sMap.get(sArr[i]) + 1);
            }
        }

        char[] tArr = t.toCharArray();
        for (int i = 0; i < tArr.length; i++) {
            char c = tArr[i];
            if (!sMap.containsKey(c)) {
                return false;
            }
            int cnt = sMap.get(c);
            if (cnt == 1) {
                sMap.remove(c);
            } else {
                sMap.put(c, sMap.get(c) - 1);
            }
        }
        return sMap.isEmpty();
    }
}
