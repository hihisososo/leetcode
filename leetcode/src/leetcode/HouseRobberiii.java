package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobberiii {
    public static void main(String[] args) {
        System.out.println(new HouseRobberiii().rob(deserialize("3,2,null,3,3,null,1")));
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = maxRob(root);
        return Math.max(result[0], result[1]);

    }

    private int[] maxRob(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = maxRob(node.left);
        int[] right = maxRob(node.right);

        int robMax = left[1] + node.val + right[1];

        int noRobMax = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robMax, noRobMax};

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
}
