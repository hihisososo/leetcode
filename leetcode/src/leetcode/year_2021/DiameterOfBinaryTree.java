package leetcode.year_2021;

import common.TreeNode;
import util.TreeUtil;

public class DiameterOfBinaryTree {
    private int max = 0;

    public static void main(String[] args) {
        /*String s = "1,2,4,null,null,5,null,null,3,null,null";*/
        String s = "1,2";
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(TreeUtil.deserialize(s)));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findMaxLen(root);
        return max;
    }

    private int findMaxLen(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxLeft = findMaxLen(node.left);
        int maxRight = findMaxLen(node.right);
        int maxLen = Math.max(maxLeft, maxRight);
        max = Math.max(max, maxLeft + maxRight);
        return maxLen + 1;
    }
}
