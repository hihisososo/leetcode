package leetcode.year_2022.december;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {1}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        traverseAllPaths(0, graph, new ArrayList<>(), result);
        return result;

    }

    private void traverseAllPaths(int currIdx, int[][] graph, List<Integer> currPaths, List<List<Integer>> result) {
        if (currIdx == graph.length - 1) {
            List<Integer> pathCopy = new ArrayList<>();
            copy(pathCopy, currPaths);
            pathCopy.add(currIdx);
            result.add(pathCopy);
            return;
        }
        currPaths.add(currIdx);
        for (int i = 0; i < graph[currIdx].length; i++) {
            traverseAllPaths(graph[currIdx][i], graph, currPaths, result);
        }
        currPaths.remove(currPaths.size() - 1);
    }

    private void copy(List<Integer> pathCopy, List<Integer> currPaths) {
        for (Integer i : currPaths) {
            pathCopy.add(i);
        }
    }
}
