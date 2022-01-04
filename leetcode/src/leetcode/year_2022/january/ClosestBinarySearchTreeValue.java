package leetcode.year_2022.january;

import common.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), null), new TreeNode(5));
        TreeNode root = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        System.out.println(new ClosestBinarySearchTreeValue().closestValue(root, 4.142857));
    }

    public int closestValue(TreeNode root, double target) {
        AtomicInteger i = new AtomicInteger(Integer.MAX_VALUE);
        getMin(root, target, i);
        return i.get();
    }

    private void getMin(TreeNode node, double target, AtomicInteger i) {
        if (Math.abs(target - node.val) < (Math.abs(target - i.get()))) {
            i.set(node.val);
        }

        if (node.left != null) {
            getMin(node.left, target, i);
        }
        if (node.right != null) {
            getMin(node.right, target, i);
        }
    }
}
