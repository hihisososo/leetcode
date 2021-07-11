package util;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeUtil {

    public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private static void serialize(TreeNode node, StringBuffer sb) {
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

    public static TreeNode deserialize(String data) {
        ArrayList<String> nodeVals = new ArrayList<>(Arrays.asList(data.split(",")));
        TreeNode root = deserialize(nodeVals);
        return root;
    }

    private static TreeNode deserialize(ArrayList<String> nodeVals) {
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
