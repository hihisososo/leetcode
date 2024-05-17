package leetcode.year_2022.december;

import common.TreeNode;
import util.TreeDeserializer;

public class MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args) {
        System.out.println(new MaximumProductOfSplittedBinaryTree().maxProduct(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6})));
        System.out.println(new MaximumProductOfSplittedBinaryTree().maxProduct(TreeDeserializer.deserializeBinaryTree(new Integer[]{1, null, 2, 3, 4, null, null, 5, 6})));
    }

    int nearTargetSubSum = 0;

    public int maxProduct(TreeNode root) {
        int allSum = getAllSum(root);
        findNearest(root, allSum / 2, allSum % 2 == 1);
        long result = (long) (allSum - nearTargetSubSum) * (long) nearTargetSubSum;
        return (int) result % (1000000000 + 7);
    }

    private int findNearest(TreeNode node, int target, boolean isOdd) {
        if (node == null) {
            return 0;
        }

        int subSumAll = findNearest(node.left, target, isOdd) + findNearest(node.right, target, isOdd) + node.val;
        int diffMinCurr = Math.abs(nearTargetSubSum - target);
        int diffAll = Math.abs(subSumAll - target);
        if (diffAll < diffMinCurr) {
            nearTargetSubSum = subSumAll;
        } else if (diffAll == diffMinCurr && isOdd) {
            nearTargetSubSum = subSumAll > nearTargetSubSum ? subSumAll : nearTargetSubSum;
        }
        return subSumAll;
    }

    private int getAllSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val;

        sum += (getAllSum(node.left) + getAllSum(node.right));
        return sum;
    }
}
