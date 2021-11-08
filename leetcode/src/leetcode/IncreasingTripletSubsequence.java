package leetcode;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];

        setMins(mins, nums);
        setMaxs(maxs, nums);

        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (true) {
            if (nums[leftIdx] < nums[rightIdx]) {
                if (checkTriplet(nums, nums[leftIdx], nums[rightIdx], leftIdx, rightIdx)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkTriplet(int[] nums, int min, int max, int leftIdx, int rightIdx) {

        if (leftIdx >= rightIdx - 1) {
            return false;
        }

        if (min - max <= 0) {
            return false;
        }

        for (int i = leftIdx + 1; i < rightIdx; i++) {
            if (min < nums[i] && max > nums[i]) {
                return true;
            }
        }
        return false;
    }

    private void setMaxs(int[] maxs, int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (maxs[i] > max) {
                max = maxs[i];
            }
            maxs[i] = max;
        }
    }

    private void setMins(int[] mins, int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (mins[i] < min) {
                min = mins[i];
            }
            mins[i] = min;
        }
    }
}
