package leetcode;

import common.TreeNode;

import java.util.ArrayList;

public class LowestCommonAncestorOfABinaryTree {
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(5);
//		root.left.left = new TreeNode(6);
//		root.left.right = new TreeNode(2);
//		root.left.right.left = new TreeNode(7);
//		root.left.right.right = new TreeNode(4);
//
//		root.right = new TreeNode(1);
//		root.right.left = new TreeNode(0);
//		root.right.right = new TreeNode(8);

		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(3);

		TreeNode p = root.left;
		TreeNode q = root.right;

		System.out.println(new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, p, q));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ArrayList<TreeNode> pParents = findParents(root, p);
		ArrayList<TreeNode> qParents = findParents(root, q);

		int idx = pParents.size() > qParents.size() ? qParents.size() : pParents.size();
		TreeNode pVal = null, qVal = null;
		for (int i = 0; i < idx; i++) {
			pVal = pParents.get(i);
			qVal = qParents.get(i);

			if (pVal != qVal) {
				return pParents.get(i - 1);
			}
		}

		return pVal;
	}

	private ArrayList<TreeNode> findParents(TreeNode root, TreeNode target) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		find(root, target, new ArrayList<TreeNode>(), result);

		return result;
	}

	private void find(TreeNode node, TreeNode target, ArrayList<TreeNode> path, ArrayList<TreeNode> result) {
		if (result.size() > 0) {
			return;
		}
		path.add(node);
		if (node.val == target.val) {
			result.addAll(path);
			return;
		}

		if (node.left != null) {
			find(node.left, target, path, result);
		}
		if (node.right != null) {
			find(node.right, target, path, result);
		}

		path.remove(node);

	}

}
