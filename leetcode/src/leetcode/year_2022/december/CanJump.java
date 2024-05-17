package leetcode.year_2022.december;

public class CanJump {

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new CanJump().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        return canJump(0, nums, new boolean[nums.length]);
    }

    private boolean canJump(int idx, int[] nums, boolean[] visit) {
        if (visit[idx]) {
            return false;
        } else if (idx == nums.length - 1) {
            return true;
        }

        visit[idx] = true;

        int jump = nums[idx];
        int end = idx + jump < nums.length ? idx + jump : nums.length - 1;
        for (int i = idx + 1; i <= end; i++) {
            if (canJump(i, nums, visit)) {
                return true;
            }
        }
        return false;
    }

}
