package leetcode.year_2024.april;

import common.TreeNode;
import util.TreeDeserializer;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        System.out.println(new SumRootToLeafNumbers().sumNumbers(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3})));
        System.out.println(new SumRootToLeafNumbers().sumNumbers(TreeDeserializer.deserializeBinaryTree(new Integer[]{4, 9, 0, 5, 1})));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumber(root, "");
    }

    private int sumNumber(TreeNode node, String s) {
        if (node.left == null && node.right == null) {
            return Integer.parseInt(s + node.val);
        }
        int sum = 0;
        if (node.left != null) {
            sum += sumNumber(node.left, s + node.val);
        }
        if (node.right != null) {
            sum += sumNumber(node.right, s + node.val);
        }

        return sum;
    }
}
