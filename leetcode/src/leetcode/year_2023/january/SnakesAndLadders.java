package leetcode.year_2023.january;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SnakesAndLadders {

    public static void main(String[] args) {
        System.out.println(new SnakesAndLadders().snakesAndLadders(
                new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
                        {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
        System.out.println(new SnakesAndLadders().snakesAndLadders(
                new int[][]{{-1, -1}, {1, 3}}));
        System.out.println(new SnakesAndLadders().snakesAndLadders(
                new int[][]{{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}}));
    }

    public int snakesAndLadders(int[][] board) {
        AtomicInteger result = new AtomicInteger();
        result.set(Integer.MAX_VALUE);
        Map<Integer, Integer> minMap = new HashMap<>();
        findDFS(board, 1, 0, minMap, result);
        return result.get() == Integer.MAX_VALUE ? -1 : result.get();
    }

    private void findDFS(int[][] board, int position,
                         int cost, Map<Integer, Integer> minMap,
                         AtomicInteger result) {
        if (position < 0 || position > board.length * board.length) {
            return;
        }
        position = moveIfLadderOrSnake(board, position);
        if (position == board.length * board.length) {
            result.set(Math.min(cost, result.get()));
        }
        if (minMap.getOrDefault(position, Integer.MAX_VALUE) <= cost) {
            return;
        }
        minMap.put(position, cost);

        for (int i = 1; i <= 6; i++) {
            findDFS(board, position + i, cost + 1, minMap, result);
        }
    }

    private int moveIfLadderOrSnake(int[][] board, int position) {
        int row = board.length - 1 - (position - 1) / board.length;
        int colAmount = position - ((board.length - 1 - row) * board.length);
        int col = row % 2 == 0 ? colAmount - 1 : board[0].length - colAmount;
        if (board.length % 2 == 0) {
            if (row % 2 == 0) {
                col = board[0].length - colAmount;
            } else {
                col = colAmount - 1;
            }
        } else {
            if (row % 2 == 0) {
                col = colAmount - 1;
            } else {
                col = board[0].length - colAmount;
            }
        }
        if (board[row][col] != -1) {
            return board[row][col];
        }
        return position;
    }

}
