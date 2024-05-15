package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class WiggleSortII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 1, 2, 2, 1};
        new WiggleSortII().wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int minIdx = 0;
        int maxidx = nums.length / 2;
        if (nums.length % 2 != 0) {
            maxidx++;
        }

        Deque<Integer> minQueue = new LinkedList<Integer>();
        Deque<Integer> maxQueue = new LinkedList<Integer>();

        for (int i = maxidx - 1; i >= 0; i--) {

            minQueue.add(nums[i]);
        }
        for (int i = (nums.length - 1); i >= maxidx; i--) {
            maxQueue.add(nums[i]);
        }

        int[] newNums = new int[nums.length];
        int lastMinVal = -1;
        for (int i = 0; i < newNums.length; i++) {
            int value;
            if (i % 2 == 0) {
                value = minQueue.poll();
                lastMinVal = value;
            } else {
                value = getMaxval(maxQueue, lastMinVal);
            }

            nums[i] = value;
        }
    }

    private int getMaxval(Deque<Integer> maxQueue, int minValue) {
        ArrayList<Integer> list = new ArrayList<>();
        while (!maxQueue.isEmpty()) {
            int maxVal = maxQueue.poll();
            if (minValue < maxVal) {
                return maxVal;
            } else {
                list.add(maxVal);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            maxQueue.add(list.get(i));
        }
        return -1;
    }
}
