package leetcode.year_2021;

public class DecodeString {
    public static void main(String[] args) {
        String s = "100[abc]";
        System.out.println(new DecodeString().decodeString(s));
    }

    public String decodeString(String s) {
        return decode(s);
    }

    private String decode(String s) {
        String rst = "";
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                int notDigitFirstIdx = getNotDigitFirstIdx(s, i);
                int rightBracketIdx = getRightBracketIdx(s, notDigitFirstIdx);
                String target = s.substring(notDigitFirstIdx+1, rightBracketIdx);
                int multiple = Integer.parseInt(s.substring(i, notDigitFirstIdx));
                String repeatTarget = decode(target);
                for (int j = 0; j < multiple; j++) {
                    rst += repeatTarget;
                }
                i = rightBracketIdx;
            } else {
                rst += c;
            }
        }

        return rst;

    }

    private int getNotDigitFirstIdx(String s, int idx) {
        for (int i = idx; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    private int getRightBracketIdx(String s, int idx) {
        int cnt = 0;
        for (int i = idx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                cnt++;
            } else if (c == ']') {
                cnt--;
            }
            if (cnt == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }
}
