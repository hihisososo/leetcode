package leetcode.year_2024.may;

import common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode node = new RemoveNodesFromLinkedList().removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8))))));
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        ListNode node2 = new RemoveNodesFromLinkedList().removeNodes(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))));
        while (node2 != null) {
            System.out.println(node2.val);
            node2 = node2.next;
        }
    }

    public ListNode removeNodes(ListNode head) {

        List<Integer> nodeVals = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodeVals.add(node.val);
            node = node.next;
        }

        Collections.reverse(nodeVals);
        List<Integer> resultVals = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nodeVals.size(); i++) {
            if (max <= nodeVals.get(i)) {
                max = nodeVals.get(i);
                resultVals.add(nodeVals.get(i));
            }
        }

        Collections.reverse(resultVals);
        ListNode resultHead = new ListNode(resultVals.get(0));
        ListNode resultNode = resultHead;
        for (int i = 1; i < resultVals.size(); i++) {
            resultNode.next = new ListNode(resultVals.get(i));
            resultNode = resultNode.next;
        }
        return resultHead;
    }
}
