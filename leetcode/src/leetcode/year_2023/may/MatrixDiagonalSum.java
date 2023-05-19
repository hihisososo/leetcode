package leetcode.year_2023.may;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        System.out.println(new MatrixDiagonalSum().diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new MatrixDiagonalSum().diagonalSum(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
        System.out.println(new MatrixDiagonalSum().diagonalSum(new int[][]{{5}}));

    }

    public int diagonalSum(int[][] mat) {
        int leftIdx = 0;
        int rightIdx = mat.length - 1;

        int sum = 0;
        for (int row = 0; row < mat.length; row++) {
            sum += mat[row][leftIdx + row] + mat[row][rightIdx - row];
        }
        sum = sum - (mat.length % 2 == 0 ? 0 : mat[mat.length / 2][mat.length / 2]);
        return sum;
    }

}
