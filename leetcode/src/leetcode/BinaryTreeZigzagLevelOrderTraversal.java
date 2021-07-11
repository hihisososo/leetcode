package leetcode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = deserialize("3,9,null,null,20,15,null,null,7,null,null");
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        traverseZigzag(queue, result, false);

        return result;
    }

    private void traverseZigzag(ArrayDeque<TreeNode> queue, List<List<Integer>> result, boolean isRight) {
        if (queue.isEmpty()) {
            return;
        }
        LinkedList<Integer> thisLevelList = new LinkedList<Integer>();
        ArrayDeque<TreeNode> newQueue = new ArrayDeque<TreeNode>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (isRight) {
                thisLevelList.addFirst(node.val);
            } else {
                thisLevelList.addLast(node.val);
            }

            if (node.left != null) {
                newQueue.addLast(node.left);
            }
            if (node.right != null) {
                newQueue.addLast(node.right);
            }
        }
        result.add(thisLevelList);
        traverseZigzag(newQueue, result, !isRight);
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
