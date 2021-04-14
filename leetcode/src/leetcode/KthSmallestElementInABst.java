package leetcode;

import java.util.ArrayList;

public class KthSmallestElementInABst {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
		System.out.println(new KthSmallestElementInABst().kthSmallest(root, 1));
	}

	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> smallList = new ArrayList<Integer>();
		fillSmallest(root, smallList, k);
		return smallList.get(k-1);
	}

	private void fillSmallest(TreeNode node, ArrayList<Integer> smallList, int k) {
		if (smallList.size() >= k) {
			return;
		}
		if (node.left != null) {
			fillSmallest(node.left, smallList, k);
		}
		smallList.add(node.val);
		if (node.right != null) {
			fillSmallest(node.right, smallList, k);
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
