package leetcode.year_2022.january;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfIslandsIi {
    public static void main(String[] args) {
//        int m = 3;int n = 3;int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
//        int m = 1;int n = 2;int[][] positions = {{0, 1}, {0,0}};
//        int m = 3;int n = 3;int[][] positions = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
//        int m = 3;int n = 3;int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};
        int m = 60; int n = 24; int[][] positions = {{32,7},{28,0},{28,18},{6,11},{31,22},{36,21},{6,8},{29,18},{39,10},{55,22},{51,1},{14,12},{14,3},{37,9},{20,13},{51,19},{1,22},{19,11},{44,22},{24,8},{42,16},{8,12},{52,0},{12,1},{48,18},{6,19},{58,20},{7,8},{38,19},{47,5},{7,21},{22,4},{37,3},{0,12},{53,10},{50,12},{1,23},{24,18},{22,17},{19,10},{24,16},{46,16},{57,18},{37,21},{18,5},{30,6},{25,23},{45,5},{41,18},{32,12},{6,10},{8,1},{32,11},{1,1},{48,6},{17,6},{0,22},{36,9},{59,12},{50,9},{59,4},{53,13},{49,16},{24,7},{33,11},{2,7},{1,16},{8,2},{37,19},{32,9},{34,4},{41,9},{26,7},{10,15},{18,3},{16,4},{12,16},{16,5},{21,19},{16,14},{19,3},{58,23},{10,17},{5,15},{43,5},{27,9},{34,18},{9,6},{2,19},{46,11},{39,16},{10,21},{46,1},{9,18},{10,14},{27,23},{23,0},{24,4},{48,10},{55,0},{34,0},{30,20},{58,18},{54,21},{18,15},{27,5},{42,19},{35,19},{27,7},{49,23},{21,2},{31,16},{12,18},{9,11},{28,10},{50,19},{18,1},{59,18},{27,11},{44,15},{2,15},{37,17},{53,7},{12,21},{56,11},{42,3},{37,16},{23,15},{0,17},{13,4},{44,6},{17,13},{9,21},{49,14},{50,17},{27,3},{3,2},{41,12},{16,10},{3,23},{14,8},{52,2},{28,1},{58,7},{28,22},{4,18},{28,15},{13,2},{56,0},{34,11},{17,11},{55,11},{20,12},{46,12},{0,1},{2,2},{57,22},{2,22},{56,14},{9,19},{29,19},{19,7},{49,6},{0,10},{42,5},{51,22},{36,13},{36,12},{22,23},{14,21},{42,4},{46,21},{25,17},{33,22},{46,19},{3,22},{26,11},{26,4},{32,23},{58,19},{5,11},{10,6},{56,4},{31,23},{38,17},{49,5},{6,12},{18,0},{34,21},{0,5},{41,7},{27,22},{42,2},{46,15},{29,20},{36,0},{35,18},{13,20},{34,16},{20,6},{32,5},{34,22},{48,4},{59,21},{25,13},{4,13},{41,14},{32,17},{45,13},{14,14},{30,12},{25,2},{3,20},{14,19},{41,8},{39,5},{24,3},{26,5},{33,10},{30,21},{35,15},{25,5},{24,2},{55,9},{10,8},{13,5},{16,3},{8,20},{59,2},{33,0},{27,15},{24,17},{37,4},{34,15},{12,12},{45,4},{16,18},{48,14},{15,0},{47,8},{59,11},{22,22},{54,5},{47,14},{4,22},{18,7},{57,6},{53,15},{48,22},{32,22},{58,11},{27,0},{57,1},{28,5},{20,19},{30,9},{18,4},{12,2},{47,16},{48,5},{56,1},{38,18},{2,11},{49,0},{30,19},{1,0},{29,1},{1,21},{9,0},{43,7},{3,16},{3,7},{37,6},{12,7},{9,4},{15,5},{41,23},{1,4},{39,0},{49,3},{13,22},{57,23},{56,5},{21,16},{47,18},{45,15},{38,16},{28,9},{1,13},{47,12},{8,18},{40,2},{53,20},{12,22},{23,13},{38,12},{58,17},{20,15},{58,5},{52,9},{58,15},{44,9},{44,23},{18,13},{50,15},{59,17},{11,1},{32,16},{58,8},{23,5},{14,11},{44,16},{30,4},{34,17},{20,18},{14,9},{27,10},{2,12},{4,6},{26,2},{54,8},{11,17},{25,20},{52,10},{43,23},{53,0},{3,11},{7,19},{38,0},{1,12},{4,2},{31,19},{27,12},{59,6},{17,21},{49,21},{44,20},{2,21},{26,20},{29,2},{50,5},{53,2},{2,8},{44,3},{49,18},{11,6},{19,5},{17,12},{38,2},{20,23},{35,20},{56,7},{36,22},{54,1},{32,1},{15,4},{46,23},{41,4},{22,18},{46,7},{27,16},{49,22},{12,4},{57,4},{43,21},{4,0},{29,9},{24,19},{43,6},{8,6},{9,7},{21,18},{35,16},{44,8},{31,8},{23,14},{36,5},{5,2},{52,12},{55,18},{13,23},{9,20},{17,4},{30,16},{55,19},{34,19},{46,9},{35,5},{55,13},{5,13},{36,19},{26,9},{8,15},{8,11},{42,6},{34,13},{47,15},{59,22},{35,1},{17,18},{58,13},{46,2},{27,17},{33,5},{6,2},{50,23},{50,16},{25,22},{53,22},{5,7},{22,10},{39,22},{9,17},{18,21},{23,2},{40,5},{39,17},{2,16},{35,21},{37,18},{7,14},{40,4},{56,8},{42,20},{36,20},{8,14},{18,18},{35,22},{37,1},{32,2},{32,14},{35,14},{15,10},{12,17},{54,18},{56,13},{51,2},{22,3},{16,9},{1,18},{28,17},{22,2},{55,10},{14,7},{8,19},{31,9},{8,9},{14,0},{16,6},{32,0},{23,9},{49,19},{42,0},{44,14},{54,12},{10,7},{43,19},{49,11},{44,10},{45,12},{3,12},{29,4},{49,15},{37,23},{11,7},{43,4}};
        System.out.println(new NumberOfIslandsIi().numIslands2(m, n, positions));
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        HashMap<Pair<Integer, Integer>, Integer> pointIslandMap = new HashMap<>();
        List<HashSet<Integer>> islandMergeList = new ArrayList<>();
        int newIslandNum = 0;
        for (int i = 0; i < positions.length; i++) {
            ArrayList<Integer> connectedIslands = new ArrayList<>();
            int y = positions[i][0];
            int x = positions[i][1];
            if(pointIslandMap.containsKey(new Pair<>(x, y))){
                result.add(islandMergeList.size());
                continue;
            }

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
            Pair<Integer, Integer> newPoint = new Pair<>(x, y);
            points.add(newPoint);
            int islandNum = -1;
            if (!connectedIslands.isEmpty()) {
                int islandIdx = findIslandIdx(islandMergeList, connectedIslands.get(0));
                islandNum = connectedIslands.get(0);
                for (int j = 1; j < connectedIslands.size(); j++) {
                    int thisIdx = findIslandIdx(islandMergeList, connectedIslands.get(j));
                    if (islandIdx != thisIdx) {
                        merge(islandMergeList, islandIdx, thisIdx);
                    }
                }
            } else {
                islandNum = ++newIslandNum;
                HashSet<Integer> newIsland = new HashSet<>();
                newIsland.add(islandNum);
                islandMergeList.add(newIsland);
            }

            for (int j = 0; j < islandMergeList.size(); j++) {
                if (islandMergeList.get(j).isEmpty()) {
                    islandMergeList.remove(j);
                }
            }
            pointIslandMap.put(newPoint, islandNum);
            result.add(islandMergeList.size());
        }

        return result;
    }

    private void merge(List<HashSet<Integer>> islandMergeList, int islandIdx, int thisIdx) {
        islandMergeList.get(islandIdx).addAll(islandMergeList.get(thisIdx));
        islandMergeList.get(thisIdx).clear();
    }

    private int findIslandIdx(List<HashSet<Integer>> islandMergeList, Integer island) {
        int idx = 0;
        for (HashSet<Integer> merge : islandMergeList) {
            if (merge.contains(island)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}
