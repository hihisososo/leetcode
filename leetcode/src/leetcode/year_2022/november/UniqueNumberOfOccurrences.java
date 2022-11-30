package leetcode.year_2022.november;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(new int[]{1, 2}));
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));

    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i : arr) {
            cntMap.merge(i, 1, Integer::sum);
        }
        Set<Integer> occurenceSet = new HashSet<>();
        for (Integer i : cntMap.keySet()) {
            if (occurenceSet.contains(cntMap.get(i))) {
                return false;
            }
            occurenceSet.add(cntMap.get(i));
        }
        return true;
    }
}
