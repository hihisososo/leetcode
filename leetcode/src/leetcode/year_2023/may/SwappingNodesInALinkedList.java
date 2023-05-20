package leetcode.year_2023.may;

import common.ListNode;

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        print(new SwappingNodesInALinkedList().swapNodes(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));

    }

    public ListNode swapNodes(ListNode head, int k) {
        int len = getLen(head);
        int leftIdx = k;
        int rightIdx = len - k + 1;
        if (leftIdx == rightIdx) {
            return head;
        }
        swapNode(head, leftIdx, rightIdx);
        return head;
    }

    private void swapNode(ListNode head, int leftIdx, int rightIdx) {
        ListNode node = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        int idx = 0;
        while (node != null) {
            idx++;
            if (idx == leftIdx) {
                leftNode = node;
            } else if (idx == rightIdx) {
                rightNode = node;
            }
            node = node.next;
        }
        int tempVal = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = tempVal;
    }

    private int getLen(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    private static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
