package leetcode.year_2024.june;

public class ScoreOfAString {
    public static void main(String[] args) {
        System.out.println(new ScoreOfAString().scoreOfString("hello"));
        System.out.println(new ScoreOfAString().scoreOfString("zaz"));
    }

    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return score;
    }
}
