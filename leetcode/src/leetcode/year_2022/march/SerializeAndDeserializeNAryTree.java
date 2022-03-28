package leetcode.year_2022.march;

import java.util.*;

public class SerializeAndDeserializeNAryTree {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i <= 14; i++) {
            nodes.add(new Node(i, null));
        }
        addChild(nodes, 11, 14);
        addChild(nodes, 7, 11);
        addChild(nodes, 8, 12);
        addChild(nodes, 9, 13);

        addChild(nodes, 3, 6);
        addChild(nodes, 3, 7);
        addChild(nodes, 4, 8);
        addChild(nodes, 5, 9);
        addChild(nodes, 5, 10);

        addChild(nodes, 1, 2);
        addChild(nodes, 1, 3);
        addChild(nodes, 1, 4);
        addChild(nodes, 1, 5);


        SerializeAndDeserializeNAryTree codec = new SerializeAndDeserializeNAryTree();
        System.out.println(codec.serialize(codec.deserialize(codec.serialize(nodes.get(1)))));
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val + ",null");
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.children != null) {
                for (Node c : poll.children) {
                    sb.append("," + c.val);
                    queue.add(c);
                }
            }
            sb.append(",null");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        Node root = null;
        Deque<Node> queue = new ArrayDeque<>();
        Node parent = null;
        for (String val : data.split(",")) {
            if (val.equals("null")) {
                parent = queue.poll();
                continue;
            } else {
                Node node = new Node(Integer.parseInt(val), new ArrayList<>());
                queue.add(node);
                if (root == null) {
                    root = node;
                }
            }
            if (parent != null) {
                parent.children.add(queue.getLast());
            }
        }
        return root;
    }

    private static void addChild(List<Node> nodes, int p, int c) {
        if(nodes.get(p).children == null){
            nodes.get(p).children = new ArrayList<>();
        }
        nodes.get(p).children.add(nodes.get(c));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
