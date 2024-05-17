package leetcode.year_2024.may;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheSafestPathInAGrid {
    public static void main(String[] args) {
        System.out.println(new FindTheSafestPathInAGrid().maximumSafenessFactor(List.of(List.of(1, 0, 0), List.of(0, 0, 0), List.of(0, 0, 1))));
        System.out.println(new FindTheSafestPathInAGrid().maximumSafenessFactor(List.of(List.of(0, 0, 1), List.of(0, 0, 0), List.of(0, 0, 0))));
        System.out.println(new FindTheSafestPathInAGrid().maximumSafenessFactor(List.of(List.of(0, 0, 1), List.of(0, 0, 1), List.of(0, 0, 0))));
        System.out.println(new FindTheSafestPathInAGrid().maximumSafenessFactor(List.of(List.of(0, 0, 0, 1), List.of(0, 0, 0, 0), List.of(0, 0, 0, 0), List.of(1, 0, 0, 0))));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] gridArr = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j, 0});
                    gridArr[i][j] = 0;
                } else {
                    gridArr[i][j] = -1;
                }
            }
        }
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0) {
                int[] poll = queue.poll();
                for (int[] d : direction) {
                    int row = poll[0] + d[0];
                    int col = poll[1] + d[1];
                    int val = poll[2];
                    if (validIndex(row, col, gridArr) && gridArr[row][col] == -1) {
                        gridArr[row][col] = val + 1;
                        queue.add(new int[]{row, col, val + 1});
                    }
                }
                size--;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, gridArr[0][0]});
        gridArr[0][0] = -1;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int row = poll[0];
            int col = poll[1];
            int sat = poll[2];

            if (row == gridArr.length - 1 && col == gridArr[0].length - 1) {
                return sat;
            }
            for (int[] d : direction) {
                int r = row + d[0];
                int c = col + d[1];
                if (validIndex(r, c, gridArr) && gridArr[r][c] != -1) {
                    pq.add(new int[]{r, c, Math.min(gridArr[r][c], sat)});
                    gridArr[r][c] = -1;
                }
            }
        }
        return 0;
    }

    private boolean validIndex(int row, int col, int[][] gridArr) {
        if (row < 0 || row >= gridArr.length || col < 0 || col >= gridArr[0].length)
            return false;
        return true;
    }
}
