package leetcode.year_2024.may;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangleIi {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleIi().getRow(3));
        System.out.println(new PascalsTriangleIi().getRow(0));
        System.out.println(new PascalsTriangleIi().getRow(1));

    }

    public List<Integer> getRow(int rowIndex) {
        int[][] triangle = new int[rowIndex + 1][];
        for (int i = 0; i <= rowIndex; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == 0) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }
        return Arrays.stream(triangle[rowIndex]).boxed().collect(Collectors.toList());
    }

}
