package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));

    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dupSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(dupSet.contains(nums[i])){
                return true;
            }
            dupSet.add(nums[i]);
        }
        return false;
    }
}
