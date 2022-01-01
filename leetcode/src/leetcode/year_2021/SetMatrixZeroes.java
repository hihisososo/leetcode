package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetMatrixZeroes().setZeroes(matrix);
        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);
    }

    public void setZeroes(int[][] matrix) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    points.add(new Point(i, j));
                }
            }
        }
        for (Point p : points){
            setMatrixZero(matrix, p);
        }
    }

    private void setMatrixZero(int[][] matrix, Point p) {
        int row = p.getRow();
        int col = p.getCol();

        for(int i=0;i<matrix[row].length;i++){
            matrix[row][i] = 0;
        }

        for(int i=0;i<matrix.length;i++){
            matrix[i][col] = 0;
        }
    }

    class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }
}
