package leetcode;

import leetcode.SortList.ListNode;

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
		if (head == null) {
			return null;
		}

		return mergeSort(head, head);
	}

	private ListNode mergeSort(ListNode node, ListNode fivot) {
		if (node.next == null || fivot == null) {
			return node;
		}

		ListNode lowNodeHead = null;
		ListNode lowNode = null;
		ListNode highNodeHead = null;
		ListNode highNode = null;

		while (node != null) {
			if (node.val >= fivot.val) {
				if (highNodeHead == null) {
					highNodeHead = node;
					highNode = node;
				} else {
					highNode.next = node;
					highNode = highNode.next;
				}
			} else {
				if (lowNodeHead == null) {
					lowNodeHead = node;
					lowNode = node;
				} else {
					lowNode.next = node;
					lowNode = lowNode.next;
				}
			}
			node = node.next;
		}
		
		if(highNode != null) {
			highNode.next = null;
		}
		if(lowNode != null) {
			lowNode.next = null;
		}
		
		if(lowNodeHead != null) {
			ListNode lowNodeResult = mergeSort(lowNodeHead, lowNodeHead);
			ListNode lowNodeResultLast = lowNodeResult;
			while(lowNodeResultLast.next != null) {
				lowNodeResultLast = lowNodeResultLast.next;
			}
			lowNodeResultLast.next = mergeSort(highNodeHead, highNodeHead);
			return lowNodeResult;
		}else {
			return mergeSort(highNodeHead, fivot.next);
		}
	}

	public static void main(String[] args) {
		int[] values = new int[] {4,19,14,5,-3,1,8,5,11,15};
		ListNode node = makeNode(values);
		ListNode result = new SortList().mergeSort(node, node);
		System.out.println(result.val);
	}

	private static ListNode makeNode(int[] values) {
		ListNode head = new ListNode(values[0]);
		ListNode node = head;
		for(int i=1;i<values.length;i++) {
			node.next = new ListNode(values[i]);
			node = node.next;
		}
		return head;
	}
}
