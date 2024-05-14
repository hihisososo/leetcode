package leetcode.year_2024.may;

public class PathWithMaximumGold {

  public static void main(String[] args) {
    System.out.println(
        new PathWithMaximumGold().getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
    System.out.println(new PathWithMaximumGold()
        .getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
  }


  public int getMaximumGold(int[][] grid) {
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != 0) {
          max = Math.max(max, dfs(grid, i, j, 0, new boolean[grid.length][grid[i].length]));
        }
      }
    }
    return max;
  }

  private int dfs(int[][] grid, int row, int col, int gold, boolean[][] visit) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length
        || visit[row][col] == true || grid[row][col] == 0) {
      return gold;
    }
    visit[row][col] = true;
    gold += grid[row][col];

    int max = Integer.MIN_VALUE;

    max = Math.max(max, dfs(grid, row - 1, col, gold, visit));
    max = Math.max(max, dfs(grid, row + 1, col, gold, visit));
    max = Math.max(max, dfs(grid, row, col - 1, gold, visit));
    max = Math.max(max, dfs(grid, row, col + 1, gold, visit));

    visit[row][col] = false;
    return max;
  }
}
