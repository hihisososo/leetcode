package leetcode.year_2022.march;

import java.util.Arrays;
import java.util.List;

public class ValidWordSquare {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(new String[]{"abcd", "bnrt", "crm", "dt"});
//        List<String> words = Arrays.asList(new String[]{"ball","area","read","lady"});
        System.out.println(new ValidWordSquare().validWordSquare(words));
    }

    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                if (words.size() <= j || words.get(j).length() <= i || word.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
