package leetcode.year_2024.may;

import common.TreeNode;
import util.TreeDeserializer;

public class DeleteLeavesWithAGivenValue {

  public static void main(String[] args) {
    System.out.println(new DeleteLeavesWithAGivenValue().removeLeafNodes(
        TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3, 2, null, 2, 4}), 2));
    System.out.println(new DeleteLeavesWithAGivenValue().removeLeafNodes(
        TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 3, 3, 3, 2}), 3));
    System.out.println(new DeleteLeavesWithAGivenValue().removeLeafNodes(
        TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, null, 2, null, 2}), 2));
  }

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    removeLeaf(root, root.left, target, true);
    removeLeaf(root, root.right, target, false);

    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }
    return root;

  }

  private void removeLeaf(TreeNode parent, TreeNode node, int target, boolean left) {
    if (node == null) {
      return;
    }

    removeLeaf(node, node.left, target, true);
    removeLeaf(node, node.right, target, false);

    if (node.left == null && node.right == null && node.val == target) {
      if (left) {
        parent.left = null;
      } else {
        parent.right = null;
      }
    }
  }

}
