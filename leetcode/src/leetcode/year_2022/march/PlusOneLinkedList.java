package leetcode.year_2022.march;

import common.ListNode;

public class PlusOneLinkedList {
    public static void main(String[] args) {
//        ListNode head = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode head = new ListNode(0);
        ListNode node = new PlusOneLinkedList().plusOne(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode plusOne(ListNode head) {
        if(head == null){
            return null;
        }
        if (plus(head)) {
            return new ListNode(1, head);
        } else {
            return head;
        }
    }

    private boolean plus(ListNode node) {
        boolean carry = false;
        if (node.next == null) {
            return add(node, true);
        } else {
            carry = plus(node.next);
            return add(node, carry);
        }

    }

    private boolean add(ListNode node, boolean carry) {
        if (node.val == 9 && carry) {
            node.val = 0;
            return true;
        } else {
            node.val += carry ? 1 : 0;
            return false;
        }
    }
}
