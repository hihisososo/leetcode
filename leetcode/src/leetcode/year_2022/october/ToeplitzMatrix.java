package leetcode.year_2022.october;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{18}, {66}}));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(0, i, matrix)) {
                return false;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (!check(i, 0, matrix)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int row, int col, int[][] matrix) {
        int val = matrix[row][col];
        while (row < matrix.length && col < matrix[0].length) {
            if (val != matrix[row][col]) {
                return false;
            }
            row++;
            col++;
        }
        return true;
    }
}
