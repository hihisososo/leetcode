package leetcode.year_2022.february;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SnakeGame {
    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0}});
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("D"));

        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("D"));
    }

    int foodIdx;
    Deque<Pair<Integer, Integer>> snake;
    HashSet<Pair<Integer, Integer>> snakePointSet;
    int currHeight;
    int currWidth;
    int height;
    int width;
    int[][] food;

    public SnakeGame(int width, int height, int[][] food) {
        snakePointSet = new HashSet<>();
        snakePointSet.add(new Pair(0, 0));
        snake = new ArrayDeque<>();
        snake.add(new Pair(0, 0));
        currHeight = 0;
        currWidth = 0;
        foodIdx = 0;
        this.food = food;
        this.height = height;
        this.width = width;
    }

    public int move(String direction) {
        switch (direction) {
            case "L":
                return moveLeft();
            case "R":
                return moveRight();
            case "D":
                return moveDown();
            case "U":
                return moveUp();
        }
        return -1;
    }

    private int moveLeft() {
        currWidth--;
        if (dieWall()) {
            return -1;
        }
        return move();
    }

    private int moveRight() {
        currWidth++;
        if (dieWall()) {
            return -1;
        }
        return move();
    }

    private int moveDown() {
        currHeight++;
        if (dieWall()) {
            return -1;
        }
        return move();
    }

    private int moveUp() {
        currHeight--;
        if (dieWall()) {
            return -1;
        }
        return move();
    }

    private int move() {
        if (foodIdx < food.length && food[foodIdx][0] == currHeight && food[foodIdx][1] == currWidth) {
            foodIdx++;
        } else {
            Pair<Integer, Integer> tail = snake.getLast();
            snakePointSet.remove(tail);
            snake.removeLast();
        }
        snake.addFirst(new Pair<>(currHeight, currWidth));
        if (dieBody()) {
            return -1;
        }
        snakePointSet.add(new Pair<>(currHeight, currWidth));
        /*boolean[][] map = new boolean[height][width];
        for (int i = 0; i < map.length; i++) {
            System.out.println("");
            for (int j = 0; j < width; j++) {
                if(snakePointSet.contains(new Pair<>(i,j))){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
            }
        }
        System.out.println("");*/
        return foodIdx;
    }

    private boolean dieWall() {
        if (currWidth < 0 || currWidth >= width || currHeight < 0 || currHeight >= height) {
            return true;
        }
        return false;
    }

    private boolean dieBody() {
        return (snakePointSet.contains(new Pair<>(currHeight, currWidth)));
    }
}
