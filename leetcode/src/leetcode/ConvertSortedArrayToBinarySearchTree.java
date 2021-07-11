package leetcode;

import common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode result = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);
        System.out.println(result);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(int[] nums, int start, int end) {
        if (end - start == 0) {
            return new TreeNode(nums[start]);
        }
        if (end - start == 1) {
            TreeNode node = new TreeNode(nums[end]);
            node.left = new TreeNode(nums[start]);
            return node;
        }

        int mid = end - ((end - start) / 2);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, start, mid - 1);
        node.right = makeTree(nums, mid + 1, end);
        return node;
    }
}
