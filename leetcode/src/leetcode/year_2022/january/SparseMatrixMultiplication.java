package leetcode.year_2022.january;

import java.util.Arrays;

public class SparseMatrixMultiplication {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] result = new SparseMatrixMultiplication().multiply(mat1, mat2);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int row = mat1.length;
        int col = mat2[0].length;

        int[][] result = new int[row][col];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = calc(mat1, mat2, i, j);
            }
        }
        return result;
    }

    private int calc(int[][] mat1, int[][] mat2, int row, int col) {
        int sum = 0;
        for (int i = 0; i < mat1[row].length; i++) {
            sum += (mat1[row][i] * mat2[i][col]);
        }
        return sum;
    }
}
