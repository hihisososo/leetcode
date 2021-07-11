package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeRightSideView {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
		System.out.println(new BinaryTreeRightSideView().rightSideView(root));
	}

	public List<Integer> rightSideView(TreeNode root) {
		HashMap<Integer, Integer> views = new HashMap<Integer, Integer>();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if (root == null) {
			return nums;
		}

		addRightSide(root, views, 1);
		for (Integer key : views.keySet()) {
			nums.add(views.get(key));
		}
		return nums;
	}

	private void addRightSide(TreeNode node, HashMap<Integer, Integer> views, int depth) {
		if (node != null) {
			views.put(depth, node.val);
		}

		if (node.left != null) {
			addRightSide(node.left, views, depth + 1);
		}
		if (node.right != null) {
			addRightSide(node.right, views, depth + 1);
		}
	}

}
