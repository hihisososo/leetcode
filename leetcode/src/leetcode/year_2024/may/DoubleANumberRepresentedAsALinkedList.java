package leetcode.year_2024.may;

import common.ListNode;

public class DoubleANumberRepresentedAsALinkedList {

  public static void main(String[] args) {
    ListNode result = new DoubleANumberRepresentedAsALinkedList()
        .doubleIt(new ListNode(9, new ListNode(9, new ListNode(9))));
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }

  }

  public ListNode doubleIt(ListNode head) {
    String number = "";
    while (head != null) {
      number += head.val;
      head = head.next;
    }

    String numberDouble = "";
    int carry = 0;
    for (int i = number.length() - 1; i >= 0; i--) {
      int val = Character.getNumericValue(number.charAt(i)) * 2 + carry;

      if (val >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }

      numberDouble = (val % 10) + numberDouble;

      if (i == 0 && carry == 1) {
        numberDouble = carry + numberDouble;
      }
    }

    ListNode resultHead = null;
    ListNode resultNode = null;

    for (int i = 0; i < numberDouble.length(); i++) {
      int val = Character.getNumericValue(numberDouble.charAt(i));
      if (resultNode == null) {
        resultHead = new ListNode(val);
        resultNode = resultHead;
      } else {
        resultNode.next = new ListNode(val);
        resultNode = resultNode.next;
      }
    }

    return resultHead;
  }
}
