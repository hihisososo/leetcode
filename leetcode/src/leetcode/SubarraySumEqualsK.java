package leetcode;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int sum = getSum(nums);
        int kCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                sum -= nums[i - 1];
            }
            int sumFromIdx = sum;
            if (k == sumFromIdx) {
                kCnt++;
            }
            for (int j = nums.length - 1; j > i; j--) {
                sumFromIdx -= nums[j];
                if (k == sumFromIdx) {
                    kCnt++;
                }
            }
        }
        return kCnt;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
