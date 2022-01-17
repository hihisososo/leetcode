package leetcode.year_2022.january;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        new WallsAndGates().wallsAndGates(rooms);
        for (int[] i : rooms) {
            System.out.printf(Arrays.toString(i));
        }
    }

    public void wallsAndGates(int[][] rooms) {
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (rooms[row][col] == -1 || rooms[row][col] == 0) {
                    continue;
                }
                boolean[][] visit = new boolean[rooms.length][rooms[0].length];
                Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                Queue<Pair<Integer, Integer>> nextQueue = new LinkedList<>();
                queue.add(new Pair<>(row, col));
                int distance = 0;
                boolean isFind = false;

                while (!queue.isEmpty() || !nextQueue.isEmpty()) {
                    queue.addAll(nextQueue);
                    nextQueue.clear();
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> point = queue.poll();
                        int r = point.getKey();
                        int c = point.getValue();
                        if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || visit[r][c] || rooms[r][c] == -1) {
                            continue;
                        }
                        if (rooms[r][c] == 0) {
                            rooms[row][col] = distance;
                            isFind = true;
                            break;
                        }

                        visit[point.getKey()][point.getValue()] = true;
                        nextQueue.add(new Pair<>(r - 1, c));
                        nextQueue.add(new Pair<>(r, c - 1));
                        nextQueue.add(new Pair<>(r + 1, c));
                        nextQueue.add(new Pair<>(r, c + 1));
                    }
                    distance++;

                    if (isFind) {
                        break;
                    }
                }
            }
        }
    }
}
