package leetcode.year_2021;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(new LargestNumber().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < numsStr.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });

        if (numsStr[0].startsWith("0")) {
            return "0";
        }

        String result = "";
        for (int i = 0; i < numsStr.length; i++) {
            result += numsStr[i];
        }
        return result;
    }
}
