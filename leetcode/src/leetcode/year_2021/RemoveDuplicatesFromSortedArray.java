package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();

        int lastVal = nums[0];
        list.add(lastVal);
        for (int i = 1; i < nums.length; i++) {
            if(lastVal != nums[i]){
                list.add(nums[i]);
                lastVal = nums[i];
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}
