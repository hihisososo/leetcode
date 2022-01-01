package leetcode.year_2021;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "bbbba";
        String p = ".*a*a";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        return findMatch(s, 0, p, 0);
    }

    private boolean findMatch(String s, int sIdx, String p, int pIdx) {
        if (sIdx == s.length() && pIdx == p.length()) {
            return true;
        }

        if (isWildCard(p, pIdx)) {
            int maxWildCardIdx = findMaxWildCardChar(s, sIdx, p.charAt(pIdx));
            if (maxWildCardIdx < 0) {
                return findMatch(s, sIdx, p, pIdx + 2);
            } else {
                for (int i = maxWildCardIdx; i >= sIdx - 1; i--) {
                    if (findMatch(s, i + 1, p, pIdx + 2)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            if (sIdx >= s.length() || pIdx >= p.length()) {
                return false;
            }

            if (p.charAt(pIdx) == '.' || s.charAt(sIdx) == p.charAt(pIdx)) {
                return findMatch(s, sIdx + 1, p, pIdx + 1);
            } else {
                return false;
            }
        }
    }

    private int findMaxWildCardChar(String s, int sIdx, char c) {
        int maxIdx = -1;
        for (int i = sIdx; i < s.length(); i++) {
            if (s.charAt(i) == c || c == '.') {
                maxIdx = i;
            } else {
                break;
            }
        }
        return maxIdx;
    }

    private boolean isWildCard(String s, int i) {
        return s.length() <= i + 1 ? false : s.charAt(i + 1) == '*';
    }

}
