package leetcode.year_2024.june;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{0}, 1));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> occurMap = new HashMap<>();

        int prefixSum = 0;
        occurMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % k;
            if (occurMap.containsKey(prefixSum)) {
                if (i - occurMap.get(prefixSum) >= 2) {
                    return true;
                }
            } else {
                occurMap.put(prefixSum, i);
            }

        }
        return false;
    }
}
