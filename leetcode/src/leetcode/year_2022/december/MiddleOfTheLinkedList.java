package leetcode.year_2022.december;

import common.ListNode;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))).val);
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))).val);
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1)).val);
        System.out.println(new MiddleOfTheLinkedList().middleNode(new ListNode(1, new ListNode(2))).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode oneJump = head;
        ListNode twoJump = head;

        while (twoJump.next != null) {
            twoJump = twoJump.next;
            if (twoJump.next != null) {
                twoJump = twoJump.next;
            }
            oneJump = oneJump.next;
        }

        return oneJump;
    }
}
