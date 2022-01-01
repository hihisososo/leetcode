package leetcode.year_2021;

import common.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeTilt {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));
        System.out.println(new BinaryTreeTilt().findTilt(root));
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        AtomicInteger tiltSUm = new AtomicInteger();
        tiltSUm.addAndGet(Math.abs(getSumAndAddTilt(root.left, tiltSUm) - getSumAndAddTilt(root.right, tiltSUm)));
        return tiltSUm.get();
    }

    private int getSumAndAddTilt(TreeNode node, AtomicInteger tiltSum) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.val;
        }

        int sumLeft = getSumAndAddTilt(node.left, tiltSum);
        int sumRight = getSumAndAddTilt(node.right, tiltSum);
        tiltSum.addAndGet(Math.abs(sumLeft - sumRight));
        return sumLeft + sumRight + node.val;
    }


}
