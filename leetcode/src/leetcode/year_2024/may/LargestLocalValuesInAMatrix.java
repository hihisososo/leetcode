package leetcode.year_2024.may;

public class LargestLocalValuesInAMatrix {
    public static void main(String[] args) {
        System.out.println(new LargestLocalValuesInAMatrix().largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}}));
    }

    public int[][] largestLocal(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}
