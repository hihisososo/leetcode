package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {
        int[] preorder = new int[]{1, 3, 2};
        System.out.println(new VerifyPreorderSequenceInBinarySearchTree().verifyPreorder(preorder));
    }

    public boolean verifyPreorder(int[] preorder) {
        List<Integer> preorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
        }
        int parent = preorderList.get(0);
        preorderList.remove(0);
        traverse(Integer.MAX_VALUE, Integer.MIN_VALUE, preorderList, parent);
        return preorderList.isEmpty();
    }

    private void traverse(int smaller, int larger, List<Integer> preorderList, int parent) {
        if (!preorderList.isEmpty()) {
            int currVal = preorderList.get(0);
            if (!(currVal > larger && currVal < smaller)) {
                return;
            }
            preorderList.remove(0);
            traverse(parent, larger, preorderList, currVal);
        }

        if (!preorderList.isEmpty()) {
            int currVal = preorderList.get(0);
            if (!(currVal > larger && currVal < smaller)) {
                return;
            }
            preorderList.remove(0);
            traverse(smaller, currVal, preorderList, currVal);
        }
    }

}
