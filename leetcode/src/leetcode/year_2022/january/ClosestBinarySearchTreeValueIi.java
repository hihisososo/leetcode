package leetcode.year_2022.january;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValueIi {
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        TreeNode root = new TreeNode(1);
        System.out.println(new ClosestBinarySearchTreeValueIi().closestKValues(root, 3.714286, 2));
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> kQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double val1 = Math.abs(o1 - target);
                double val2 = Math.abs(o2 - target);
                if (val1 > val2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        findClosestKValues(root, target, k, kQueue);
        while (!kQueue.isEmpty()) {
            result.add(kQueue.poll());
        }
        return result;
    }

    private void findClosestKValues(TreeNode node, double target, int k, PriorityQueue<Integer> kQueue) {
        kQueue.add(node.val);
        while (kQueue.size() > k) {
            kQueue.poll();
        }

        if (node.right != null) {
            findClosestKValues(node.right, target, k, kQueue);
        }
        if (node.left != null) {
            findClosestKValues(node.left, target, k, kQueue);
        }
    }
}
