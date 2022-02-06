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
        TreeNode root = TreeBuilder.buildTree(new Integer[]{3, 2, 4, null, null, 1});

        System.out.println(new LargestBstSubtree().largestBSTSubtree(root));
    }

    public int largestBSTSubtree(TreeNode root) {
        AtomicInteger length = new AtomicInteger();
        if (root == null) {
            return 0;
        }
        length.set(1);
        findLargeBstTree(root, length);
        return length.get();
    }

    private int findLargeBstTree(TreeNode node, AtomicInteger length) {
        if (node == null) {
            return 0;
        }

        int left = findLargeBstTree(node.left, length);
        int right = findLargeBstTree(node.right, length);

        if (left < 0 || right < 0) {
            return -1;
        } else {
            if (node.left != null && node.left.val >= node.val) {
                return -1;
            }
            if (node.right != null && node.right.val <= node.val) {
                return -1;
            }
            length.set(Math.max(length.get(), left + right + 1));
            return left + right + 1;
        }
    }
}
