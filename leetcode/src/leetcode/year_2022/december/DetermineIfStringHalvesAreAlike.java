package leetcode.year_2022.december;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("book"));
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("textbook"));
    }

    public boolean halvesAreAlike(String s) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));

        int leftCnt = 0;
        int rightCnt = 0;
        int midIdx = s.length() / 2;
        for (int i = 0; i < midIdx; i++) {
            if (vowelSet.contains(s.charAt(i))) {
                leftCnt++;
            }
        }
        for (int i = midIdx; i < s.length(); i++) {
            if (vowelSet.contains(s.charAt(i))) {
                rightCnt++;
            }
        }
        return leftCnt == rightCnt;
    }
}
