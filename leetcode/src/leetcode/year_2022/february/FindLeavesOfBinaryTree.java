package leetcode.year_2022.february;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode root = null;
        System.out.println(new FindLeavesOfBinaryTree().findLeaves(root));
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        while (true) {
            List<Integer> removeResult = new ArrayList<>();
            if (removeResult(root, removeResult)) {
                result.add(removeResult);
                break;
            }
            result.add(removeResult);
        }
        return result;
    }

    private boolean removeResult(TreeNode node, List<Integer> removeResult) {
        if (node.left == null && node.right == null) {
            removeResult.add(node.val);
            return true;
        }

        if (node.left != null) {
            if (removeResult(node.left, removeResult)) {
                node.left = null;
            }
        }
        if (node.right != null) {
            if (removeResult(node.right, removeResult)) {
                node.right = null;
            }
        }

        return false;
    }

}
