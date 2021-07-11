package leetcode;

import common.TreeNode;

public class InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
				new TreeNode(7, new TreeNode(6), new TreeNode(9)));
		TreeNode result = new InvertBinaryTree().invertTree(node);
		System.out.println(result);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		return invert(root);
	}

	private TreeNode invert(TreeNode node) {
		if (node == null) {
			return node;
		}

		TreeNode nodeLeft = invert(node.left);
		TreeNode nodeRight = invert(node.right);
		node.left = nodeRight;
		node.right = nodeLeft;
		return node;
	}

}
