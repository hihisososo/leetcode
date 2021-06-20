package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new FindAllAnagramsInAString().findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> resultList = new ArrayList<>();
        HashMap<Character, Integer> pMap = makeMap(p);

        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (i == 0) {
                wordMap = makeMap(s.substring(i, i + p.length()));
            } else {
                addChar(s.charAt(i + p.length() - 1), wordMap);
                removeChar(s.charAt(i - 1), wordMap);
            }

            if (comparePmap(pMap, wordMap)) {
                resultList.add(i);
            }
        }

        return resultList;
    }


    private boolean comparePmap(HashMap<Character, Integer> pMap, HashMap<Character, Integer> wordMap) {
        return pMap.equals(wordMap);
    }

    private void addChar(char c, HashMap<Character, Integer> wordMap) {
        Integer cnt = wordMap.get(c);
        if (cnt == null) {
            wordMap.put(c, 1);
        } else {
            wordMap.put(c, ++cnt);
        }
    }

    private void removeChar(char c, HashMap<Character, Integer> wordMap) {
        int cnt = wordMap.get(c);
        cnt--;
        if (cnt == 0) {
            wordMap.remove(c);
        } else {
            wordMap.put(c, cnt);
        }
    }

    private HashMap<Character, Integer> makeMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        return map;
    }
}
