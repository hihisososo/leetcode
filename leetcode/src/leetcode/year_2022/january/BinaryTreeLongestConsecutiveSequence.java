package leetcode.year_2022.january;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), new TreeNode(4, null, new TreeNode(5))));
//        TreeNode root = new TreeNode(2, null, new TreeNode(3, new TreeNode(2, new TreeNode(1),null), null));
//        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        System.out.println(new BinaryTreeLongestConsecutiveSequence().longestConsecutive(root));
    }

    int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        maxLongestConsecutive(root);
        return maxLength;
    }


    private int maxLongestConsecutive(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int rightMax = maxLongestConsecutive(node.right) + 1;
        int leftMax = maxLongestConsecutive(node.left) + 1;

        if (node.left != null && node.left.val - 1 != node.val) {
            leftMax = 1;
        }
        if (node.right != null && node.right.val - 1 != node.val) {
            rightMax = 1;
        }

        int length = Math.max(leftMax, rightMax);
        maxLength = Math.max(maxLength, length);

        return length;
    }
}
