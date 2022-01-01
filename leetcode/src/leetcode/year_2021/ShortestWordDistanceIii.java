package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Collections;

public class ShortestWordDistanceIii {
    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        System.out.println(new ShortestWordDistanceIii().shortestWordDistance(wordsDict, word1, word2));
    }

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
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
        Collections.sort(word1Idxs);
        Collections.sort(word2Idxs);
        int word1Idx = word1Idxs.size() - 1;
        int word2Idx = word2Idxs.size() - 1;
        int word1Val = 0;
        int word2Val = 0;
        int minLength = Integer.MAX_VALUE;

        while ((word1Val != Integer.MAX_VALUE) || (word2Val != Integer.MIN_VALUE)) {
            word1Val = word1Idx == -1 ? Integer.MIN_VALUE : word1Idxs.get(word1Idx);
            word2Val = word2Idx == -1 ? Integer.MIN_VALUE : word2Idxs.get(word2Idx);
            if(word1Val == word2Val){
                word1Idx--;
                word2Idx--;
                continue;
            }else if(word1Val > word2Val){
                word1Idx--;
                minLength = Math.min(minLength, Math.abs(word1Val - word2Val));
            }else{
                word2Idx--;
                minLength = Math.min(minLength, Math.abs(word1Val - word2Val));
            }
        }

        return minLength;
    }
}
