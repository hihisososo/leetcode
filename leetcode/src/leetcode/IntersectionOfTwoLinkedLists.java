package leetcode;

import java.util.Stack;

public class IntersectionOfTwoLinkedLists {
	public static void main(String[] args) {
		int[] a = new int[] { 2, 6, 4, 1, 5 };
		int[] b = new int[] { 1, 5 };
		ListNode[] heads = makeNode(a, b, 10, 10);

		ListNode node = new IntersectionOfTwoLinkedLists().getIntersectionNode(heads[0], heads[1]);
		System.out.println(node.val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Stack<ListNode> aStack = new Stack<ListNode>();
		Stack<ListNode> bStack = new Stack<ListNode>();

		while (headA != null) {
			aStack.push(headA);
			headA = headA.next;
		}

		while (headB != null) {
			bStack.push(headB);
			headB = headB.next;
		}

		ListNode lastNode = null;
		while (!aStack.isEmpty() && !bStack.isEmpty()) {
			ListNode aNode = aStack.pop();
			ListNode bNode = bStack.pop();
			if (!aNode.equals(bNode)) {
				return lastNode;
			} else {
				lastNode = aNode;
			}
		}

		return lastNode;

	}
	
	private static ListNode[] makeNode(int[] a, int[] b, int intersectAIdx, int intersectBIdx) {
		ListNode headA = null;
		ListNode node = null;
		ListNode intersectNode = new ListNode(a[intersectAIdx]);
		for (int i = 0; i < a.length; i++) {
			if (intersectAIdx == i) {
				node.next = intersectNode;
				node = node.next;
				continue;
			}

			if (i == 0) {
				headA = new ListNode(a[i]);
				node = headA;
			} else {
				node.next = new ListNode(a[i]);
				node = node.next;
			}
		}

		ListNode headB = null;
		for (int i = 0; i < b.length; i++) {
			if (intersectBIdx == i) {
				node.next = intersectNode;
				break;
			}

			if (i == 0) {
				headB = new ListNode(b[i]);
				node = headB;
			} else {
				node.next = new ListNode(b[i]);
				node = node.next;
			}
		}
		return new ListNode[] { headA, headB };
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
