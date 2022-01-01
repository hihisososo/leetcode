package leetcode.year_2021;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-5}};
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix
                , 1));
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();

    }
}
