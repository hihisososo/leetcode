package leetcode.year_2021;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 1, -2, 6}));
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (first > nums[i]) {
                first = nums[i];
            } else if (second > nums[i] && first < nums[i]) {
                second = nums[i];
            } else {
                if (second < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
