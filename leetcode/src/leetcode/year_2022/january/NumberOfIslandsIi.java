package leetcode.year_2022.january;

import javafx.util.Pair;

import java.util.*;

public class NumberOfIslandsIi {
    public static void main(String[] args) {
//        int m = 3;int n = 3;int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
//        int m = 1;int n = 2;int[][] positions = {{0, 1}, {0,0}};
//        int m = 3;int n = 3;int[][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};
        int m = 3;int n = 3;int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};
        System.out.println(new NumberOfIslandsIi().numIslands2(m, n, positions));
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        HashMap<Pair<Integer, Integer>, Integer> pointIslandMap = new HashMap<>();
        HashMap<Integer, LinkedList<Pair<Integer, Integer>>> islandPointMap = new HashMap<>();
        HashSet<Pair<Integer,Integer>> dupSet = new HashSet<>();
        Integer newIslandNum = new Integer(0);
        for (int i = 0; i < positions.length; i++) {
            HashSet<Integer> connectedIslands = new HashSet<>();
            int y = positions[i][0];
            int x = positions[i][1];
            if(dupSet.contains(new Pair<>(x,y))){
                result.add(islandPointMap.keySet().size());
                continue;
            }
            dupSet.add(new Pair<>(x,y));

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

            LinkedList<Pair<Integer, Integer>> points = new LinkedList<>();
            points.add(new Pair<>(x, y));
            newIslandNum++;
            if (!connectedIslands.isEmpty()) {
                for (Integer island : connectedIslands) {
                    points.addLast(islandPointMap.get(island).getFirst());
                    island = newIslandNum;
                }
            }

            islandPointMap.put(newIslandNum, points);

            result.add(islandPointMap.keySet().size());
        }

        return result;
    }
}
