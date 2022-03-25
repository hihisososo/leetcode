package leetcode.year_2022.march;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    public static void main(String[] args) {
        Node root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        Node node = new ConvertBinarySearchTreeToSortedDoublyLinkedList().treeToDoublyList(root);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

    Node head;
    Node lastNode;

    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        findHeadAndMakeLinkedList(root);
        lastNode.right = head;
        head.left = lastNode;
        return head;
    }

    private void findHeadAndMakeLinkedList(Node node) {
        if (node == null) {
            return;
        }

        findHeadAndMakeLinkedList(node.left);

        if (head == null) {
            head = node;
        }
        if (lastNode != null) {
            node.left = lastNode;
            lastNode.right = node;
        }

        lastNode = node;

        findHeadAndMakeLinkedList(node.right);

    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}