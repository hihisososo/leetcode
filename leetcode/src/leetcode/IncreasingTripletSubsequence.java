package leetcode;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
