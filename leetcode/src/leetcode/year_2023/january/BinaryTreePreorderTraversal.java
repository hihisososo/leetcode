package leetcode.year_2023.january;

import common.TreeNode;
import util.TreeDeserializer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        System.out.println(new BinaryTreePreorderTraversal()
                .preorderTraversal(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, null, 2, 3})));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        traverse(root, preorder);
        return preorder;
    }

    private void traverse(TreeNode node, List<Integer> preorder) {
        if (node == null) {
            return;
        }
        preorder.add(node.val);
        if (node.left != null) {
            traverse(node.left, preorder);
        }
        if (node.right != null) {
            traverse(node.right, preorder);
        }
    }
}
