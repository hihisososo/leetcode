package leetcode.year_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FactorCombinations {
    public static void main(String[] args) {
        int n = 32;
        long time = System.currentTimeMillis();
        System.out.println(new FactorCombinations().getFactors(n));
        System.out.println(System.currentTimeMillis() - time);
    }

    public List<List<Integer>> getFactors(int n) {
        HashSet<String> dupCheckMap = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        find(new ArrayList<Integer>(), n, dupCheckMap, result);
        return result;
    }

    private void find(ArrayList<Integer> integers, int n, HashSet<String> dupCheckMap, List<List<Integer>> result) {
        if (!integers.isEmpty()) {
            ArrayList<Integer> copy = new ArrayList<>(integers);
            copy.add(n);
            Collections.sort(copy);
            String factor = getFactorStr(copy);
            if (dupCheckMap.contains(factor)) {
                return;
            } else {
                result.add(copy);
                dupCheckMap.add(factor);
            }
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                ArrayList<Integer> copy = new ArrayList<>(integers);
                copy.add(i);
                find(copy, n / i, dupCheckMap, result);
            }
        }


    }

    private String getFactorStr(ArrayList<Integer> integers) {
        StringBuffer sb = new StringBuffer();
        for (Integer i :
                integers) {
            sb.append(i + "x");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

}
