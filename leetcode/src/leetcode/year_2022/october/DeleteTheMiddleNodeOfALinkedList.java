package leetcode.year_2022.october;

import common.ListNode;

public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        print(new DeleteTheMiddleNodeOfALinkedList().deleteMiddle(new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))))));
        print(new DeleteTheMiddleNodeOfALinkedList().deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        print(new DeleteTheMiddleNodeOfALinkedList().deleteMiddle(new ListNode(2, new ListNode(1))));
    }

    private static void print(ListNode deleteMiddle) {
        while (deleteMiddle != null) {
            System.out.println(deleteMiddle.val);
            deleteMiddle = deleteMiddle.next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode middlePrev = head;
        ListNode curr = head.next;
        boolean even = true;
        while (curr.next != null) {
            curr = curr.next;
            even = !even;
            if (even) {
                middlePrev = middlePrev.next;
            }
        }

        middlePrev.next = middlePrev.next.next;
        return head;
    }
}
