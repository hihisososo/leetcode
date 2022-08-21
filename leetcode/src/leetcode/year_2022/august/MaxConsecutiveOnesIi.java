package leetcode.year_2022.august;

public class MaxConsecutiveOnesIi {
    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnesIi().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
        System.out.println(new MaxConsecutiveOnesIi().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        System.out.println(new MaxConsecutiveOnesIi().findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 0, 1}));
        System.out.println(new MaxConsecutiveOnesIi().findMaxConsecutiveOnes(new int[]{0, 0, 0, 0}));
        System.out.println(new MaxConsecutiveOnesIi().findMaxConsecutiveOnes(new int[]{1, 0, 0, 1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int lastFlipIdx = -1;
        int consecutive = 0;
        int maxConsecutive = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (lastFlipIdx == -1) {
                    lastFlipIdx = i;
                } else {
                    consecutive = i - lastFlipIdx - 1;
                    lastFlipIdx = i;
                }
            }
            maxConsecutive = Math.max(maxConsecutive, ++consecutive);
        }
        return maxConsecutive;
    }

}
