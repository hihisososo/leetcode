package leetcode.year_2024.june;

public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(new int[]{5}, 9));
    }

    public int subarraysDivByK(int[] nums, int k) {
        int[] groups = new int[k];
        groups[0] = 1;
        int prefixSum = 0;
        int cnt = 0;
        for (int num : nums) {
            prefixSum = (prefixSum + num % k + k) % k;
            cnt += groups[prefixSum];
            groups[prefixSum]++;
        }
        return cnt;
    }
}
