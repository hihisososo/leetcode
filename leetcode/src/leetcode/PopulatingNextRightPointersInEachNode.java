package leetcode;

import java.util.ArrayDeque;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, new Node(6), new Node(7), null), null);
        new PopulatingNextRightPointersInEachNode().connect(root);
        System.out.println(root);
    }

    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        connect(queue);

        return root;
    }

    private void connect(ArrayDeque<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }

        ArrayDeque<Node> newQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.left != null){
                newQueue.add(node.left);
            }
            if(node.right != null){
                newQueue.add(node.right);
            }

            if (!queue.isEmpty()) {
                Node node2 = queue.getFirst();
                node.next = node2;
            }
        }

        connect(newQueue);
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
