package leetcode.year_2021;

import common.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordLadder {
    public static void main(String[] args) throws IOException {
        String beginWord = "hit";
        String endWord = "cog";
        Path path = Paths.get("C:\\Users\\lyj\\Desktop\\intellij_workspace\\leetcode\\input.txt");

        Stream<String> lines = Files.lines(path);
        List<String> list = lines.collect(Collectors.toList());
        lines.close();
        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        HashMap<String, HashSet<String>> transitionMap = makeTransitionAvailableMap(beginWord, wordList);
        HashSet<String> processed = new HashSet<>();
        Queue<Pair<String, Integer>> wordQueue = new LinkedList<>();
        wordQueue.add(new Pair<>(beginWord, 0));
        while (!wordQueue.isEmpty()) {
            Pair<String, Integer> pair = wordQueue.poll();
            if (pair.getKey().equals(endWord)) {
                return pair.getValue() + 1;
            }
            if (processed.contains(pair.getKey())) {
                continue;
            }
            for (String word : transitionMap.get(pair.getKey())) {
                wordQueue.add(new Pair<String, Integer>(word, pair.getValue() + 1));
            }
            processed.add(pair.getKey());
        }
        return 0;
    }

    private HashMap<String, HashSet<String>> makeTransitionAvailableMap(String startWord, List<String> wordList) {
        HashMap<String, List<String>> wordMap = makeWordMap(wordList);
        HashMap<String, HashSet<String>> transitionMap = new HashMap<>();
        wordList.add(startWord);
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            HashSet<String> transitions = new HashSet<>();
            for (int j = 0; j < word.length(); j++) {
                List<String> list = wordMap.get(makePartString(word, j));
                if (list == null) {
                    continue;
                }
                transitions.addAll(list);
            }
            transitionMap.put(word, transitions);
        }
        wordList.remove(startWord);
        return transitionMap;
    }

    private HashMap<String, List<String>> makeWordMap(List<String> wordList) {
        HashMap<String, List<String>> wordMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                String partString = makePartString(word, j);
                List<String> list;
                if (wordMap.get(partString) == null) {
                    list = new ArrayList<String>();
                } else {
                    list = wordMap.get(partString);
                }
                list.add(word);
                wordMap.put(partString, list);
            }
        }
        return wordMap;
    }

    private String makePartString(String word, int j) {
        return (j == 0 ? "" : word.substring(0, j)) + " " + (j == word.length() - 1 ? "" : word.substring(j + 1));
    }
}
