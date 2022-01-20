package leetcode.year_2022.january;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(new BestMeetingPoint().minTotalDistance(grid));
    }

    public int minTotalDistance(int[][] grid) {
        List<Pair<Integer, Integer>> friendPoints = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    friendPoints.add(new Pair<>(i, j));
                }
            }
        }
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        return findMin(0, 0, friendPoints, grid, visit);

    }

    private int findMin(int x, int y, List<Pair<Integer, Integer>> friendPoints, int[][] grid, boolean[][] visit) {
        if (x < 0 || x >= grid.length | y < 0 || y >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(visit[x][y] == true){
            return Integer.MAX_VALUE;
        }
        visit[x][y] = true;

        int min = Integer.MAX_VALUE;

        int curr = calc(friendPoints, x, y);
        int left = calc(friendPoints, x - 1, y);
        int right = calc(friendPoints, x + 1, y);
        int down = calc(friendPoints, x, y - 1);
        int up = calc(friendPoints, x, y + 1);

        min = curr;
        min = Math.min(min, left);
        min = Math.min(min, right);
        min = Math.min(min, down);
        min = Math.min(min, up);

        int result = Integer.MAX_VALUE;
        if(min == curr){
            result = curr;
        }
        if (left == min) {
            result = Math.min(result, findMin(x - 1, y, friendPoints, grid, visit));
        }
        if (right == min) {
            result = Math.min(result, findMin(x + 1, y, friendPoints, grid, visit));
        }
        if (down == min) {
            result = Math.min(result, findMin(x, y - 1, friendPoints, grid, visit));
        }
        if (up == min) {
            result = Math.min(result, findMin(x, y + 1, friendPoints, grid, visit));
        }
        return result;
    }

    private int calc(List<Pair<Integer, Integer>> friendPoints, int i, int j) {
        int sum = 0;
        for (Pair<Integer, Integer> p : friendPoints) {
            sum += Math.abs(p.getKey() - i);
            sum += Math.abs(p.getValue() - j);
        }
        return sum;
    }
}
