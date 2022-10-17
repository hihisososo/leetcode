package leetcode.year_2022.october;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {
        System.out.println(new CheckIfTheSentenceIsPangram().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(new CheckIfTheSentenceIsPangram().checkIfPangram("leetcode"));
    }

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }
}
