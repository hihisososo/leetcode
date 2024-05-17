package leetcode.year_2022.november;

import common.Pair;

import java.util.Arrays;

public class WhereWillTheBallFall {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new WhereWillTheBallFall().findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}})));
        System.out.println(Arrays.toString(new WhereWillTheBallFall().findBall(new int[][]{{-1}})));
        System.out.println(Arrays.toString(new WhereWillTheBallFall().findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}})));
    }

    public int[] findBall(int[][] grid) {
        int RIGHT = 1;
        int LEFT = -1;
        Pair<Integer, Integer>[] ballLive = new Pair[grid[0].length];
        for (int i = 0; i < ballLive.length; i++) {
            ballLive[i] = new Pair(i, i);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < ballLive.length; j++) {
                if (ballLive[j] == null) {
                    continue;
                }
                int ballOrgCol = ballLive[j].getKey();
                int ballCol = ballLive[j].getValue();
                if (grid[i][ballCol] == LEFT) {
                    if (ballCol == 0 || grid[i][ballCol - 1] == RIGHT) {
                        ballLive[j] = null;
                    } else {
                        ballLive[j] = new Pair<>(ballOrgCol, ballCol - 1);
                    }
                } else {
                    if (ballCol == grid[0].length - 1 || grid[i][ballCol + 1] == LEFT) {
                        ballLive[j] = null;
                    } else {
                        ballLive[j] = new Pair<>(ballOrgCol, ballCol + 1);
                    }
                }
            }
        }

        int[] result = new int[grid[0].length];
        Arrays.fill(result, -1);
        for (int i = 0; i < ballLive.length; i++) {
            if (ballLive[i] == null) {
                continue;
            }
            result[ballLive[i].getKey()] = ballLive[i].getValue();
        }
        return result;
    }
}
