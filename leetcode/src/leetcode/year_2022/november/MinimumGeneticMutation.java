package leetcode.year_2022.november;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(new MinimumGeneticMutation().minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    private char[] mutations = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        return findMinMutation(start, end, 0, Arrays.stream(bank).collect(Collectors.toSet()), new HashMap<String, Integer>());
    }

    private int findMinMutation(String curr, String end, int cost, Set<String> bankSet, Map<String, Integer> visit) {
        if (visit.containsKey(curr) && visit.get(curr) <= cost) {
            return -1;
        } else {
            visit.put(curr, cost);
        }
        if (cost > 0 && !bankSet.contains(curr)) {
            return -1;
        } else if (curr.equals(end)) {
            return cost;
        }

        int max = -1;
        for (int i = 0; i < curr.length(); i++) {
            char[] chars = curr.toCharArray();
            for (int j = 0; j < 4; j++) {
                chars[i] = mutations[j];
                String newCurr = new String(chars);
                if (!curr.equals(newCurr)) {
                    max = Math.max(max, findMinMutation(newCurr, end, cost + 1, bankSet, visit));
                }
            }
        }
        return max;

    }
}
