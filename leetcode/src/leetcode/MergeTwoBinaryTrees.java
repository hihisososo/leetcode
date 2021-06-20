package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode root1 = deserialize("1,3,5,null,null,null,2,null,null");
        TreeNode root2 = deserialize("2,1,null,4,null,null,3,null,7,null,null");
        TreeNode result = new MergeTwoBinaryTrees().mergeTrees(root1, root2);
        System.out.println(result);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        int node1Val = node1 == null ? 0 : node1.val;
        int node2Val = node2 == null ? 0 : node2.val;

        TreeNode newNode = new TreeNode(node1Val + node2Val);
        newNode.left = merge(node1 == null ? null : node1.left, node2 == null ? null : node2.left);
        newNode.right = merge(node1 == null ? null : node1.right, node2 == null ? null : node2.right);

        return newNode;
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
