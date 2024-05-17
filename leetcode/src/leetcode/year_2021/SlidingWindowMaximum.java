package leetcode.year_2021;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{4, -2};
        int k = 2;
        int[] result = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int windowMaxLen = nums.length - k + 1;
        int[] windowMaxs = new int[windowMaxLen];

        if (nums.length == k) {
            windowMaxs[0] = nums[getMaxIdx(nums, 0, k - 1)];
            return windowMaxs;
        }

        int maxIdx = getMaxIdx(nums, 0, k - 1);
        int maxVal = nums[maxIdx];
        windowMaxs[0] = maxVal;
        for (int i = 1; i < windowMaxLen; i++) {
            if (maxIdx < i) {
                maxIdx = getMaxIdx(nums, i, i + k - 1);
                maxVal = nums[maxIdx];
            } else {
                if (nums[i + k - 1] > maxVal) {
                    maxIdx = i + k - 1;
                    maxVal = nums[i + k - 1];
                }
            }
            windowMaxs[i] = maxVal;
        }

        return windowMaxs;
    }

    private int getMaxIdx(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
