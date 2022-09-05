package leetcode.year_2022.september;

import common.TreeNode;
import util.TreeDeserializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoundaryOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10});
        System.out.println(new BoundaryOfBinaryTree().boundaryOfBinaryTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10})));
        System.out.println(new BoundaryOfBinaryTree().boundaryOfBinaryTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, null, 2, 3, 4})));
        System.out.println(new BoundaryOfBinaryTree().boundaryOfBinaryTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{37, -34, -48, null, -100, -100, 48, null, null, null, null, -54, null, -71, -22, null, null, null, 8})));
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftBound = new ArrayList<>();
        List<Integer> rightBound = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left != null) {
            findLeftBoundary(root.left, leftBound);
        }
        if (root.right != null) {
            findRightBoundary(root.right, rightBound);
        }
        if (root.left != null || root.right != null) {
            findLeaves(root, leaves);
        }

        result.add(root.val);
        Collections.reverse(leftBound);
        result.addAll(leftBound);
        result.addAll(leaves);
        result.addAll(rightBound);
        System.out.println(root.val + ":" + leftBound + ":" + leaves + ":" + rightBound);
        return result.stream().collect(Collectors.toList());
    }

    private void findLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            findLeaves(node.left, leaves);
        }
        if (node.right != null) {
            findLeaves(node.right, leaves);
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
    }

    private void findRightBoundary(TreeNode node, List<Integer> rightBound) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            findRightBoundary(node.right, rightBound);
        } else if (node.left != null) {
            findRightBoundary(node.left, rightBound);
        }
        if (node.left != null || node.right != null) {
            rightBound.add(node.val);
        }
    }

    private void findLeftBoundary(TreeNode node, List<Integer> leftBound) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            findLeftBoundary(node.left, leftBound);
        } else if (node.right != null) {
            findLeftBoundary(node.right, leftBound);
        }
        if (node.left != null || node.right != null) {
            leftBound.add(node.val);
        }
    }
}
