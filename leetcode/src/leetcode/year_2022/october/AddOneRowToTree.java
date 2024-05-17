package leetcode.year_2022.october;

import common.TreeNode;
import util.TreeDeserializer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public static void main(String[] args) {
        TreeNode root = new AddOneRowToTree().addOneRow(TreeDeserializer.deserializeBinaryTree(new Integer[]{4, 2, 6, 3, 1, 5}), 1, 2);
        TreeNode root2 = new AddOneRowToTree().addOneRow(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3, 4}), 5, 4);
        System.out.println("D");
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> currDepthQueue = new LinkedList<>();
        Queue<TreeNode> nextDepthQueue = new LinkedList<>();
        currDepthQueue.add(root);
        int currDepth = 1;
        while (!currDepthQueue.isEmpty()) {
            Iterator<TreeNode> iter = currDepthQueue.iterator();
            while (iter.hasNext()) {
                TreeNode currNode = iter.next();
                if (currNode.left != null) {
                    nextDepthQueue.add(currNode.left);
                }
                if (currNode.right != null) {
                    nextDepthQueue.add(currNode.right);
                }
            }
            if (++currDepth >= depth) {
                System.out.println(currDepth);
                break;
            } else {
                currDepthQueue.clear();
                currDepthQueue.addAll(nextDepthQueue);
                nextDepthQueue.clear();
            }
        }

        while (!currDepthQueue.isEmpty()) {
            TreeNode parentNode = currDepthQueue.poll();
            TreeNode left = parentNode.left;
            TreeNode node = new TreeNode(val);
            parentNode.left = node;
            node.left = left;
            TreeNode right = parentNode.right;
            node = new TreeNode(val);
            parentNode.right = node;
            node.right = right;
        }
        return root;
    }
}
