package leetcode.year_2022.august;

public class TheMazeIi {
    public static void main(String[] args) {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        System.out.println(new TheMazeIi().shortestDistance(maze, new int[]{0, 4}, new int[]{4, 4}));
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] posMin = new int[maze.length][maze[0].length];
        for (int i = 0; i < posMin.length; i++) {
            for (int j = 0; j < posMin[i].length; j++) {
                posMin[i][j] = Integer.MAX_VALUE;
            }
        }
        findDfsShortest(maze, start, destination, 0, posMin);
        return posMin[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : posMin[destination[0]][destination[1]];
    }

    private void findDfsShortest(int[][] maze, int[] currPos, int[] destination, int len, int[][] posMin) {
        int min = posMin[currPos[0]][currPos[1]];
        if (len >= min) {
            return;
        }

        posMin[currPos[0]][currPos[1]] = len;
        if (isDestination(currPos, destination)) {
            return;
        }

        int posRight = getPosRight(maze, currPos);
        findDfsShortest(maze, new int[]{currPos[0], posRight}, destination, len + Math.abs(currPos[1] - posRight), posMin);

        int posLeft = getPosLeft(maze, currPos);
        findDfsShortest(maze, new int[]{currPos[0], posLeft}, destination, len + Math.abs(currPos[1] - posLeft), posMin);

        int posDown = getPosDown(maze, currPos);
        findDfsShortest(maze, new int[]{posDown, currPos[1]}, destination, len + Math.abs(currPos[0] - posDown), posMin);

        int posUp = getPosUp(maze, currPos);
        findDfsShortest(maze, new int[]{posUp, currPos[1]}, destination, len + Math.abs(currPos[0] - posUp), posMin);
    }

    private int getPosUp(int[][] maze, int[] currPos) {
        int row = currPos[0];
        while (row > 0 && maze[row - 1][currPos[1]] != 1) {
            row--;
        }
        return row;
    }

    private int getPosDown(int[][] maze, int[] currPos) {
        int row = currPos[0];
        while (row < maze.length - 1 && maze[row + 1][currPos[1]] != 1) {
            row++;
        }
        return row;
    }

    private int getPosLeft(int[][] maze, int[] currPos) {
        int col = currPos[1];
        while (col > 0 && maze[currPos[0]][col - 1] != 1) {
            col--;
        }
        return col;
    }

    private int getPosRight(int[][] maze, int[] currPos) {
        int col = currPos[1];
        while (col < maze[0].length - 1 && maze[currPos[0]][col + 1] != 1) {
            col++;
        }
        return col;
    }

    private boolean isDestination(int[] currPos, int[] destination) {
        return currPos[0] == destination[0] && currPos[1] == destination[1];
    }


}
