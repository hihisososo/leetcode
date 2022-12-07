package leetcode.year_2022.december;

import common.TreeNode;

public class RangeSumOfBst {
    public static void main(String[] args) {
        System.out.println(new RangeSumOfBst().rangeSumBST(new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18))), 7, 15));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSum(root, low, high);
    }

    private int rangeSum(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        if (node.val >= low && node.val <= high) {
            sum = node.val;
        }

        if (node.val < low) {
            sum += rangeSum(node.right, low, high);
        } else if (node.val > high) {
            sum += rangeSum(node.left, low, high);
        } else {
            sum += (rangeSum(node.left, low, high) + rangeSum(node.right, low, high));
        }
        return sum;

    }
}
