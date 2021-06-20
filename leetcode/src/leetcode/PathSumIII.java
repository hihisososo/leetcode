package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PathSumIII {
    private int cnt = 0;

    public static void main(String[] args) {
        String s = "10,5,3,3,null,null,-2,null,null,2,null,1,null,null,-3,null,11,null,null";
        TreeNode root = new PathSumIII().deserialize(s);

        System.out.println(new PathSumIII().pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int targetSum) {
        traverseInOrder(root, targetSum);
        return cnt;
    }

    private void traverseInOrder(TreeNode node, int targetSum) {
        if (node == null) {
            return;
        }
        findPathSum(node, 0, targetSum);

        traverseInOrder(node.left, targetSum);
        traverseInOrder(node.right, targetSum);
    }

    private void findPathSum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return;
        }

        sum += node.val;
        if (sum == targetSum) {
            cnt++;
        }

        findPathSum(node.left, sum, targetSum);
        findPathSum(node.right, sum, targetSum);
    }


    public TreeNode deserialize(String data) {
        ArrayList<String> nodeVals = new ArrayList<>(Arrays.asList(data.split(",")));
        TreeNode root = deserialize(nodeVals);
        return root;
    }

    private TreeNode deserialize(ArrayList<String> nodeVals) {
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

    public class TreeNode {
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
