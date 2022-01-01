package leetcode.year_2021;

import java.util.Arrays;

public class ReverseWordsInAStringIi {
    public static void main(String[] args) {
        char[] s = "a".toCharArray();
        new ReverseWordsInAStringIi().reverseWords(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int startIdx = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, startIdx, i - 1);
                startIdx = i + 1;
            }
        }
        reverse(s, startIdx, s.length - 1);
    }

    private void reverse(char[] s, int startIdx, int endIdx) {
        char temp;
        for (int i = startIdx; i <= (endIdx + startIdx) / 2; i++) {
            temp = s[i];
            s[i] = s[endIdx - i + startIdx];
            s[endIdx - i + startIdx] = temp;
        }
    }
}
