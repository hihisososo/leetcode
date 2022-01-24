package leetcode.year_2022.january;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumberOfIslandsIi {
    public static void main(String[] args) {
        /*int m = 3;
        int n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};*/
        int m = 1;
        int n = 2;
        int[][] positions = {{0, 1}, {0,0}};
        System.out.println(new NumberOfIslandsIi().numIslands2(m, n, positions));
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        HashMap<Pair<Integer, Integer>, Integer> pointIslandMap = new HashMap<>();
        HashMap<Integer, HashSet<Pair<Integer, Integer>>> islandPointMap = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            List<Integer> connectedIslands = new ArrayList<>();
            int y = positions[i][0];
            int x = positions[i][1];

            if (x - 1 >= 0 && pointIslandMap.containsKey(new Pair<>(x - 1, y))) {
                connectedIslands.add(pointIslandMap.get(new Pair<>(x - 1, y)));
            }
            if (x + 1 < n && pointIslandMap.containsKey(new Pair<>(x + 1, y))) {
                connectedIslands.add(pointIslandMap.get(new Pair<>(x + 1, y)));
            }
            if (y - 1 >= 0 && pointIslandMap.containsKey(new Pair<>(x, y - 1))) {
                connectedIslands.add(pointIslandMap.get(new Pair<>(x, y - 1)));
            }
            if (y + 1 < m && pointIslandMap.containsKey(new Pair<>(x, y + 1))) {
                connectedIslands.add(pointIslandMap.get(new Pair<>(x, y + 1)));
            }

            HashSet<Pair<Integer, Integer>> points = new HashSet<>();
            points.add(new Pair<>(x, y));
            if (!connectedIslands.isEmpty()) {
                for (int j = 0; j < connectedIslands.size(); j++) {
                    points.addAll(islandPointMap.get(connectedIslands.get(j)));
                    islandPointMap.remove(connectedIslands.get(j));
                }
            }
            int newIslandNum = islandPointMap.keySet().size() + 1;
            islandPointMap.put(newIslandNum, points);
            for (Pair<Integer, Integer> p : points) {
                pointIslandMap.put(p, newIslandNum);
            }
            result.add(islandPointMap.keySet().size());
        }

        return result;
    }
}
