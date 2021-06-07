package leetcode;

import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


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
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        serialize(nodes, sb);

        String s = sb.replace(sb.length() - 1, sb.length(), "").append("]").toString();
        System.out.println(s);
        return s;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.replace("[", "").replace("]", "");
        String[] treeArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(treeArr[0]));
        deserialize(treeArr, root, 1);
        return root;
    }

    private void serialize(ArrayList<TreeNode> nodes, StringBuilder sb) {
        if (nodes.size() == 0) {
            return;
        }

        for (int i = 0; i < nodes.size(); i++) {
            sb.append(nodes.get(i).val).append(",");
        }

        ArrayList<TreeNode> nextNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null) {
                nextNodes.add(nodes.get(i).left);
            }
            if (nodes.get(i).right != null) {
                nextNodes.add(nodes.get(i).right);
            }
        }
        serialize(nextNodes, sb);
    }

    private void deserialize(String[] treeArr, TreeNode node, int idx) {
        if (idx >= treeArr.length) {
            return;
        }

        if (treeArr[idx].equals("null")) {
            return;
        }

        node.left = new TreeNode(Integer.parseInt(treeArr[idx]));
        if (idx + 1 >= treeArr.length) {
            return;
        }
        node.right = new TreeNode(Integer.parseInt(treeArr[idx + 1]));
        deserialize(treeArr, node.left, (idx + 1) * 2);
        deserialize(treeArr, node.right, (idx + 2) * 2);

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
