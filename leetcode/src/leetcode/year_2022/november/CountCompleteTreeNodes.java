package leetcode.year_2022.november;

import common.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        System.out.println(new CountCompleteTreeNodes().countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countDfs(root);
    }

    private int countDfs(TreeNode node) {
        int result = 0;

        if (node.left == null && node.right == null) {
            return 1;
        }

        if (node.left != null) {
            result += countNodes(node.left);
        }
        if (node.right != null) {
            result += countNodes(node.right);
        }

        return result + 1;
    }

}
