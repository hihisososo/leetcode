package leetcode.year_2021;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(0));
		System.out.println(new PalindromeLinkedList().isPalindrome(head));
	}

	public boolean isPalindrome(ListNode head) {
		int count = getNodeLength(head);

		if (count == 0) {
			return false;
		} else if (count == 1) {
			return true;
		} else if (count == 2) {
			return head.val == head.next.val;
		}

		int midCount = count / 2;
		boolean isOdd = count % 2 != 0;

		ListNode compare = getComparStartAndSetPrevNextNull(head, midCount, isOdd);
		ListNode reversed = getReversedNode(head, isOdd);

		while (reversed != null && compare != null) {
			if (compare.val == reversed.val) {
				compare = compare.next;
				reversed = reversed.next;
			} else {
				return false;
			}
		}
		return true;
	}

	private ListNode getReversedNode(ListNode head, boolean isOdd) {

		ListNode node = head;
		ListNode prev = null;
		ListNode next = null;
		while (node != null) {
			ListNode prevNode = node;
			node = node.next;
			prev = next;
			next = prevNode;

			next.next = prev;

		}
		if (isOdd) {
			return prev;
		} else {
			return next;
		}
	}

	private ListNode getComparStartAndSetPrevNextNull(ListNode head, int midCount, boolean isOdd) {
		ListNode node = head;
		midCount = isOdd ? midCount : midCount - 1;
		for (int i = 0; i < midCount; i++) {
			node = node.next;
		}
		ListNode resultNode = node.next;
		node.next = null;
		return resultNode;
	}

	private int getNodeLength(ListNode head) {
		int nodeLen = 0;
		ListNode node = head;
		while (node != null) {
			nodeLen++;
			node = node.next;
		}
		return nodeLen;
	}

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
}
