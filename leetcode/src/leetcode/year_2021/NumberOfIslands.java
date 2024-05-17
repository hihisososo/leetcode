package leetcode.year_2021;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    fillIsland(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void fillIsland(char[][] grid, int row, int col) {
        grid[row][col] = '2';
        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            fillIsland(grid, row, col - 1);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
            fillIsland(grid, row, col + 1);
        }
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            fillIsland(grid, row - 1, col);
        }
        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
            fillIsland(grid, row + 1, col);
        }
    }
}
