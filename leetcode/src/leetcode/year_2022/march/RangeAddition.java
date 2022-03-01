package leetcode.year_2022.march;

import java.util.Arrays;

public class RangeAddition {
    public static void main(String[] args) {
        int length=5;int[][] updates = new int[][]{{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(Arrays.toString(new RangeAddition().getModifiedArray(length, updates)));
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int[] result = new int[length];

        for (int[] u : updates) {
            min = Math.min(min, u[0]);
            max = Math.max(max, u[1]);
        }

        for (int i=min;i <=max;i++){
            int sum = 0;
            for (int[] u : updates) {
                if(u[0] <= i && i <= u[1]){
                    sum += u[2];
                }
            }
            result[i] += sum;
        }

        return result;
    }
}
