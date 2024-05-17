package leetcode.year_2022.september;

import common.TreeNode;
import util.TreeDeserializer;

public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        System.out.println(new ConstructStringFromBinaryTree()
                .tree2str(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3, 4})));
        System.out.println(new ConstructStringFromBinaryTree()
                .tree2str(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3, null, 4})));
        System.out.println(new ConstructStringFromBinaryTree()
                .tree2str(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, null, 3, 4})));
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String result = toStr(root);
        return result.substring(1, result.length() - 1);
    }

    private String toStr(TreeNode node) {
        if (node == null) {
            return "()";
        }

        String left = toStr(node.left);
        String right = toStr(node.right);
        if (left.equals("()") && right.equals("()")) {
            return "(" + node.val + ")";
        } else if (left.equals("()")) {
            return "(" + node.val + left + right + ")";
        } else if (right.equals("()")) {
            return "(" + node.val + left + ")";
        }

        return "(" + node.val + left + right + ")";
    }
}
