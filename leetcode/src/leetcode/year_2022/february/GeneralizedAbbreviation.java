package leetcode.year_2022.february;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        String word = "word";
        System.out.println(new GeneralizedAbbreviation().generateAbbreviations(word));
    }

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        makeAbbreviations("", word, result);
        return result;
    }

    private void makeAbbreviations(String prefix, String word, List<String> result) {
        if (word.isEmpty()) {
            result.add(prefix);
        }

        for (int i = 1; i <= word.length(); i++) {
            if (prefix.isEmpty()) {
                makeAbbreviations(word.substring(0, i), word.substring(i, word.length()), result);
                makeAbbreviations(String.valueOf(i), word.substring(i, word.length()), result);
            } else if (prefix.matches(".*\\d$")) {
                makeAbbreviations(prefix + word.substring(0, i), word.substring(i, word.length()), result);
            } else {
                makeAbbreviations(prefix + String.valueOf(i), word.substring(i, word.length()), result);
            }
        }
    }
}
