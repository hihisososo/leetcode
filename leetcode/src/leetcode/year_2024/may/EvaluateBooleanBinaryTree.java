package leetcode.year_2024.may;

import common.TreeNode;
import util.TreeDeserializer;

public class EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        System.out.println(new EvaluateBooleanBinaryTree().evaluateTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{2, 1, 3, null, null, 0, 1})));
        System.out.println(new EvaluateBooleanBinaryTree().evaluateTree(TreeDeserializer.deserializeBinaryTree(new Integer[]{0})));
    }

    public boolean evaluateTree(TreeNode root) {
        return evaluate(root);
    }

    private boolean evaluate(TreeNode node) {
        int val = node.val;
        if (val == 0) {
            return false;
        } else if (val == 1) {
            return true;
        } else if (val == 2) {
            return evaluate(node.left) || evaluate(node.right);
        } else {
            return evaluate(node.left) && evaluate(node.right);
        }
    }
}
