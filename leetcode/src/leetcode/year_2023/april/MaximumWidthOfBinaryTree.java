package leetcode.year_2023.april;

import common.TreeNode;
import util.TreeDeserializer;

import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 3, 2, 5, 3, null, 9})));
        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7})));
        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 3, 2, 5})));
        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{1})));
    }

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> currDepthQueue = new LinkedList<>();
        LinkedList<TreeNode> nextDepthQueue = new LinkedList<>();
        currDepthQueue.add(root);
        root.val = 1;
        int maxWidth = 1;

        while (!currDepthQueue.isEmpty()) {
            while (!currDepthQueue.isEmpty()) {
                TreeNode poll = currDepthQueue.poll();
                if (poll.left != null) {
                    poll.left.val = poll.val * 2;
                    nextDepthQueue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = poll.val * 2 + 1;
                    nextDepthQueue.add(poll.right);
                }
            }
            while (!nextDepthQueue.isEmpty()) {
                if (nextDepthQueue.size() > 1) {
                    maxWidth = Math.max(maxWidth, nextDepthQueue.getLast().val - nextDepthQueue.getFirst().val + 1);
                    nextDepthQueue.getLast();
                }
                currDepthQueue.addAll(nextDepthQueue);
                nextDepthQueue.clear();
            }
        }
        return maxWidth;
    }
}
