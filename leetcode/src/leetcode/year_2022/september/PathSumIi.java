package leetcode.year_2022.september;

import common.TreeNode;
import util.TreeDeserializer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        System.out.println(new PathSumIi().pathSum(TreeDeserializer.deserializeBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
        System.out.println(new PathSumIi().pathSum(TreeDeserializer.deserializeBinaryTree(new Integer[]{1,2}), 1));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, 0,  targetSum, new LinkedList<>(),result);
        return result;
    }

    private void pathSum(TreeNode node, int currSum, int targetSum, LinkedList<Integer> path, List<List<Integer>> result) {
        if(node == null){
            return;
        }

        path.addLast(node.val);
        currSum += node.val;
        if(currSum == targetSum && node.left == null && node.right == null){
            result.add(new LinkedList<>(path));
        }

        pathSum(node.left, currSum, targetSum, path, result);
        pathSum(node.right, currSum, targetSum, path, result);

        path.removeLast();
    }
}
