package leetcode.year_2021;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        int max = getMax(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] >= max - 1) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] >= nums[j] || nums[j] == max)
                    continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                    if (nums[k] == max) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
