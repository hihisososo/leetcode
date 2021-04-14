package leetcode;

import leetcode.SortList.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(0, new ListNode(0)));
		System.out.println(new PalindromeLinkedList().isPalindrome(head));
		;
	}

	public boolean isPalindrome(ListNode head) {
		if (head.next == null) {
			return true;
		}

		ListNode mid = getMid(head);
		if (mid.next == null) {
			return head.val == mid.val;
		}

		ListNode node = head;
		ListNode prev = null;
		ListNode next = null;
		while (node != null) {
			if (prev == null) {
				prev = node;
				next = node.next;
				if (next == null) {
					return false;
				}
				node = node.next.next;
			} else {
				ListNode prevNode = node;
				node = node.next;
				prev = next;
				next = prevNode;
			}

			next.next = prev;

			if (prev.equals(head)) {
				prev.next = null;
			}
		}

		node = mid;
		while (node != null) {
			if (next.val == node.val) {
				next = next.next;
				node = node.next;
			} else {
				return false;
			}
		}
		return true;
	}

	private ListNode getMid(ListNode head) {
		ListNode mid = null;
		while (head != null && head.next != null) {
			mid = (mid == null) ? head : mid.next;
			head = head.next.next;
		}
		ListNode midReal = mid.next;
		mid.next = null;
		return midReal;
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
