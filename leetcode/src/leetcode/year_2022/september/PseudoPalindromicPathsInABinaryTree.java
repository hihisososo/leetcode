package leetcode.year_2022.september;

import common.TreeNode;
import util.TreeDeserializer;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsInABinaryTree {
    public static void main(String[] args) {
        System.out.println(new PseudoPalindromicPathsInABinaryTree().pseudoPalindromicPaths(TreeDeserializer.deserializeBinaryTree(new Integer[]{2, 3, 1, 3, 1, null, 1})));
        System.out.println(new PseudoPalindromicPathsInABinaryTree().pseudoPalindromicPaths(TreeDeserializer.deserializeBinaryTree(new Integer[]{2, 1, 1, 1, 3, null, null, null, null, null, 1})));
        System.out.println(new PseudoPalindromicPathsInABinaryTree().pseudoPalindromicPaths(TreeDeserializer.deserializeBinaryTree(new Integer[]{9})));
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        return countPalindromicPath(root, cntMap);
    }

    private int countPalindromicPath(TreeNode node, Map<Integer, Integer> cntMap) {
        cntMap.putIfAbsent(node.val, 0);
        cntMap.put(node.val, cntMap.get(node.val) + 1);
        int palindromeCnt = 0;
        if (node.left == null && node.right == null) {
            int cnt = checkPalindrome(cntMap);
            cntMap.put(node.val, cntMap.get(node.val) - 1);
            return cnt;
        }
        if (node.left != null) {
            palindromeCnt += countPalindromicPath(node.left, cntMap);
        }
        if (node.right != null) {
            palindromeCnt += countPalindromicPath(node.right, cntMap);
        }
        cntMap.put(node.val, cntMap.get(node.val) - 1);
        return palindromeCnt;
    }

    private int checkPalindrome(Map<Integer, Integer> cntMap) {
        int oddCnt = 0;
        for (Map.Entry<Integer, Integer> e : cntMap.entrySet()) {
            if (e.getValue() % 2 == 1) {
                oddCnt++;
                if (oddCnt == 2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
