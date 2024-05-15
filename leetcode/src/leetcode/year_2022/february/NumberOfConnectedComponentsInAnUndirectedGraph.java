package leetcode.year_2022.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
//        int n = 5;int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3,4}};
//        int n = 3;int[][] edges = new int[][]{{2, 0}, {2, 1}};
        System.out.println(new NumberOfConnectedComponentsInAnUndirectedGraph().countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int edge1 = edges[i][0];
            int edge2 = edges[i][1];
            edgeMap.get(edge1).add(edge2);
            edgeMap.get(edge2).add(edge1);
        }

        int components = 0;
        HashSet<Integer> connected = new HashSet<>();
        for (int key : edgeMap.keySet()) {
            if (!connected.contains(key)) {
                components++;
            }
            traverse(edgeMap.get(key), edgeMap, connected);
        }
        return components;
    }

    private void traverse(List<Integer> connEdge, HashMap<Integer, List<Integer>> edgeMap, HashSet<Integer> connected) {
        for (int edge : connEdge) {
            if (connected.contains(edge)) {
                continue;
            }
            connected.add(edge);
            traverse(edgeMap.get(edge), edgeMap, connected);
        }
    }
}
