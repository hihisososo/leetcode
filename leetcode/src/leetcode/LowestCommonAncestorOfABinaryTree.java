package leetcode;

import java.util.ArrayList;

public class LowestCommonAncestorOfABinaryTree {
	public static void main(String[] args) {
		// TreeNode root = new TreeNode(3);
		// root.left = new TreeNode(5);
		// root.left.left = new TreeNode(6);
		// root.left.right = new TreeNode(2);
		// root.left.right.left = new TreeNode(7);
		// root.left.right.right = new TreeNode(4);
		//
		// root.right = new TreeNode(1);
		// root.right.left = new TreeNode(0);
		// root.right.right = new TreeNode(8);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		TreeNode p = root.left;
		TreeNode q = root.right;
		TreeNode result = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, p, q);
		System.out.println(result.val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ArrayList<TreeNode> pParents = findParents(root, p);
		ArrayList<TreeNode> qParents = findParents(root, q);

		int idx = pParents.size() > qParents.size() ? qParents.size() : pParents.size();
		TreeNode pNode = null, qNode = null;
		for (int i = 0; i < idx; i++) {
			pNode = pParents.get(i);
			qNode = qParents.get(i);

			if (pNode.val != qNode.val) {
				return pParents.get(i - 1);
			}
		}

		return pNode;
	}

	private TreeNode findParents(TreeNode root, TreeNode target) {
		TreeNode parentNodeHead = new TreeNode(root.val);
		find(root, target, parentNodeHead, parentNodeHead);
		
		return parentNodeHead;
	}

	private void find(TreeNode node, TreeNode target, TreeNode parentNodeHead, TreeNode parentNodeTail) {
		parentNodeTail.left = new TreeNode(node.val);
		parentNodeTail = parentNodeTail.left;
		if(node.val == target.val){
			return;
		}
		
		if (node.left != null) {
			find(node.left, target, parentNodeHead, parentNodeTail);
		}
		if (node.right != null) {
			find(node.right, target, parentNodeHead, parentNodeTail);
		}
		
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
