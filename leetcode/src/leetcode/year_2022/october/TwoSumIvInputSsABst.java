package leetcode.year_2022.october;

import common.TreeNode;
import util.TreeDeserializer;

public class TwoSumIvInputSsABst {
    public static void main(String[] args) {
        System.out.println(new TwoSumIvInputSsABst().findTarget(TreeDeserializer.deserializeBinaryTree(new Integer[]{1}), 2));
        System.out.println(new TwoSumIvInputSsABst().findTarget(TreeDeserializer.deserializeBinaryTree(new Integer[]{2, 1, 3}), 4));
        System.out.println(new TwoSumIvInputSsABst().findTarget(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 0, 4, -2, null, 3}), 7));
        System.out.println(new TwoSumIvInputSsABst().findTarget(TreeDeserializer.deserializeBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 9));
        System.out.println(new TwoSumIvInputSsABst().findTarget(TreeDeserializer.deserializeBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 28));
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfsAndFindTarget(root, root, k);
    }

    private boolean dfsAndFindTarget(TreeNode root, TreeNode currNode, int k) {
        if (currNode == null) {
            return false;
        }
        boolean find = isTargetExist(root, k - currNode.val);
        if (find && currNode.val * 2 != k) {
            return true;
        } else {
            return dfsAndFindTarget(root, currNode.left, k) || dfsAndFindTarget(root, currNode.right, k);
        }
    }

    private boolean isTargetExist(TreeNode root, int val) {
        return dfsFind(root, val);
    }

    private boolean dfsFind(TreeNode node, int val) {
        if (node == null) {
            return false;
        }

        if (node.val == val) {
            return true;
        }

        return dfsFind(node.left, val) || dfsFind(node.right, val);
    }
}
