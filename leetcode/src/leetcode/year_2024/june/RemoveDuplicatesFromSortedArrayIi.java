package leetcode.year_2024.june;

public class RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArrayIi().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(new RemoveDuplicatesFromSortedArrayIi().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        int lastVal = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (lastVal == val) {
                cnt++;
                if (cnt <= 2) {
                    nums[idx++] = val;
                }
            } else {
                cnt = 1;
                nums[idx++] = val;
            }
            lastVal = val;
        }
        return idx;
    }
}
