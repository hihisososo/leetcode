package leetcode.year_2024.january;

import java.util.Arrays;

public class BagOfTokens {

    public static void main(String[] args) {
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{100}, 50));
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{200, 100}, 150));
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{71, 55, 82}, 54));
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
            } else {
                power += tokens[right];
                right--;
                score--;
            }

            if (score < 0) {
                break;
            }
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;
    }
}
