package leetcode;

import javafx.util.Pair;

import java.util.*;

public class WordBreakIi {
    public static void main(String[] args) {
        String s = "a";
        List<String> wordDict = Arrays.asList(new String[]{"a"});
        System.out.println(new WordBreakIi().wordBreak(s, wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>(wordDict);
        HashSet<String> dupSet = new HashSet<>();
        Queue<Pair<String, String>> queue = new LinkedList<>();
        queue.add(new Pair<>("", s));

        while (!queue.isEmpty()) {
            Pair<String, String> poll = queue.poll();
            String prefix = poll.getKey();
            String str = poll.getValue();
            if (dupSet.contains(poll.getKey())) {
                continue;
            }
            dupSet.add(poll.getKey());
            for (int i = 0; i < str.length() && i < 10; i++) {
                String subStr = str.substring(0, i + 1);
                if (wordSet.contains(subStr)) {
                    final String newPrefix = (prefix.length() == 0 ? "" : prefix + " ") + subStr;
                    if (i == str.length() - 1) {
                        result.add(newPrefix);
                    }
                    queue.add(new Pair<>(newPrefix, str.substring(i + 1)));
                }
            }
        }
        return result;
    }
}
