package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class ShortestWordDistanceIii {

    public static void main(String[] args) {
        String[] wordsDict = new String[]{"a", "c","b","b","a"};
        String word1 = "a";
        String word2 = "b";
        System.out.println(new ShortestWordDistanceIii().shortestWordDistance(wordsDict, word1, word2));
    }

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if (word1.equals(word2)) {
            return getShortestOneWord(wordsDict, word1);
        }
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

        int word1Idx = word1Idxs.size() - 1;
        int word2Idx = word2Idxs.size() - 1;
        int minLength = Integer.MAX_VALUE;

        while (word1Idx > 0 && word2Idx > 0) {
            minLength = Math.min(minLength, Math.abs(word1Idxs.get(word1Idx) - word2Idxs.get(word2Idx)));
            if (word1Idxs.get(word1Idx) > word2Idxs.get(word2Idx)) {
                word1Idx--;
            } else {
                word2Idx--;
            }
        }

        if (word2Idx > 0) {
            while (word2Idx >= 0) {
                minLength = Math.min(minLength, Math.abs(word1Idxs.get(word1Idx) - word2Idxs.get(word2Idx)));
                word2Idx--;
            }
        } else if (word1Idx > 0) {
            while (word1Idx >= 0) {
                minLength = Math.min(minLength, Math.abs(word1Idxs.get(word1Idx) - word2Idxs.get(word2Idx)));
                word1Idx--;
            }
        } else {
            minLength = Math.min(minLength, Math.abs(word1Idxs.get(word1Idx) - word2Idxs.get(word2Idx)));
        }
        return minLength;
    }

    private int getShortestOneWord(String[] wordsDict, String word) {
        ArrayList<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word)) {
                idxs.add(i);
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < idxs.size() - 1; i++) {
            minLength = Math.min(minLength, Math.abs(idxs.get(i) - idxs.get(i + 1)));
        }

        return minLength;
    }

}
