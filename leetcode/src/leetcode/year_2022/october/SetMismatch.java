package leetcode.year_2022.october;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums(new int[]{3, 2, 2})));
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums(new int[]{2, 3, 2})));
    }

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeatNum = -1;
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                repeatNum = nums[i];
            }
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i + 1)) {
                return new int[]{repeatNum, i + 1};
            }
        }
        return null;
    }
}
