package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < minLength; i++) {
            Character c = null;
            boolean isAllMatch = true;
            for (int j = 0; j < strs.length; j++) {
                if (c == null) {
                    c = strs[j].charAt(i);
                } else {
                    if (c != strs[j].charAt(i)) {
                        isAllMatch = false;
                    }
                }
            }
            if (isAllMatch) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }


}
