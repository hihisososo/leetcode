package leetcode.year_2022.december;

import common.TreeNode;
import javafx.util.Pair;
import util.TreeDeserializer;

public class MaximumDifferenceBetweenNodeAndAncestor {
	public static void main(String[] args) {
		System.out.println(new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(TreeDeserializer.deserializeBinaryTree(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13})));
		System.out.println(new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, null, 2, null, 0, 3})));
	}

	private int allMax = 0;

	public int maxAncestorDiff(TreeNode root) {
		dfs(root);
		return allMax;
	}

	private Pair<Integer, Integer> dfs(TreeNode node) {
		if (node == null) {
			return new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		int min = node.val;
		int max = node.val;

		Pair<Integer, Integer> leftMinMax = dfs(node.left);
		Pair<Integer, Integer> rightMinMax = dfs(node.right);

		min = Math.min(min, leftMinMax.getKey());
		min = Math.min(min, rightMinMax.getKey());
		max = Math.max(max, leftMinMax.getValue());
		max = Math.max(max, rightMinMax.getValue());

		int diffMin = Math.abs(node.val - min);
		int diffMax = Math.abs(node.val - max);

		allMax = Math.max(allMax, Math.max(diffMin, diffMax));
		return new Pair<>(min, max);
	}
}
