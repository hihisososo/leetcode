package leetcode.year_2022.april;

import common.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode node = new SwapNodesInPairs().swapPairs(root);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        return swap(head);
    }

    private ListNode swap(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode child = node.next;
        if (child == null) {
            return node;
        }
        ListNode next = child.next;
        child.next = node;
        node.next = swap(next);
        return child;
    }
}
