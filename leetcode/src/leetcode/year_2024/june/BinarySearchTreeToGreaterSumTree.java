package leetcode.year_2024.june;

import common.TreeNode;
import util.TreeDeserializer;

public class BinarySearchTreeToGreaterSumTree {
    public static void main(String[] args) {
        System.out.println(new BinarySearchTreeToGreaterSumTree().bstToGst(TreeDeserializer.deserializeBinaryTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8})));
        System.out.println(new BinarySearchTreeToGreaterSumTree().bstToGst(TreeDeserializer.deserializeBinaryTree(new Integer[]{0, null, 1})));
    }

    public TreeNode bstToGst(TreeNode root) {
        toGst(root, 0);
        return root;
    }

    private int toGst(TreeNode node, int offSet) {
        int leftSum = 0;
        int rightSum = 0;

        if (node.right != null) {
            rightSum += toGst(node.right, offSet);
        }

        if (node.left != null) {
            leftSum += toGst(node.left, offSet + rightSum + node.val);
        }
        int res = leftSum + rightSum + node.val;
        node.val += rightSum + offSet;
        return res;
    }

}
