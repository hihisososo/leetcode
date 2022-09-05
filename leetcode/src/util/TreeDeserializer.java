package util;

import common.ListNode;
import common.TreeNode;

import java.util.Stack;

public class TreeDeserializer {
    public static TreeNode deserializeBinaryTree( Integer[] nodes ) {
        TreeNode[] madenodes  = new TreeNode[nodes.length];
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int n=0;
        for(int i=nodes.length-1;i>=0;i--) {
            TreeNode node = (nodes[i]==null) ? null : new TreeNode(nodes[i]);
            madenodes[nodes.length-1-(n++)] = node;
            stack.push( node );
        }
        TreeNode root = stack.pop();
        for( TreeNode node : madenodes ) {
            if( node!=null) {
                if( !stack.empty() ) node.left = stack.pop();
                if( !stack.empty() ) node.right = stack.pop();
            }
        }
        return root;
    }

    public static ListNode deserializeList(int[] list ){
        ListNode lastnode = null;
        for(int k=list.length-1;k>=0;k--) {
            ListNode node = new ListNode(list[k]);
            node.next = lastnode;
            lastnode = node;
        }
        return lastnode;
    }
}
