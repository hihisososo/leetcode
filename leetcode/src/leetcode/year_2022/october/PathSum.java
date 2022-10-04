package leetcode.year_2022.october;

import common.TreeNode;
import util.TreeDeserializer;

public class PathSum {
    public static void main(String[] args) {
        System.out.println(new PathSum().hasPathSum(TreeDeserializer.deserializeBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        System.out.println(new PathSum().hasPathSum(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3}), 5));
        System.out.println(new PathSum().hasPathSum(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2}), 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode node, int currSum, int targetSum) {
        if (node.left == null && node.right == null) {
            currSum += node.val;
            return currSum == targetSum;
        }

        currSum += node.val;
        boolean result = false;
        if (node.left != null) {
            result = result || dfs(node.left, currSum, targetSum);
        }
        if (node.right != null) {
            result = result || dfs(node.right, currSum, targetSum);
        }

        return result;
    }
}
