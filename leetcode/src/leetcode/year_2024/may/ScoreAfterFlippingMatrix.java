package leetcode.year_2024.may;

public class ScoreAfterFlippingMatrix {

  public static void main(String[] args) {
    System.out.println(new ScoreAfterFlippingMatrix()
        .matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    System.out.println(new ScoreAfterFlippingMatrix().matrixScore(new int[][]{{0}}));
  }

  public int matrixScore(int[][] grid) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < grid.length; i++) {
      if (grid[i][0] == 0) {
        toggleRow(grid, i);
      }
    }

    for (int i = 1; i < grid[0].length; i++) {
      int zeroCnt = 0;
      for (int j = 0; j < grid.length; j++) {
        if (grid[j][i] == 0) {
          zeroCnt++;
        }
      }
      if (zeroCnt > grid.length / 2) {
        toggleCol(grid, i);
      }
    }

    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      String binaryStr = "";
      for (int j = 0; j < grid[i].length; j++) {
        binaryStr += String.valueOf(grid[i][j]);
      }
      System.out.println(binaryStr);
      sum += Integer.parseInt(binaryStr, 2);
    }
    return sum;
  }

  private void toggleCol(int[][] grid, int col) {
    for (int i = 0; i < grid.length; i++) {
      grid[i][col] = grid[i][col] == 0 ? 1 : 0;
    }
  }

  private void toggleRow(int[][] grid, int row) {
    for (int i = 0; i < grid[row].length; i++) {
      grid[row][i] = grid[row][i] == 0 ? 1 : 0;
    }
  }


}
