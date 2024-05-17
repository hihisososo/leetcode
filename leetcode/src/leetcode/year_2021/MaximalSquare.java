package leetcode.year_2021;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int maxSquare = 0;
        int[] sums = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    sums[j] += 1;
                } else {
                    sums[j] = 0;
                }
            }
            for (int k = 0; k < sums.length; k++) {
                maxSquare = Math.max(maxSquare, calcMaxSquare(sums, k));
            }
        }
        return maxSquare;
    }

    private int calcMaxSquare(int[] sums, int k) {
        int startVal = sums[k];
        int square = 0;
        for (int i = 0; i < startVal; i++) {
            if (i + k >= sums.length) {
                break;
            }

            int startIdx = k;
            int endIdx = i + k;
            boolean allMoreThan = true;
            for (int j = startIdx; j <= endIdx; j++) {
                if (sums[j] <= i) {
                    allMoreThan = false;
                    break;
                }
            }
            if (allMoreThan) {
                square = Math.max(square, (i + 1) * (i + 1));
            }
        }
        return square;
    }
}
