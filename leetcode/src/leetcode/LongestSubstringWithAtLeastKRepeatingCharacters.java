package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring(s, k));
    }

    public int longestSubstring(String s, int k) {
        Integer kCnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }

            if(map.get(c) == k){
                kCnt++;
            }
        }

        if(kCnt == 0){
            return 0;
        }

        int maxLen = 0;
        for (int i = -1; i < s.length(); i++) {
            kCnt = getInteger(s, k, kCnt, map, i);
            if(map.keySet().size() == kCnt){
                maxLen = Math.max(maxLen, s.length() - i - 1);
            }
            HashMap<Character, Integer> targetMap = new HashMap<>(map);
            for (int j = s.length() - 1; j > i; j--) {
                kCnt = getInteger(s, k, kCnt, targetMap, j);
                if(targetMap.keySet().size() == kCnt){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private Integer getInteger(String s, int k, Integer kCnt, HashMap<Character, Integer> map, int i) {
        if(i < 0){
            return kCnt;
        }
        Character targetC = s.charAt(i);
        if(map.get(targetC) == k){
            kCnt--;
        }
        map.put(targetC, map.get(targetC) - 1);
        if(map.get(targetC) == 0){
            map.remove(targetC);
        }
        return kCnt;
    }

}
