package leetcode.year_2023.august;

import common.TreeNode;
import java.util.concurrent.atomic.AtomicInteger;
import util.TreeDeserializer;

public class MinimumDepthOfBinaryTree {

  public static void main(String[] args) {
    System.out.println(new MinimumDepthOfBinaryTree().minDepth(
        TreeDeserializer.deserializeBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    System.out.println(new MinimumDepthOfBinaryTree().minDepth(
        TreeDeserializer
            .deserializeBinaryTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
  }

  public int minDepth(TreeNode root) {
    if(root == null){
      return 0;
    }
    AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
    findMinDepth(root, 0, min);
    return min.get();
  }

  private void findMinDepth(TreeNode node, int depth, AtomicInteger min) {
    if (node == null) {
      return;
    }

    depth++;
    if (node.left == null && node.right == null) {
      min.set(Math.min(min.get(), depth));
      return;
    }

    findMinDepth(node.left, depth, min);
    findMinDepth(node.right, depth, min);
  }
}
