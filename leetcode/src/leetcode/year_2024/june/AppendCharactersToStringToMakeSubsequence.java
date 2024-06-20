package leetcode.year_2024.june;

public class AppendCharactersToStringToMakeSubsequence {
    public static void main(String[] args) {
        System.out.println(new AppendCharactersToStringToMakeSubsequence().appendCharacters("coaching", "coding"));
        System.out.println(new AppendCharactersToStringToMakeSubsequence().appendCharacters("abcde", "a"));
        System.out.println(new AppendCharactersToStringToMakeSubsequence().appendCharacters("z", "abcde"));
    }

    public int appendCharacters(String s, String t) {
        int idx = 0;
        for (int i = 0; i < s.length() && idx < t.length(); i++) {
            if (t.charAt(idx) == s.charAt(i)) {
                idx++;
            }
        }
        return t.length() - idx;
    }
}
