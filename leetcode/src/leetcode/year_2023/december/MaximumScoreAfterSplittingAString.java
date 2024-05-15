package leetcode.year_2023.december;

public class MaximumScoreAfterSplittingAString {

    public static void main(String[] args) {
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("011101"));
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("00111"));
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("1111"));

    }

    public int maxScore(String s) {
        int rightScore = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightScore++;
            }
        }

        int leftScore = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftScore++;
            } else {
                rightScore--;
            }
            maxScore = Math.max(leftScore + rightScore, maxScore);
        }
        return maxScore;
    }
}
