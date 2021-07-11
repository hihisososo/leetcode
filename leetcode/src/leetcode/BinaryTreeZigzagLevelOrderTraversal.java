package leetcode;

import common.TreeNode;
import util.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.deserialize("3,9,null,null,20,15,null,null,7,null,null");
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

}
