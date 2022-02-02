package leetcode.year_2022.february;

import java.util.*;

public class ShortestDistanceFromAllBuildings {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
//        int[][] grid = new int[][]{{1, 0}};
        int[][] grid = new int[][]{{1}};
        System.out.println(new ShortestDistanceFromAllBuildings().shortestDistance(grid));
    }

    public int shortestDistance(int[][] grid) {
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    points.add(i * grid.length + j);
                }
            }
        }

        boolean[][][] visited = new boolean[grid.length][grid[0].length][points.size()];
        int[][] distanceGrid = new int[grid.length][grid[0].length];
        Queue<Distance> queue = new LinkedList<>();
        for (int i = 0; i < points.size(); i++) {
            queue.add(new Distance(points.get(i) / grid.length, points.get(i) % grid.length, i, 0));
        }
        while (!queue.isEmpty()) {
            Distance poll = queue.poll();
            if (poll.row < 0 || poll.row >= grid.length || poll.col < 0 || poll.col >= grid[0].length || visited[poll.row][poll.col][poll.originPoint] || grid[poll.row][poll.col] == 2) {
                continue;
            }

            visited[poll.row][poll.col][poll.originPoint] = true;
            distanceGrid[poll.row][poll.col] += poll.distance;
            if (grid[poll.row][poll.col] == 1 && poll.distance == 0) {
                continue;
            }
            queue.add(new Distance(poll.row + 1, poll.col, poll.originPoint, poll.distance+1));
            queue.add(new Distance(poll.row - 1, poll.col, poll.originPoint, poll.distance+1));
            queue.add(new Distance(poll.row, poll.col + 1, poll.originPoint, poll.distance+1));
            queue.add(new Distance(poll.row, poll.col - 1, poll.originPoint, poll.distance+1));

        }

        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                boolean allVisit = true;
                for (int k = 0; k < visited[i][j].length; k++) {
                    if (!visited[i][j][k]) {
                        allVisit = false;
                        break;
                    }
                }
                if (allVisit) {
                    minScore = Math.min(minScore, distanceGrid[i][j]);
                }
            }
        }
        return minScore;
    }

    class Distance {
        int row;
        int col;
        int originPoint;
        int distance;

        public Distance(int row, int col, int originPoint, int distance) {
            this.row = row;
            this.col = col;
            this.originPoint = originPoint;
            this.distance = distance;
        }
    }
}
