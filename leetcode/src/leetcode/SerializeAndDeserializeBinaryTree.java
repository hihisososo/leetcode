package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);


        SerializeAndDeserializeBinaryTree ser = new SerializeAndDeserializeBinaryTree();
        SerializeAndDeserializeBinaryTree deser = new SerializeAndDeserializeBinaryTree();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println(ans);
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        serialize(nodes, sb, 0);


        String s = sb.replace(sb.length() - 1, sb.length(), "").append("]").toString();
        System.out.println(s);
        return s;
    }

    private void serialize(LinkedList<TreeNode> nodes, StringBuilder sb, int nullCnt) {
        if (nodes.size() == 0) {
            return;
        }

        int size = nodes.size();
        if(nullCnt == size){
            return;
        }

        nullCnt = 0;
        while(size > 0){
            TreeNode node = nodes.pollFirst();
            sb.append((node == null ? "null" : node.val) + ",");
            size--;
            if(node == null){
                nullCnt += 2;
                nodes.addLast(null);
                nodes.addLast(null);
            }else{
                if(node.left == null){
                    nullCnt++;
                }
                nodes.addLast(node.left);
                if(node.right == null){
                    nullCnt++;
                }
                nodes.addLast(node.right);
            }
        }

            serialize(nodes, sb, nullCnt);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] treeArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(treeArr[0]));
        deserialize(treeArr, root, 1);
        return root;
    }
    private void deserialize(String[] treeArr, TreeNode node, int idx) {
        if (idx >= treeArr.length || node == null) {
            return;
        }
        if (!treeArr[idx].equals("null")) {
            node.left = new TreeNode(Integer.parseInt(treeArr[idx]));
        }

        if (idx + 1 >= treeArr.length) {
            return;
        }
        if (!treeArr[idx+1].equals("null")) {
            node.right = new TreeNode(Integer.parseInt(treeArr[idx + 1]));
        }

        deserialize(treeArr, node.left, (idx * 2) + 1);
        deserialize(treeArr, node.right, (idx + 1) * 2 + 1);
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
