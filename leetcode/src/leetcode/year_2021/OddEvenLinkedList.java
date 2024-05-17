package leetcode.year_2021;

public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new OddEvenLinkedList().oddEvenList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newLeft = null;
        ListNode newLeftHead = null;
        ListNode newRight = null;
        ListNode newRightHead = null;

        ListNode node = head;
        boolean isEven = false;
        while (node != null) {
            ListNode nextNode;
            nextNode = node.next;
            node.next = null;
            ListNode targetNode = isEven ? newRight : newLeft;
            if (isEven) {
                if (newRight == null) {
                    newRight = node;
                    newRightHead = node;
                } else {
                    newRight.next = node;
                    newRight = node;
                }
            } else {
                if (newLeft == null) {
                    newLeft = node;
                    newLeftHead = node;
                } else {
                    newLeft.next = node;
                    newLeft = node;
                }
            }
            node = nextNode;
            isEven = !isEven;
        }
        ListNode newHead = newLeftHead;
        newLeft.next = newRightHead;

        return newHead;
    }
}
