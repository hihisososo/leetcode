package leetcode.year_2021;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(new MissingNumber().missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int[] numsCheck = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            numsCheck[nums[i]] = nums[i];
        }
        for (int i = 1; i < numsCheck.length; i++) {
            if (numsCheck[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
