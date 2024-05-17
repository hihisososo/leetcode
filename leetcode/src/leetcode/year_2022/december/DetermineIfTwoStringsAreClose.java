package leetcode.year_2022.december;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println(new DetermineIfTwoStringsAreClose().closeStrings("abc", "bca"));
        System.out.println(new DetermineIfTwoStringsAreClose().closeStrings("a", "aa"));
        System.out.println(new DetermineIfTwoStringsAreClose().closeStrings("cabbba", "abbccc"));
    }

    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> word1CntMap = new HashMap<>();
        for (Character c : word1.toCharArray()) {
            word1CntMap.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> word2CntMap = new HashMap<>();
        for (Character c : word2.toCharArray()) {
            word2CntMap.merge(c, 1, Integer::sum);
        }

        Map<Integer, Integer> word1OccurMap = new TreeMap<>();
        for (Integer cnt : word1CntMap.values()) {
            word1OccurMap.merge(cnt, 1, Integer::sum);
        }

        Map<Integer, Integer> word2OccurMap = new TreeMap<>();
        for (Integer cnt : word2CntMap.values()) {
            word2OccurMap.merge(cnt, 1, Integer::sum);
        }
        return word1OccurMap.equals(word2OccurMap) && word1CntMap.keySet().equals(word2CntMap.keySet());
    }
}
