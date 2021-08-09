package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};

        System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            nodes[b].nodes.add(nodes[a]);
        }

        return !hasCycle(nodes);

    }

    private boolean hasCycle(Node[] nodes) {
        HashSet<Integer> memo = new HashSet<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].nodes.size() > 0) {
                if (hasCycle(nodes[i], new boolean[nodes.length], memo)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, boolean[] visited, HashSet<Integer> memo) {
        if (visited[node.val] == true) {
            return true;
        }
        if(memo.contains(node.val)){
            return false;
        }
        visited[node.val] = true;
        memo.add(node.val);
        for (int i = 0; i < node.nodes.size(); i++) {
            if (hasCycle(node.nodes.get(i), visited, memo)) {
                return true;
            }
        }
        visited[node.val] = false;
        return false;
    }

    class Node {
        private int val;
        private List<Node> nodes;

        public Node(int val) {
            this.val = val;
            this.nodes = new ArrayList<>();
        }
    }
}
