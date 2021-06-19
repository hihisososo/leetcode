package leetcode;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1, 5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);

        if (sum % 2 != 0) {
            return false;
        }

        int avg = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][avg];
        return DFS(nums, 0, 0, avg, memo);

    }

    private boolean DFS(int[] nums, int idx, int sum, int avg, Boolean[][] memo) {

        if (idx == nums.length || sum > avg) {
            return false;
        }

        if (sum == avg) {
            return true;
        }

        if (memo[idx][sum] != null) {
            return memo[idx][sum];
        }

        boolean result = false;
        result = DFS(nums, idx + 1, sum + nums[idx], avg, memo) ||
                DFS(nums, idx + 1, sum, avg, memo);

        memo[idx][sum] = result;

        return result;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

