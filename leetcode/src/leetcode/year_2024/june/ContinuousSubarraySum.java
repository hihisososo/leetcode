package leetcode.year_2024.june;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{0}, 1));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] subSum = new int[nums.length + 1];
        subSum[0] = 0;
        for (int i = 1; i < subSum.length; i++) {
            subSum[i] = subSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < subSum.length; i++) {
            for (int j = i + 2; j < subSum.length; j++) {
                if ((subSum[j] - subSum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
