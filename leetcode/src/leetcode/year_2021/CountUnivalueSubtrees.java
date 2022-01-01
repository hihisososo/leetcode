package leetcode.year_2021;

import common.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class CountUnivalueSubtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(5, new TreeNode(5), new TreeNode(5)), new TreeNode(5, null, new TreeNode(5)));
        System.out.println(new CountUnivalueSubtrees().countUnivalSubtrees(root));
    }

    public int countUnivalSubtrees(TreeNode root) {
        AtomicInteger cnt = new AtomicInteger();
        isUnival(root, cnt);
        return cnt.get();
    }

    private boolean isUnival(TreeNode node, AtomicInteger cnt) {
        if (node == null) return true;

        boolean left = isUnival(node.left, cnt);
        boolean right = isUnival(node.right, cnt);
        if (left && right) {
            if (node.left == null && node.right == null) {
                cnt.addAndGet(1);
                return true;
            } else if (node.left == null) {
                if (node.right.val == node.val) {
                    cnt.addAndGet(1);
                    return true;
                }
            } else if (node.right == null) {
                if (node.left.val == node.val) {
                    cnt.addAndGet(1);
                    return true;
                }
            } else if (node.left.val == node.right.val && node.left.val == node.val) {
                cnt.addAndGet(1);
                return true;
            }
            return false;
        }
        return false;
    }
}