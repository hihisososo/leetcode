package leetcode.year_2022.february;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
//        String s = "aabbcc";int k = 3;
//        String s = "aaadbbcc";int k = 2;
        String s = "aaabc";int k = 3;
        System.out.println(new RearrangeStringKDistanceApart().rearrangeString(s, k));
    }

    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        char maxChar = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            charIntMap.putIfAbsent(c, 0);
            charIntMap.put(c, charIntMap.get(c) + 1);
            if (max < charIntMap.get(c)) {
                max = c;
            }
        }
        if (max == 1) {
            return s;
        }
        List<Character> remnant = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (charIntMap.get(c) == 1) {
                charIntMap.remove(c);
                remnant.add(c);
            }
        }
        HashMap<Character, Integer> sortMap = sortByValue(charIntMap);
        HashMap<Character, Integer> lastIdxMap = new HashMap<>();
        List<Character> removeList = new ArrayList<>();
        char[] result = new char[s.length()];
        int curIdx = 0;
        while (!sortMap.isEmpty()) {
            for (Map.Entry<Character, Integer> e : sortMap.entrySet()) {
                if (lastIdxMap.containsKey(e.getKey())) {
                    int lastIdx = lastIdxMap.get(e.getKey());
                    if (curIdx - lastIdx < k) {
                        curIdx = lastIdx + k;
                    }
                }
                if (curIdx >= s.length()) {
                    return "";
                }
                result[curIdx] = e.getKey();
                lastIdxMap.put(e.getKey(), curIdx);
                curIdx++;
                e.setValue(e.getValue() - 1);
                if (e.getValue() == 0) {
                    removeList.add(e.getKey());
                }
            }
            for (Character c : removeList) {
                sortMap.remove(c);
            }
            removeList.clear();
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                result[i] = remnant.get(0);
                remnant.remove(0);
            }
        }
        return new String(result);
    }

    public HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm) {
        List<Map.Entry<Character, Integer>> list =
                new LinkedList<Map.Entry<Character, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return -(o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
