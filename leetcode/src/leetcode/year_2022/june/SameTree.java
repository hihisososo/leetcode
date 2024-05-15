package leetcode.year_2022.june;

import common.TreeNode;

public class SameTree {

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(new SameTree().isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(4))));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    private boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && compare(p.left, q.left) && compare(p.right, q.right);
        }
    }
}
