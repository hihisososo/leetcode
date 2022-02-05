package leetcode.year_2022.february;

import common.TreeBuilder;
import common.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class LargestBstSubtree {
    public static void main(String[] args) {
//        TreeNode root = TreeBuilder.buildTree(new Integer[]{10,5,15,1,8,null,7});
//        TreeNode root = TreeBuilder.buildTree(new Integer[]{4,2,7,2,3,5,null,2,null,null,null,null,null,1});
//        TreeNode root = TreeBuilder.buildTree(new Integer[]{1,2});
//        TreeNode root = TreeBuilder.buildTree(new Integer[]{2, 3, null, 1});
//        TreeNode root = TreeBuilder.buildTree(new Integer[]{3,1,null,2,null,null,4});
        TreeNode root = TreeBuilder.buildTree(new Integer[]{3,2,4,null,null,1});

        System.out.println(new LargestBstSubtree().largestBSTSubtree(root));
    }

    public int largestBSTSubtree(TreeNode root) {
        AtomicInteger length = new AtomicInteger();
        if (root == null) {
            return 0;
        }
        length.set(1);
        findLargeBstTree(root, Integer.MAX_VALUE, Integer.MIN_VALUE, length);
        return length.get();
    }

    private int findLargeBstTree(TreeNode node, int smaller, int bigger, AtomicInteger length) {
        if (node == null) {
            return 0;
        }

        int left = findLargeBstTree(node.left, node.val, Integer.MIN_VALUE, length);
        int right = findLargeBstTree(node.right, Integer.MAX_VALUE, node.val, length);
        int sum = 0;

        if (left < 0 || right < 0) {
            sum = -1;
        } else if (left >= 0 && right >= 0) {
            length.set(Math.max(length.get(), left + right + 1));
            sum = left + right + 1;
        } else if (left >= 0) {
            length.set(Math.max(length.get(), left + 1));
            sum = left + 1;
        } else {
            length.set(Math.max(length.get(), right + 1));
            sum = right + 1;
        }
        if (node.val >= smaller || node.val <= bigger) {
            return -1;
        }
        return sum;
    }
}
