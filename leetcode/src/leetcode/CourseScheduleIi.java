package leetcode;

import java.util.*;

public class CourseScheduleIi {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(Arrays.toString(new CourseScheduleIi().findOrder(numCourses, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            nodes[b].nodes.add(nodes[a]);
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        if (hasCycle(nodes, resultList)) {
            return new int[]{};
        } else {
            return duplicateRemove(resultList, numCourses);
        }
    }

    private int[] duplicateRemove(ArrayList<Integer> resultList, int numCourses) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> dupRemoveResultList = new ArrayList<>();
        for (int i = resultList.size() - 1; i >= 0; i--) {
            if (!set.contains(resultList.get(i))) {
                dupRemoveResultList.add(resultList.get(i));
                set.add(resultList.get(i));
            }
        }
        Collections.reverse(dupRemoveResultList);

        int[] result = new int[numCourses];
        int idx = 0;
        for (int i = 0; i < result.length; i++) {
            if (!set.contains(i)) {
                result[idx] = i;
                idx++;
            }
        }

        for (int i = 0; i < dupRemoveResultList.size(); i++) {
            result[idx] = dupRemoveResultList.get(i);
            idx++;
        }

        return result;
    }

    private boolean hasCycle(Node[] nodes, ArrayList<Integer> resultList) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].nodes.size() > 0) {
                if (hasCycle(nodes[i], new boolean[nodes.length], resultList)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, boolean[] visited, ArrayList<Integer> resultList) {
        if (visited[node.val] == true) {
            return true;
        }
        visited[node.val] = true;
        resultList.add(node.val);
        for (int i = 0; i < node.nodes.size(); i++) {
            if (hasCycle(node.nodes.get(i), visited, resultList)) {
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
