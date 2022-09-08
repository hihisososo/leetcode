package leetcode.year_2022.september;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;
import util.TreeDeserializer;

public class BinaryTreeInorderTraversal {

  public static void main(String[] args) {
    System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(
        TreeDeserializer.deserializeBinaryTree(new Integer[]{1, null, 2, 3})));
    System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(null));
    System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(
        TreeDeserializer.deserializeBinaryTree(new Integer[]{1})));
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderTraverse(root, result);
    return result;
  }

  private void inorderTraverse(TreeNode node, List<Integer> result) {
    if (node == null) {
      return;
    }

    if (node.left != null) {
      inorderTraverse(node.left, result);
    }
    result.add(node.val);
    if (node.right != null) {
      inorderTraverse(node.right, result);
    }
  }
}
