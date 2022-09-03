package leetcode.year_2022.september;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        print(new ConstructBinaryTreeFromString().str2tree("4(2(3)(1))(6(5))"));
        print(new ConstructBinaryTreeFromString().str2tree("4(2(3)(1))(6(5)(7))"));
        print(new ConstructBinaryTreeFromString().str2tree("-4(2(3)(1))(6(5)(7))"));
    }

    public TreeNode str2tree(String s) {
        if (s.isEmpty()) return null;

        int numIdx = getNumIdx(s);
        TreeNode node = new TreeNode(Integer.parseInt(s.substring(0, numIdx)));
        s = s.substring(numIdx);

        if (!s.isEmpty()) {
            int leftIdx = parenthesisIndex(s);
            int rightIdx = leftIdx + 2;
            node.left = str2tree(s.substring(1, leftIdx));
            if (rightIdx < s.length()) {
                node.right = str2tree(s.substring(rightIdx, s.length() - 1));
            }
        }
        return node;
    }

    private int getNumIdx(String s) {
        return s.indexOf("(") > 0 ? s.indexOf("(") : s.length();
    }

    private int parenthesisIndex(String s) {
        if (s.isEmpty()) return 1;
        int openCnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCnt++;
            } else if (s.charAt(i) == ')') {
                openCnt--;
            }
            if (openCnt == 0) {
                return i;
            }
        }
        return 1;
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<TreeNode> nextNodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        System.out.println(root.val);
        while (true) {
            while (!nodeQueue.isEmpty()) {
                TreeNode poll = nodeQueue.poll();
                if (poll.left != null) {
                    System.out.print(poll.left.val + " ");
                    nextNodeQueue.add(poll.left);
                }
                if (poll.right != null) {
                    System.out.print(poll.right.val + " ");
                    nextNodeQueue.add(poll.right);
                }
            }
            if (nextNodeQueue.isEmpty()) {
                break;
            }
            System.out.println("");
            nodeQueue.addAll(nextNodeQueue);
            nextNodeQueue.clear();
        }
    }

}
