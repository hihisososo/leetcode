package leetcode.year_2022.december;

import java.util.HashMap;
import java.util.Map;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }

    public int minFallingPathSum(int[][] matrix) {
        Map<Integer, Integer> minMap = new HashMap<>();
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, 0, i, 0, minMap);
        }
        int start = matrix.length * (matrix[0].length - 1);
        int end = matrix.length * matrix[0].length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, minMap.get(i));
        }
        return min;
    }

    private void dfs(int[][] matrix, int row, int col, int pathSum, Map<Integer, Integer> minMap) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return;
        }
        pathSum += matrix[row][col];
        int pointInt = matrix.length * row + col;
        if (minMap.getOrDefault(pointInt, Integer.MAX_VALUE) <= pathSum) {
            return;
        }
        minMap.put(pointInt, pathSum);

        dfs(matrix, row + 1, col - 1, pathSum, minMap);
        dfs(matrix, row + 1, col, pathSum, minMap);
        dfs(matrix, row + 1, col + 1, pathSum, minMap);
    }
}
