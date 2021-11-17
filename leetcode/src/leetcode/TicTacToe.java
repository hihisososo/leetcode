package leetcode;

class TicTacToe {
    int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkWin(player)) {
            return player;
        }
        return 0;
    }

    private boolean checkWin(int player) {
        for (int i = 0; i < board.length; i++) {
            if (checkVertical(i, player)) return true;
            if (checkHorizonal(i, player)) return true;
        }

        if (checkIncreaseDiagonal(player)) return true;
        if (checkDecreaseDiagonal(player)) return true;

        return false;
    }

    private boolean checkIncreaseDiagonal(int player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDecreaseDiagonal(int player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - 1 - i] != player) {
                return false;
            }
        }

        return true;
    }

    private boolean checkHorizonal(int i, int player) {
        for (int j = 0; j < board.length; j++) {
            if (board[i][j] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVertical(int i, int player) {
        for (int j = 0; j < board.length; j++) {
            if (board[j][i] != player) {
                return false;
            }
        }
        return true;
    }
}
