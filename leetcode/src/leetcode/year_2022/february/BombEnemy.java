package leetcode.year_2022.february;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class BombEnemy {
    public static void main(String[] args) {
//        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        char[][] grid = {{'W', 'W', 'W'}, {'0', '0', '0'}, {'E', 'E', 'E'}};
        System.out.println(new BombEnemy().maxKilledEnemies(grid));
    }

    public int maxKilledEnemies(char[][] grid) {
        AtomicInteger[][] verticalGrid = new AtomicInteger[grid.length][grid[0].length];
        AtomicInteger[][] horizonalGrid = new AtomicInteger[grid.length][grid[0].length];

        for (int col = 0; col < verticalGrid[0].length; col++) {
            AtomicInteger num = new AtomicInteger(0);
            for (int row = 0; row < verticalGrid.length; row++) {
                if (grid[row][col] == 'W') {
                    num = new AtomicInteger(0);
                } else if (grid[row][col] == 'E') {
                    num.addAndGet(1);
                } else {
                    verticalGrid[row][col] = num;
                }
            }
        }

        for (int row = 0; row < horizonalGrid.length; row++) {
            AtomicInteger num = new AtomicInteger(0);
            for (int col = 0; col < horizonalGrid[0].length; col++) {
                if (grid[row][col] == 'W') {
                    num = new AtomicInteger(0);
                } else if (grid[row][col] == 'E') {
                    num.addAndGet(1);
                } else {
                    horizonalGrid[row][col] = num;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0')
                    max = Math.max(verticalGrid[i][j].get() + horizonalGrid[i][j].get(), max);
            }
        }
        return max;
    }
}
