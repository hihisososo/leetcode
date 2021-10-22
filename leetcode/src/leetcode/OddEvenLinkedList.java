package leetcode;

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
        ListNode lastNode = findLastNode(head);
        if (head == lastNode) {
            return head;
        }
        ListNode previous = head;
        ListNode node = head.next;
        ListNode end = lastNode;
        boolean isEven = true;
        while (node != end) {
            if (isEven) {
                previous.next = node.next;
                node.next = null;
                lastNode.next = node;
                lastNode = node;
                node = previous.next;
            } else {
                previous = node;
                node = node.next;
            }
            isEven = !isEven;
        }
        return head;
    }

    private ListNode findLastNode(ListNode head) {
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
