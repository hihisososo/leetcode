package leetcode.year_2022.august;

public class TheMaze {
    public static void main(String[] args) {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[][] maze2 = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[][] maze3 = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[][] maze4 = new int[][]{{0, 0, 0, 0, 1, 0, 0}, {0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0}};
        int[][] maze5 = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        System.out.println(new TheMaze().hasPath(maze, new int[]{0, 4}, new int[]{4, 4}));
        System.out.println(new TheMaze().hasPath(maze2, new int[]{0, 4}, new int[]{3, 2}));
        System.out.println(new TheMaze().hasPath(maze3, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println(new TheMaze().hasPath(maze4, new int[]{0, 0}, new int[]{8, 6}));
        System.out.println(new TheMaze().hasPath(maze5, new int[]{1, 1}, new int[]{1, 2}));
    }

    private static final int WALL = 1;
    private static final int GOAL_BALL_POSITION = 2;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        fillGoalBallPosition(maze, destination[0], destination[1]);
        return maze[start[0]][start[1]] == GOAL_BALL_POSITION ||
                left(maze, start) == GOAL_BALL_POSITION ||
                right(maze, start) == GOAL_BALL_POSITION ||
                up(maze, start) == GOAL_BALL_POSITION ||
                down(maze, start) == GOAL_BALL_POSITION;
    }

    private int left(int[][] maze, int[] start) {
        int row = start[0];
        int col = start[1];
        while (col - 1 >= 0 && maze[row][col - 1] != WALL) {
            col--;
        }
        return maze[row][col];
    }

    private int right(int[][] maze, int[] start) {
        int row = start[0];
        int col = start[1];
        while (col + 1 < maze[0].length && maze[row][col + 1] != WALL) {
            col++;
        }
        return maze[row][col];
    }

    private int up(int[][] maze, int[] start) {
        int row = start[0];
        int col = start[1];
        while (row - 1 >= 0 && maze[row - 1][col] != WALL) {
            row--;
        }
        return maze[row][col];
    }

    private int down(int[][] maze, int[] start) {
        int row = start[0];
        int col = start[1];
        while (row + 1 < maze.length && maze[row + 1][col] != WALL) {
            row++;
        }
        return maze[row][col];
    }


    private void fillGoalBallPosition(int[][] maze, int row, int col) {
        if (isAlreadyVisitOrWall(maze, row, col)) {
            return;
        }
        maze[row][col] = GOAL_BALL_POSITION;
        if (isLeftWall(maze, row, col)) {
            fillRight(maze, row, col);
        }
        if (isRightWall(maze, row, col)) {
            fillLeft(maze, row, col);
        }
        if (isUpWall(maze, row, col)) {
            fillDown(maze, row, col);
        }
        if (isDownWall(maze, row, col)) {
            fillUp(maze, row, col);
        }
    }

    private void fillUp(int[][] maze, int row, int col) {
        while (canFill(maze, --row, col)) {
            if (isAdjacentWall(maze, row, col)) {
                fillGoalBallPosition(maze, row, col);
            }
        }
    }

    private void fillDown(int[][] maze, int row, int col) {
        while (canFill(maze, ++row, col)) {
            if (isAdjacentWall(maze, row, col)) {
                fillGoalBallPosition(maze, row, col);
            }
        }
    }

    private void fillLeft(int[][] maze, int row, int col) {
        while (canFill(maze, row, --col)) {
            if (isAdjacentWall(maze, row, col)) {
                fillGoalBallPosition(maze, row, col);
            }
        }
    }

    private boolean isDownWall(int[][] maze, int row, int col) {
        return row + 1 == maze.length || maze[row + 1][col] == WALL;
    }

    private boolean isUpWall(int[][] maze, int row, int col) {
        return row - 1 < 0 || maze[row - 1][col] == WALL;
    }

    private boolean isRightWall(int[][] maze, int row, int col) {
        return col + 1 == maze[0].length || maze[row][col + 1] == WALL;
    }

    private void fillRight(int[][] maze, int row, int col) {
        while (canFill(maze, row, ++col)) {
            if (isAdjacentWall(maze, row, col)) {
                fillGoalBallPosition(maze, row, col);
            }
        }
    }

    private boolean isAdjacentWall(int[][] maze, int row, int col) {
        return isLeftWall(maze, row, col) || isRightWall(maze, row, col) || isUpWall(maze, row, col) || isDownWall(maze, row, col);
    }

    private boolean canFill(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != WALL;
    }

    private boolean isLeftWall(int[][] maze, int row, int col) {
        return col == 0 || maze[row][col - 1] == WALL;
    }

    private boolean isAlreadyVisitOrWall(int[][] maze, int row, int col) {
        return maze[row][col] == GOAL_BALL_POSITION || maze[row][col] == WALL;
    }
}
