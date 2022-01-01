package leetcode.year_2021;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkCol(board) && check3x3(board);

    }

    private boolean check3x3(char[][] board) {
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[i].length; j = j + 3) {
                if (!check(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[][] board, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int row = i; row < i + 3; row++) {
            for (int col = j; col < j + 3; col++) {
                if (board[row][col] != '.') {
                    if (set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

}
