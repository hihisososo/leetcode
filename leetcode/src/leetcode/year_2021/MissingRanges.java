package leetcode.year_2021;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        System.out.println(new MissingRanges().findMissingRanges(nums, lower, upper));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<Integer> list = new ArrayList<>();
        lower--;
        if (nums.length == 0 || lower != nums[0]) {
            list.add(lower);
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        upper++;
        if (list.size() > 0 && upper != list.get(list.size() - 1)) {
            list.add(upper);
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) >= 2) {
                result.add(makeString(list.get(i), list.get(i - 1)));
            }
        }
        return result;
    }

    private String makeString(int num1, int num2) {
        if (num1 - num2 == 2) {
            return String.valueOf(num1 - 1);
        } else {
            return String.valueOf(num2 + 1) + "->" + String.valueOf(num1 - 1);
        }
    }
}
