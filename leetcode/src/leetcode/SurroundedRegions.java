package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X'}};
        new SurroundedRegions().solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void solve(char[][] board) {
        ArrayList<Point> surroundedList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && checkSurrounded(board, i, j)) {
                    surroundedList.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 'X';
            }
        }

        for (Point p : surroundedList) {
            board[p.row][p.col] = 'O';
        }
    }

    private boolean checkSurrounded(char[][] board, int row, int col) {
        return (row == 0 || board[row - 1][col] == 'X')
                && (row == board.length - 1 || board[row + 1][col] == 'X')
                && (col == 0 || board[row][col - 1] == 'X')
                && (col == board[row].length - 1 || board[row][col + 1] == 'X');
    }

    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
