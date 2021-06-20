package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class DiameterOfBinaryTree {
    private int max = 0;

    public static void main(String[] args) {
        /*String s = "1,2,4,null,null,5,null,null,3,null,null";*/
        String s = "1,2";
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(deserialize(s)));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findMaxLen(root);
        return max;
    }

    private int findMaxLen(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int maxLeft = findMaxLen(node.left);
        int maxRight = findMaxLen(node.right);
        int maxLen = Math.max(maxLeft, maxRight);
        max = Math.max(max, maxLeft + maxRight);
        return maxLen + 1;
    }

    public static TreeNode deserialize(String data) {
        ArrayList<String> nodeVals = new ArrayList<>(Arrays.asList(data.split(",")));
        TreeNode root = deserialize(nodeVals);
        return root;
    }

    private static TreeNode deserialize(ArrayList<String> nodeVals) {
        if (nodeVals.size() == 0) {
            return null;
        }
        String value = nodeVals.get(0);
        nodeVals.remove(0);
        TreeNode node = value.equals("null") ? null : new TreeNode(Integer.parseInt(value));

        if (node != null) {
            node.left = deserialize(nodeVals);
            node.right = deserialize(nodeVals);
        }

        return node;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
