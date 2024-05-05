package leetcode.year_2024.may;

import common.ListNode;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, new ListNode(1, new ListNode(9)));
        ListNode node = new ListNode(4, node5);
        new DeleteNodeInALinkedList().deleteNode(node5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
    }
}
