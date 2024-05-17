package leetcode.year_2022.august;

public class InorderSuccessorIinBstIi {

    Node suNode = null;

    public Node inorderSuccessor(Node node) {
        Node root = findRoot(node);
        if (node.val > root.val) {
            findFromTraverse(root.right, node.val);
        } else if (node.val == root.val) {
            findFromTraverse(root.right, node.val);
        } else {
            suNode = root;
            findFromTraverse(root.left, node.val);
        }

        return suNode;
    }

    private Node findRoot(Node node) {
        while (node.parent != null) {
            node = node.parent;
        }
        return node;
    }

    private void findFromTraverse(Node node, int defVal) {
        if (node == null) {
            return;
        }
        if (defVal < node.val) {
            if (suNode == null) {
                suNode = node;
            } else if (suNode.val > node.val) {
                suNode = node;
            }
        }
        findFromTraverse(node.left, defVal);
        findFromTraverse(node.right, defVal);
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.left = node1;
        node2.right = node3;
        node1.parent = node2;
        node3.parent = node2;
        System.out.println(new InorderSuccessorIinBstIi().inorderSuccessor(node1).val);
    /*Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    node5.left = node3;
    node5.right = node6;
    node3.parent = node5;
    node3.left = node2;
    node3.right = node4;
    node2.parent = node3;
    node2.left = node1;
    node6.parent = node5;
    System.out.println(new InorderSuccessorIinBstIi().inorderSuccessor(node6).val);*/
    }

    static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val, Node left, Node right,
                    Node parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node(int val) {
            this.val = val;
        }

    }

    ;

}
