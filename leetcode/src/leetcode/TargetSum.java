package leetcode;

public class TargetSum {
    private int cnt = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(new TargetSum().findTargetSumWays(nums, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        findTargetSum(nums, 0, 0, target);
        return cnt;
    }

    private void findTargetSum(int[] nums, int idx, int sum, int target) {
        if (idx == nums.length) {
            if (sum == target) {
                cnt++;
            }
            return;
        }

        findTargetSum(nums, idx + 1, sum + nums[idx], target);
        findTargetSum(nums, idx + 1, sum - nums[idx], target);
    }
}
