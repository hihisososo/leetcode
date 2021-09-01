package leetcode;

import common.TreeNode;
import util.TreeUtil;

import java.util.ArrayList;

public class InorderSuccessorInBst {
    public static void main(String[] args) {
//        TreeNode root = TreeUtil.deserialize("5,3,2,1,null,null,null,4,null,null,6,null,null");
        TreeNode root = TreeUtil.deserialize("2,1,null,null,3");
//        TreeNode root = TreeUtil.deserialize("2,null,3");
        System.out.println(new InorderSuccessorInBst().inorderSuccessor(root, new TreeNode(6)));
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        findNodes(root, p.val, nodes);
        if (nodes.size() == 0) {
            return null;
        }

        TreeNode successorNode = null;
        for (TreeNode node : nodes) {
            if (node.val > p.val) {
                if (successorNode == null) {
                    successorNode = node;
                } else {
                    successorNode = successorNode.val > node.val ? node : successorNode;
                }
            }
        }
        return successorNode;
    }

    private void findNodes(TreeNode node, int val, ArrayList<TreeNode> nodes) {
        if (node == null) {
            return;
        }

        if (node.val > val) {
            nodes.add(node);
            findNodes(node.left, val, nodes);
        } else {
            findNodes(node.right, val, nodes);
        }
    }
}
