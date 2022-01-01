package leetcode.year_2021;

public class SortList {
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

	public ListNode sortList(ListNode head) {
		if(head == null) {
			return null;
		}
		
		if (head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);

	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode head = null;
		ListNode tail = null;
		while (left != null && right != null) {
			if (left.val < right.val) {
				if (head == null) {
					head = left;
					tail = head;
				} else {
					tail.next = left;
					tail = tail.next;
				}
				left = left.next;
			} else {
				if (head == null) {
					head = right;
					tail = head;
				} else {
					tail.next = right;
					tail = tail.next;
				}
				right = right.next;
			}
		}

		if (left != null) {
			tail.next = left;
		} else if (right != null) {
			tail.next = right;
		}

		return head;
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

	public static void main(String[] args) {
		int[] values = new int[] { -1, 5, 3, 4, 0 };
		ListNode node = makeNode(values);
		ListNode result = new SortList().sortList(node);
		System.out.println(result.val);
	}

	private static ListNode makeNode(int[] values) {
		ListNode head = new ListNode(values[0]);
		ListNode node = head;
		for (int i = 1; i < values.length; i++) {
			node.next = new ListNode(values[i]);
			node = node.next;
		}
		return head;
	}
}
