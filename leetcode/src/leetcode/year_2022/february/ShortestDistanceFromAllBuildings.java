package leetcode.year_2022.february;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(new ShortestDistanceFromAllBuildings().shortestDistance(grid));
    }

    public int shortestDistance(int[][] grid) {
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    points.add(i * grid.length + j);
                }
            }
        }
        if (!isAllBuildingTraverse(points, grid)) {
            return -1;
        }

        return shortestDistance(points, grid);
    }

    private int shortestDistance(List<Integer> points, int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int p : points) {
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            int p = queue.poll();
            int row = p / grid.length;
            int col = p % grid.length;
            if()
        }
    }

    private boolean isAllBuildingTraverse(List<Integer> points, int[][] grid) {

        int target = points.get(0);
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int row = target / grid.length;
        int col = target % grid.length;
        dfs(row, col, grid, visit);
        for (int p : points) {
            if (!visit[p / grid.length][p % grid.length]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visit) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visit[row][col] || grid[row][col] != 0) {
            return;
        }
        visit[row][col] = true;

        dfs(row + 1, col, grid, visit);
        dfs(row - 1, col, grid, visit);
        dfs(row, col + 1, grid, visit);
        dfs(row, col - 1, grid, visit);
    }
}
