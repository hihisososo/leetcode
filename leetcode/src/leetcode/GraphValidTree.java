package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphValidTree {
    public static void main(String[] args) {
        //int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        //int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges = new int[][]{{0, 1}, {2, 3}};
        System.out.println(new GraphValidTree().validTree(5, edges));
    }

    public boolean validTree(int n, int[][] edges) {
        boolean[][] nodeEdges = new boolean[n][n];
        for (int i = 0; i < edges.length; i++) {
            nodeEdges[edges[i][0]][edges[i][1]] = true;
            nodeEdges[edges[i][1]][edges[i][0]] = true;
        }

        boolean[] visited = new boolean[n];
        traverse(nodeEdges, -1, 0, visited);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        visited = new boolean[n];
        return !isCycle(nodeEdges, -1, 0, visited);
    }

    private void traverse(boolean[][] nodeEdges, int parent, int edge, boolean[] visited) {
        if (parent == edge) {
            return;
        }

        if(visited[edge]){
            return;
        }
        visited[edge] = true;
        for (int i = 0; i < nodeEdges.length; i++) {
            if(!nodeEdges[edge][i] || (i == parent)){
                continue;
            }
            traverse(nodeEdges, edge, i, visited);
        }
    }

    private boolean isCycle(boolean[][] nodeEdges, int parent, int edge, boolean[] visited) {

        if (visited[edge]) {
            return true;
        }

        visited[edge] = true;
        for (int i = 0; i < nodeEdges[edge].length; i++) {
            if(!nodeEdges[edge][i] || (i == parent)){
                continue;
            }
            if (isCycle(nodeEdges, edge, i, visited)) {
                return true;
            }
        }
        return false;
    }
}

