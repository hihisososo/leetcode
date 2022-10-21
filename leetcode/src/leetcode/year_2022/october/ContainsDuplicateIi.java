package leetcode.year_2022.october;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateIi().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(new ContainsDuplicateIi().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(new ContainsDuplicateIi().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(new ContainsDuplicateIi().containsNearbyDuplicate(new int[]{99, 99}, 2));
        System.out.println(new ContainsDuplicateIi().containsNearbyDuplicate(new int[]{2, 2}, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numberMap.containsKey(nums[i])) {
                return true;
            }
            numberMap.putIfAbsent(nums[i], 0);
            numberMap.put(nums[i], numberMap.get(nums[i]) + 1);
            if (i >= k) {
                if (numberMap.get(nums[i - k]) == 1) {
                    numberMap.remove(nums[i - k]);
                } else {
                    numberMap.put(nums[i - k], numberMap.get(nums[i - k]) + 1);
                }
            }
        }
        return false;
    }


}
