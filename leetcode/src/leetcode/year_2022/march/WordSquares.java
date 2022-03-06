package leetcode.year_2022.march;

import java.util.*;

public class WordSquares {
    public static void main(String[] args) {
//        String[] words = new String[]{"area", "lead", "wall", "lady", "ball"};
        String[] words = new String[]{"abat","baba","atan","atal"};
        System.out.println(new WordSquares().wordSquares(words));
    }

    int wordLen;
    Map<String, List<Integer>> prefixMap;

    public List<List<String>> wordSquares(String[] words) {
        this.wordLen = words[0].length();

        this.prefixMap = new HashMap<>();
        prefixMap.put("", new ArrayList<>());
        for (int i = 0; i < words.length; i++) {
            prefixMap.get("").add(i);
            String prefix = "";
            for (int j = 0; j < words[i].length(); j++) {
                prefix += words[i].charAt(j);
                prefixMap.putIfAbsent(prefix, new ArrayList<>());
                prefixMap.get(prefix).add(i);
            }
        }

        List<List<String>> result = new ArrayList<>();
        dfs(0, new LinkedList<>(), words, result);

        return result;
    }

    private void dfs(int depth, LinkedList<String> wordList, String[] words, List<List<String>> result) {
        if (depth == wordLen) {
            result.add(new ArrayList<>(wordList));
            return;
        }

        String prefix = "";
        for (String w : wordList) {
            prefix += w.charAt(depth);
        }
        if (prefixMap.get(prefix) != null) {
            List<Integer> wordIdx = prefixMap.get(prefix);
            for (int i = 0; i < wordIdx.size(); i++) {
                wordList.addLast(words[wordIdx.get(i)]);
                dfs(depth + 1, wordList, words, result);
                wordList.removeLast();
            }
        }
    }

}