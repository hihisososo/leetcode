package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberIi {
    int[] nums = new int[]{0, 1, 6, 8, 9};
    int[] centerNums = new int[]{0, 1, 8};

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new StrobogrammaticNumberIi().findStrobogrammatic(n));
    }

    public List<String> findStrobogrammatic(int n) {
        if (n == 1) {
            return Arrays.asList(new String[]{"0", "1", "8"});
        }

        if (n % 2 == 0) {
            return makeEvenResult(n);
        } else {
            return makeOddResult(n);
        }
    }

    private List<String> makeOddResult(int n) {

        List<String> halfs = new ArrayList<>();
        getCandidates("", nums, n / 2, halfs);

        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < halfs.size(); i++) {
            String s = halfs.get(i);
            for (int j = 0; j < centerNums.length; j++) {
                sb.append(s + centerNums[j]);
                for (int k = s.length() - 1; k >= 0; k--) {
                    char c = s.charAt(k);
                    if (c == '6') {
                        c = '9';
                    } else if (c == '9') {
                        c = '6';
                    }
                    sb.append(c);
                }
                result.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return result;
    }

    private List<String> makeEvenResult(int n) {
        List<String> halfs = new ArrayList<>();
        getCandidates("", nums, n / 2, halfs);

        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < halfs.size(); i++) {
            String s = halfs.get(i);
            sb.append(s);
            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                if (c == '6') {
                    c = '9';
                } else if (c == '9') {
                    c = '6';
                }
                sb.append(c);
            }

            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return result;
    }

    private void getCandidates(String s, int[] nums, int limit, List<String> result) {
        if (s.length() == limit) {
            if (!s.startsWith("0")) {
                result.add(s);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            getCandidates(s + nums[i], nums, limit, result);
        }
    }

}
