package leetcode.year_2022.september;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{100}, 50));
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(new BagOfTokens().bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int leftTokenIdx = 0;
        int rightTokenIdx = tokens.length - 1;
        int maxScore = 0;
        while (leftTokenIdx <= rightTokenIdx) {
            if (canScore(tokens, leftTokenIdx, power)) {
                score++;
                power -= tokens[leftTokenIdx++];
            } else if (score > 0) {
                score--;
                power += tokens[rightTokenIdx--];
            } else {
                break;
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    private boolean canScore(int[] tokens, int leftTokenIdx, int power) {
        return tokens[leftTokenIdx] <= power;
    }
}
