package leetcode.year_2022.january;

import java.util.*;

public class PalindromePermutationIi {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new PalindromePermutationIi().generatePalindromes(s));
    }

    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.putIfAbsent(c, 0);
            charMap.put(c, charMap.get(c) + 1);
        }

        HashSet<String> palindromes = new HashSet<>();
        List<String> result = new ArrayList<>();

        if (s.length() % 2 == 0) {
            if (!canPalindromeEven(charMap)) {
                return new ArrayList<>();
            }
        } else {
            if (!canPalindromeOdd(charMap)) {
                return new ArrayList<>();
            }
        }
        String target = makePrefix(charMap);
        dfs("", target, new boolean[target.length()], palindromes);
        String mid = getMid(charMap, s.length());
        StringBuilder sb = new StringBuilder();
        for (String p : palindromes) {
            result.add(p + mid + sb.append(p).reverse());
            sb.delete(0, sb.length());
        }

        return result;
    }

    private String getMid(HashMap<Character, Integer> charMap, int length) {
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey() + "";
            }
        }
        return "";
    }

    private void dfs(String prefix, String target, boolean[] visited, HashSet<String> palindromes) {
        if (prefix.length() == target.length()) {
            palindromes.add(prefix);
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(prefix + target.charAt(i), target, visited, palindromes);
                visited[i] = false;
            }
        }

    }

    private String makePrefix(HashMap<Character, Integer> charMap) {
        String prefix = "";
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            int cnt = entry.getValue();
            for (int i = 0; i < cnt / 2; i++) {
                prefix += entry.getKey();
            }
        }

        return prefix;
    }

    private boolean canPalindromeOdd(HashMap<Character, Integer> charMap) {
        boolean oddExist = false;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (oddExist) {
                    return false;
                }
                oddExist = true;
            }
        }
        return true;
    }

    private boolean canPalindromeEven(HashMap<Character, Integer> charMap) {
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

}
