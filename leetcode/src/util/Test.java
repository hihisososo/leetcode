package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().test(4, new int[]{0, 1, 1, 2, 3}, new int[]{1, 2, 3, 0, 1}));
        System.out.println(new Test().test(4, new int[]{0, 1, 3, 2}, new int[]{1, 3, 2, 0}));
        System.out.println(new Test().test(4, new int[]{0, 0, 1, 3}, new int[]{1, 3, 3, 0}));
        System.out.println(new Test().test(4, new int[]{0, 0, 1, 3, 0}, new int[]{0, 1, 3, 0, 2}));
        System.out.println(new Test().test(6, new int[]{0, 1, 1, 2, 3, 4, 4, 5}, new int[]{3, 0, 2, 5, 4, 1, 1, 4}));
    }

    private boolean test(int vertexCnt, int[] start, int[] end) {
        Vertex[] vertices = new Vertex[vertexCnt];
        for (int i = 0; i < vertexCnt; i++) {
            vertices[i] = new Vertex(i, new ArrayList<>());
        }

        for (int i = 0; i < start.length; i++) {
            vertices[start[i]].edges.add(new Edge(start[i], end[i]));
        }

        return traverse(0, vertices[0], vertices, new HashMap<>());
    }

    private boolean traverse(int rootNum, Vertex curr, Vertex[] vertices, Map<Integer, Integer> visited) {
        if (curr.edges.isEmpty() || (!visited.isEmpty() && curr.num == rootNum)) {
            if (visited.size() == vertices.length) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = 0; i < curr.edges.size(); i++) {
            Edge e = curr.edges.get(i);
            curr.edges.remove(e);
            visited.merge(e.end, 1, Integer::sum);
            if (traverse(rootNum, vertices[e.end], vertices, visited)) {
                return true;
            }
            decrease(visited, e.end);
            curr.edges.add(i, e);
        }
        return false;
    }

    private void decrease(Map<Integer, Integer> visited, Integer remove) {
        if (visited.get(remove) == 1) {
            visited.remove(remove);
        } else {
            visited.put(remove, visited.get(remove) - 1);
        }

    }

    class Vertex {
        private final int num;
        private List<Edge> edges;

        Vertex(int num, List<Edge> edges) {
            this.num = num;
            this.edges = edges;
        }
    }

    class Edge {
        private final int start;
        private final int end;

        Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
