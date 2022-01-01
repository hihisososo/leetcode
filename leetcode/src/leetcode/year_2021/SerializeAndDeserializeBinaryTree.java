package leetcode.year_2021;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

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
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuffer sb) {
        sb.append(",");
        if (node == null) {
            sb.append("null");
            return;
        } else {
            sb.append(node.val);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }


    }

    public TreeNode deserialize(String data) {
        ArrayList<String> nodeVals = new ArrayList<>(Arrays.asList(data.split(",")));
        TreeNode root = deserialize(nodeVals);
        return root;
    }

    private TreeNode deserialize(ArrayList<String> nodeVals) {
        if (nodeVals.size() == 0) {
            return null;
        }
        String value = nodeVals.get(0);
        nodeVals.remove(0);
        TreeNode node = value.equals("null") ? null : new TreeNode(Integer.parseInt(value));

        if (node != null) {
            node.left = deserialize(nodeVals);
            node.right = deserialize(nodeVals);
        }

        return node;
    }
}
