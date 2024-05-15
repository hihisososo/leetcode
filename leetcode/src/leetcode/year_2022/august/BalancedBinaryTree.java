package leetcode.year_2022.august;

import common.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)),
                new TreeNode(2));
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println(new BalancedBinaryTree().isBalanced(root1));
        System.out.println(new BalancedBinaryTree().isBalanced(root2));
        System.out.println(new BalancedBinaryTree().isBalanced(root3));
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root);
    }

    private boolean isBalancedTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(getDepth(node.left) - getDepth(node.right)) > 1) {
            return false;
        }

        return isBalancedTree(node.left) && isBalancedTree(node.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left) + 1, getDepth(node.right) + 1);
    }

}
