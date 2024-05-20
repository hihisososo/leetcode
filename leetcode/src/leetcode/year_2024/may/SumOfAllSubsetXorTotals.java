package leetcode.year_2024.may;

public class SumOfAllSubsetXorTotals {
    public static void main(String[] args) {
        System.out.println(new SumOfAllSubsetXorTotals().subsetXORSum(new int[]{1, 3}));
        System.out.println(new SumOfAllSubsetXorTotals().subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(new SumOfAllSubsetXorTotals().subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    int totalSum = 0;

    public int subsetXORSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, new boolean[nums.length], 0);
        }
        return totalSum;
    }

    private void dfs(int[] nums, int idx, boolean[] visit, int sum) {
        if (visit[idx]) {
            return;
        }
        visit[idx] = true;
        sum ^= nums[idx];
        totalSum += sum;

        for (int i = idx + 1; i < nums.length; i++) {
            dfs(nums, i, visit, sum);
        }

        visit[idx] = false;
    }
}
