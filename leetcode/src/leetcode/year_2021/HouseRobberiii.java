package leetcode.year_2021;

import common.TreeNode;
import util.TreeUtil;

public class HouseRobberiii {
    public static void main(String[] args) {
        System.out.println(new HouseRobberiii().rob(TreeUtil.deserialize("3,2,null,3,3,null,1")));
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = maxRob(root);
        return Math.max(result[0], result[1]);

    }

    private int[] maxRob(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = maxRob(node.left);
        int[] right = maxRob(node.right);

        int robMax = left[1] + node.val + right[1];

        int noRobMax = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robMax, noRobMax};

    }

}
