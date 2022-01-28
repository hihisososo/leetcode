package leetcode.year_2022.january;

public class RangeSumQuery2dMutable {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}};
        RangeSumQuery2dMutable obj = new RangeSumQuery2dMutable(matrix);
        System.out.println(obj.sumRegion(0, 0, 0, 0));
        System.out.println(obj.sumRegion(0, 1, 0, 1));
        System.out.println(obj.sumRegion(0, 0, 0, 1));
        obj.update(0, 0, 3);
        obj.update(0, 1, 5);
        obj.update(0, 1, 5);
        System.out.println(obj.sumRegion(0, 0, 0, 1));

    }

    int[][] sumMatrix;

    public RangeSumQuery2dMutable(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
                sumMatrix[row][col] = sum;
            }
        }
    }

    public void update(int row, int col, int val) {
        int orgVal = col == 0 ? sumMatrix[row][col] : sumMatrix[row][col] - sumMatrix[row][col - 1];
        int diff = val - orgVal;
        for (int c = col; c < sumMatrix[row].length; c++) {
            sumMatrix[row][c] += diff;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                sum += (sumMatrix[i][col2]);
            } else {
                sum += (sumMatrix[i][col2] - sumMatrix[i][col1 - 1]);
            }
        }
        return sum;
    }
}
