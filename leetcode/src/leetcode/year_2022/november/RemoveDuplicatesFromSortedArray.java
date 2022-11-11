package leetcode.year_2022.november;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int positionIdx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[positionIdx] = nums[i];
                positionIdx++;
            }
        }
        return positionIdx;
    }
}
