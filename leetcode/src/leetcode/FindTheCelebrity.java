package leetcode;

import common.Relation;

import java.util.Arrays;

public class FindTheCelebrity extends Relation {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new FindTheCelebrity(graph).findCelebrity(3));
    }

    public FindTheCelebrity(int[][] graph) {
        super(graph);
    }

    public int findCelebrity(int n) {
        int[] personKnow = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    personKnow[j]++;
                }
            }
        }
        for (int i = 0; i < personKnow.length; i++) {
            if (n == personKnow[i]) {
                boolean allNotKnow = true;
                for (int j = 0; j < n; j++) {
                    if (i != j && knows(i, j)) {
                        allNotKnow = false;
                        break;
                    }
                }
                if (allNotKnow) {
                    return i;
                }
            }
        }

        return -1;
    }
}
