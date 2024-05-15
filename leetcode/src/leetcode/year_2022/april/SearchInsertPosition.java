package leetcode.year_2022.april;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(new SearchInsertPosition().searchInsert(nums, -1));
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private int binarySearch(int[] nums, int target) {
        int leftMin = 0;
        int rightMax = nums.length - 1;
        int idx = 0;
        int val = 0;
        while (leftMin != rightMax) {
            idx = (leftMin + rightMax) / 2;
            val = nums[idx];

            if (val == target) {
                return idx;
            }

            if (val < target) {
                leftMin = idx + 1;
            } else {
                rightMax = idx;
            }

        }

        if (nums[leftMin] < target) {
            return leftMin + 1;
        } else {
            return leftMin;
        }

    }

}
