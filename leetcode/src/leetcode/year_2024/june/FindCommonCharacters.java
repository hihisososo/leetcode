package leetcode.year_2024.june;

import java.util.*;

public class FindCommonCharacters {
    public static void main(String[] args) {
        System.out.println(new FindCommonCharacters().commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(new FindCommonCharacters().commonChars(new String[]{"cool", "lock", "cook"}));
    }

    public List<String> commonChars(String[] words) {
        Map<Character, Integer> commonMap = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++) {
            commonMap.put(words[0].charAt(i), commonMap.getOrDefault(words[0].charAt(i), 0) + 1);
        }
        Map<Character, Integer> currMap = new HashMap<>();
        Set<Character> removes = new HashSet<>();
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                currMap.put(words[i].charAt(j), currMap.getOrDefault(words[i].charAt(j), 0) + 1);
            }
            for (Character key : commonMap.keySet()) {
                int min = Math.min(commonMap.get(key), currMap.getOrDefault(key, 0));
                if (min == 0) {
                    removes.add(key);
                } else {
                    commonMap.put(key, min);
                }
            }
            for (Character r : removes) {
                commonMap.remove(r);
            }
            currMap.clear();
        }


        List<String> result = new ArrayList<>();
        for (Character key : commonMap.keySet()) {
            int cnt = commonMap.get(key);
            for (int i = 0; i < cnt; i++) {
                result.add(String.valueOf(key));
            }
        }

        return result;
    }

}
