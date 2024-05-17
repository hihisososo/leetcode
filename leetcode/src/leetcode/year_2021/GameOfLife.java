package leetcode.year_2021;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new GameOfLife().gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                nextGeneration(i, j, board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 3 || board[i][j] == 5) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 4 || board[i][j] == 6) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void nextGeneration(int i, int j, int[][] board) {
        if (board[i][j] == 0) {
            deadCellProcess(i, j, board);
        } else {
            liveCellProcess(i, j, board);
        }
    }

    private void liveCellProcess(int i, int j, int[][] board) {
        int nCnt = getNeighborCnt(i, j, board);
        if (nCnt < 2 || nCnt > 3) {
            board[i][j] = 5;
        }
        if (nCnt == 2 || nCnt == 3) {
            board[i][j] = 6;
        }
    }

    private void deadCellProcess(int i, int j, int[][] board) {
        int nCnt = getNeighborCnt(i, j, board);
        if (nCnt == 3) {
            board[i][j] = 4;
        } else {

        }
    }

    private int getNeighborCnt(int i, int j, int[][] board) {
        int cnt = 0;
        if (isLive(i - 1, j - 1, board)) {
            cnt++;
        }
        if (isLive(i - 1, j, board)) {
            cnt++;
        }
        if (isLive(i - 1, j + 1, board)) {
            cnt++;
        }
        if (isLive(i, j - 1, board)) {
            cnt++;
        }
        if (isLive(i, j + 1, board)) {
            cnt++;
        }
        if (isLive(i + 1, j - 1, board)) {
            cnt++;
        }
        if (isLive(i + 1, j, board)) {
            cnt++;
        }
        if (isLive(i + 1, j + 1, board)) {
            cnt++;
        }
        return cnt;
    }

    private boolean isLive(int i, int j, int[][] board) {
        if (i >= board.length || i < 0) {
            return false;
        }

        if (j >= board[i].length || j < 0) {
            return false;
        }

        return board[i][j] == 1 || board[i][j] == 5 || board[i][j] == 6;
    }

}
