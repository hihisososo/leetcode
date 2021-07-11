package leetcode;

import common.TreeNode;
import util.TreeUtil;

public class PathSumIII {
    private int cnt = 0;

    public static void main(String[] args) {
        String s = "10,5,3,3,null,null,-2,null,null,2,null,1,null,null,-3,null,11,null,null";
        TreeNode root = TreeUtil.deserialize(s);

        System.out.println(new PathSumIII().pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int targetSum) {
        traverseInOrder(root, targetSum);
        return cnt;
    }

    private void traverseInOrder(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        findPathSum(node, 0, targetSum);

        traverseInOrder(node.left, targetSum);
        traverseInOrder(node.right, targetSum);
    }

    private void findPathSum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return;
        }

        sum += node.val;
        if (sum == targetSum) {
            cnt++;
        }

        findPathSum(node.left, sum, targetSum);
        findPathSum(node.right, sum, targetSum);
    }

}
