package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new SurroundedRegions().solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void solve(char[][] board) {
        ArrayList<Point> flipList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    ArrayList<Point> regionPointList = getRegionPoint(board, i, j);
                    if (isSurrounded(board, regionPointList)) {
                        check(board, regionPointList, 'X');
                    } else {
                        check(board, regionPointList, 'O');
                    }
                }
            }
        }

        for (Point p : flipList) {
            board[p.row][p.col] = 'X';
        }
    }

    private void check(char[][] board, ArrayList<Point> regionPointList, char x) {
        for (Point p : regionPointList) {
            board[p.row][p.col] = x;
        }
    }

    private boolean isSurrounded(char[][] board, ArrayList<Point> regionPointList) {
        for (Point p : regionPointList) {
            if (!checkSurrounded(board, p.row, p.col)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Point> getRegionPoint(char[][] board, int row, int col) {
        ArrayList<Point> regionPointList = new ArrayList<>();
        waterFlood(board, row, col, regionPointList);
        return regionPointList;
    }

    private void waterFlood(char[][] board, int row, int col, ArrayList<Point> regionPointList) {
        if (row > board.length - 1 || row < 0 || col > board[row].length - 1 || col < 0) {
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = 'R';
            regionPointList.add(new Point(row, col));
        } else {
            return;
        }

        //up
        waterFlood(board, row - 1, col, regionPointList);
        //down
        waterFlood(board, row + 1, col, regionPointList);
        //left
        waterFlood(board, row, col - 1, regionPointList);
        //right
        waterFlood(board, row, col + 1, regionPointList);
    }

    private boolean checkSurrounded(char[][] board, int row, int col) {
        return (row > 0 && (board[row - 1][col] == 'X' || board[row - 1][col] == 'R'))
                && (row < board.length - 1 && (board[row + 1][col] == 'X' || board[row + 1][col] == 'R'))
                && (col > 0 && (board[row][col - 1] == 'X' || board[row][col - 1] == 'R'))
                && (col < board[row].length - 1 && (board[row][col + 1] == 'X' || board[row][col + 1] == 'R'));
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
