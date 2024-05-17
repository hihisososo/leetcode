package leetcode.year_2022.november;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab", "aa", "aa", "aa", "bb", "bb"}));
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            countMap.merge(words[i], 1, Integer::sum);
        }

        Set<String> keySet = new HashSet<>(countMap.keySet());
        int sameWordCnt = 0;
        int reverseWordCnt = 0;
        boolean oddSamewordExist = false;
        for (String key : keySet) {
            if (key.charAt(0) == key.charAt(1)) {
                Integer cnt = countMap.get(key);
                if (cnt % 2 == 1) {
                    oddSamewordExist = true;
                }
                if (cnt > 1) {
                    sameWordCnt += countMap.get(key);
                }
            } else {
                String reverseWord = new String(new char[]{key.charAt(1), key.charAt(0)});
                if (countMap.containsKey(reverseWord)) {
                    reverseWordCnt += countMap.get(reverseWord);
                    countMap.remove(reverseWord);
                }
            }
            countMap.remove(key);
        }
        System.out.println(sameWordCnt);
        System.out.println(reverseWordCnt);
        return 1;
    }
}
