package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestWordDistanceIi {
    String[] wordsDict;
    HashMap<String, ArrayList<Integer>> wordIdxMap;

    public ShortestWordDistanceIi(String[] wordsDict) {
        this.wordsDict = wordsDict;
        this.wordIdxMap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            this.wordIdxMap.putIfAbsent(wordsDict[i], new ArrayList<>());
            this.wordIdxMap.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> word1Idx = wordIdxMap.get(word1);
        ArrayList<Integer> word2Idx = wordIdxMap.get(word2);
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < word1Idx.size(); i++) {
            for (int j = 0; j < word2Idx.size(); j++) {
                minLength = Math.min(minLength, Math.abs(word1Idx.get(i) - word2Idx.get(j)));
            }
        }
        return minLength;
    }
}
