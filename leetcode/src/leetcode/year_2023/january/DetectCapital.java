package leetcode.year_2023.january;

public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("test"));
    }

    public boolean detectCapitalUse(String word) {
        int upperCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isUpper(word.charAt(i))) {
                upperCnt++;
            }
        }
        if (upperCnt == word.length() || upperCnt == 0) {
            return true;
        }
        if (upperCnt == 1 && isUpper(word.charAt(0))) {
            return true;
        }
        return false;
    }

    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
