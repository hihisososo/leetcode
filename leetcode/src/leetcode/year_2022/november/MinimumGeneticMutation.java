package leetcode.year_2022.november;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(new MinimumGeneticMutation().minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> validSet = new HashSet<>();
        for (String b : bank) {
            validSet.add(sort(b));
        }

        if (!validSet.contains(sort(end))) {
            return -1;
        }

        Map<Character, Integer> startCntMap = new HashMap<>();
        for (int i = 0; i < start.length(); i++) {
            startCntMap.putIfAbsent(start.charAt(i), 0);
            startCntMap.put(start.charAt(i), startCntMap.get(start.charAt(i)) + 1);
        }

        int diffCount = 0;
        for (int i = 0; i < end.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount == 0 ? -1 : diffCount;
    }

    private String sort(String b) {

        char[] bankChars = b.toCharArray();
        Arrays.sort(bankChars);
        return new String(bankChars);
    }
}
