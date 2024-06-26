package leetcode.year_2024.june;

import common.TreeNode;
import util.TreeDeserializer;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        System.out.println(new BalanceABinarySearchTree().balanceBST(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, null, 2, null, 3, null, 4, null, null})));
        System.out.println(new BalanceABinarySearchTree().balanceBST(TreeDeserializer.deserializeBinaryTree(new Integer[]{2, 1, 3})));
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        dfs(root, ints);

        return buildTree(0, ints.size() - 1, ints);
    }

    private TreeNode buildTree(int start, int end, List<Integer> ints) {

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(ints.get(mid));
        if (start < mid) {
            node.left = buildTree(start, mid-1, ints);
        }

        if (end > mid) {
            node.right = buildTree(mid+1, end, ints);
        }
        return node;

    }

    private void dfs(TreeNode node, List<Integer> ints) {
        if (node.left != null) {
            dfs(node.left, ints);
        }
        ints.add(node.val);
        if (node.right != null) {
            dfs(node.right, ints);
        }
    }
}
