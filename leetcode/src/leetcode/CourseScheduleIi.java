package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleIi {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}};

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
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if(nodes[i].nodes.size() == 0){
                resultList.add(i);
                resultSet.add(i);
            }else{
                ArrayList<Integer> prerequisitesList = getPrerequisites(nodes, i, resultSet);
                if(prerequisitesList.size() == 0){ // zero is cycle
                    return new int[]{};
                }
                resultList.addAll(prerequisitesList);
                resultSet.addAll(prerequisitesList);
            }
        }
    }

    private ArrayList<Integer> getPrerequisites(Node[] nodes, int idx, HashSet<Integer> resultSet) {
        ArrayList<Integer> prerequisites = new ArrayList<>();
        getPrerequisites(nodes, idx, resultSet, prerequisites);
        return prerequisites;
    }

    private void getPrerequisites(Node[] nodes, int idx, HashSet<Integer> resultSet, ArrayList<Integer> prerequisites) {
        if(prerequisites.contains(idx)){
            prerequisites =
        }
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
