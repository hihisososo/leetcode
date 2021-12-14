package leetcode;

import java.util.ArrayList;

public class ShortestWordDistance {

    public static void main(String[] args) {
        String[] wordsDict = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println(new ShortestWordDistance().shortestDistance(wordsDict, word1, word2));
    }

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        ArrayList<Integer> word1Idxs = new ArrayList<>();
        ArrayList<Integer> word2Idxs = new ArrayList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                word1Idxs.add(i);
            }
            if (wordsDict[i].equals(word2)) {
                word2Idxs.add(i);
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < word1Idxs.size(); i++) {
            for (int j = 0; j < word2Idxs.size(); j++) {
                minLength = Math.min(minLength, Math.abs(word1Idxs.get(i) - word2Idxs.get(j)));
            }
        }
        return minLength;
    }

}
