package leetcode.year_2022.march;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSquares {
    public static void main(String[] args) {
        String[] words = new String[]{"area","lead","wall","lady","ball"};
        System.out.println(new WordSquares().wordSquares(words));
    }

    public List<List<String>> wordSquares(String[] words) {
        List<Hash>
        List<List<String>> result = new ArrayList<>();
        for (String word : words) {
            dfs(word, "", new ArrayList<>(), words, result);
        }
        return result;
    }

    private void dfs(String word, String prefix, List<String> wordList, String[] words, List<List<String>> result) {
        if (!word.startsWith(prefix)) {
            return;
        }
        System.out.println(prefix);
        wordList.add(word);
        if (wordList.size() == words.length) {
            result.add(new ArrayList<>(wordList));
        } else {
            for (String w : words) {
                dfs(w, prefix + word.charAt(prefix.length()+1), wordList, words, result);
            }
        }
        wordList.remove(word);
    }
}
