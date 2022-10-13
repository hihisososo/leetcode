package leetcode.year_2022.october;

import common.ListNode;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        if (nextNode.next != null) {
            node.next = nextNode.next;
        } else {
            node.next = null;
        }
    }
}
