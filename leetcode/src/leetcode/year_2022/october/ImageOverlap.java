package leetcode.year_2022.october;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ImageOverlap {
    public static void main(String[] args) {
        System.out.println(new ImageOverlap().largestOverlap(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}}, new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}}));
        System.out.println(new ImageOverlap().largestOverlap(new int[][]{{1}}, new int[][]{{1}}));
        System.out.println(new ImageOverlap().largestOverlap(new int[][]{{0}}, new int[][]{{0}}));
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        List<Pair<Integer, Integer>> onePoints = new LinkedList<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[i].length; j++) {
                if (img1[i][j] == 1) {
                    onePoints.add(new Pair<>(i, j));
                }
            }
        }

        return dfs(onePoints, 0, 0, img2, new HashSet<Pair<Integer, Integer>>());
    }

    private int dfs(List<Pair<Integer, Integer>> onePoints, int rowOffset, int colOffSet, int[][] img2, HashSet<Pair<Integer, Integer>> visit) {
        if (visit.contains(new Pair<>(rowOffset, colOffSet)) || rowOffset <= -img2.length || rowOffset >= img2.length || colOffSet <= -img2[0].length || colOffSet >= img2[0].length) {
            return -1;
        }
        visit.add(new Pair<>(rowOffset, colOffSet));

        int count = 0;
        for (Pair<Integer, Integer> p : onePoints) {
            int i = p.getKey() + rowOffset;
            int j = p.getValue() + colOffSet;
            if (i >= 0 && i < img2.length && j >= 0 && j < img2[0].length && img2[i][j] == 1) {
                count++;
            }
        }
        int max = count;
        max = Math.max(max, dfs(onePoints, rowOffset + 1, colOffSet, img2, visit));
        max = Math.max(max, dfs(onePoints, rowOffset - 1, colOffSet, img2, visit));
        max = Math.max(max, dfs(onePoints, rowOffset, colOffSet - 1, img2, visit));
        max = Math.max(max, dfs(onePoints, rowOffset, colOffSet + 1, img2, visit));
        return max;

    }
}
