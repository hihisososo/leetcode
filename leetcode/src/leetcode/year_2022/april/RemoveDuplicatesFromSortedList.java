package leetcode.year_2022.april;

import common.ListNode;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
//    ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        ListNode node = result;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        HashSet<Integer> dupSet = new HashSet<>();
        dupSet.add(head.val);
        ListNode lastNode = head;
        ListNode node = head;
        while (node != null) {
            if (!dupSet.contains(node.val)) {
                dupSet.add(node.val);
                lastNode.next = node;
                lastNode = node;
            }
            node = node.next;
        }
        lastNode.next = null;
        return head;
    }

}
