package leetcode.year_2022.january;

import common.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new BinaryTreeVerticalOrderTraversal().verticalOrder(root));
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            map.putIfAbsent(pair.getValue(), new ArrayList<>());
            map.get(pair.getValue()).add(pair.getKey().val);
            if (pair.getKey().left != null) {
                queue.add(new Pair<>(pair.getKey().left, pair.getValue() - 1));
            }
            if (pair.getKey().right != null) {
                queue.add(new Pair<>(pair.getKey().right, pair.getValue() + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            result.add(e.getValue());
        }

        return result;
    }

}
