package leetcode.year_2024.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReplaceWords {
    public static void main(String[] args) {
        System.out.println(new ReplaceWords().replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(new ReplaceWords().replaceWords(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Map<String, String> rootMap = new HashMap<>();
        for (String d : dictionary) {
            rootMap.put(d, d);
        }

        List<String> replaces = new ArrayList<>();
        for (String s : sentence.split(" ")) {
            boolean find = false;
            for (int i = 0; i < s.length(); i++) {
                if (rootMap.containsKey(s.substring(0, i + 1))) {
                    replaces.add(rootMap.get(s.substring(0, i + 1)));
                    find = true;
                    break;
                }
            }
            if (!find) {
                replaces.add(s);
            }
        }
        return replaces.stream().collect(Collectors.joining(" "));
    }
}
