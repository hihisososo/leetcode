package leetcode.year_2021;

public class ImplementStrstr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new ImplementStrstr().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean isMatch = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return i;
                }
            }
        }
        return -1;
    }
}
