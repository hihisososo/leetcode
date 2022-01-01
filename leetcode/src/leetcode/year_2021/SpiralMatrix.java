package leetcode.year_2021;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] max = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(new SpiralMatrix().spiralOrder(max));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        Point point = new Point(0, -1);
        while(true){
            int row = point.row;
            int col = point.col;

            right(point, list, matrix);
            down(point, list, matrix);
            left(point, list, matrix);
            up(point, list, matrix);

            if(row == point.row && col == point.col){
                break;
            }
        }
        return list;
    }

    private void right(Point point, ArrayList<Integer> list, int[][] matrix) {
        int row = point.row;
        int col = point.col;
        while(true){
            col++;
            if(col >= matrix[row].length ||matrix[row][col] == Integer.MIN_VALUE){
                break;
            }
            list.add(matrix[row][col]);
            matrix[row][col] = Integer.MIN_VALUE;
            point.col = col;
        }

    }

    private void down(Point point, ArrayList<Integer> list, int[][] matrix) {
        int row = point.row;
        int col = point.col;
        while(true){
            row++;
            if(row >= matrix.length|| matrix[row][col] == Integer.MIN_VALUE){
                break;
            }
            list.add(matrix[row][col]);
            matrix[row][col] = Integer.MIN_VALUE;
            point.row = row;
        }

    }

    private void left(Point point, ArrayList<Integer> list, int[][] matrix) {
        int row = point.row;
        int col = point.col;
        while(true){
            col--;
            if(col < 0 || matrix[row][col] == Integer.MIN_VALUE){
                break;
            }
            list.add(matrix[row][col]);
            matrix[row][col] = Integer.MIN_VALUE;
            point.col = col;
        }

    }

    private void up(Point point, ArrayList<Integer> list, int[][] matrix) {
        int row = point.row;
        int col = point.col;
        while(true){
            row--;
            if(row < 0 || matrix[row][col] == Integer.MIN_VALUE ){
                break;
            }
            list.add(matrix[row][col]);
            matrix[row][col] = Integer.MIN_VALUE;
            point.row = row;
        }

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
