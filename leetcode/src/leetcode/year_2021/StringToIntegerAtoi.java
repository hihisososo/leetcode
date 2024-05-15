package leetcode.year_2021;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(new StringToIntegerAtoi().myAtoi(s));
    }

    public int myAtoi(String s) {
        StringBuffer read = new StringBuffer();
        s = step1(s);
        s = step2(read, s);
        step3(read, s);
        String num = step4(read.toString());
        return step5(num);
    }

    private int step5(String s) {
        try {
            if (s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
                return 0;
            }

            int val = Integer.parseInt(s);

            return val;
        } catch (NumberFormatException e) {
            if (s.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }

    private String step4(String s) {
        return s.replaceAll("^0+", "");
    }

    private void step3(StringBuffer read, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                read.append(s.charAt(i));
            } else {
                break;
            }
        }
    }

    private String step2(StringBuffer read, String s) {
        if (s.isEmpty()) {
            return s;
        }
        char c = s.charAt(0);
        if (c == '+' || c == '-') {
            read.append(c);
            s = s.substring(1, s.length());
        }
        return s;
    }

    private String step1(String s) {
        return s.replaceAll("^\\s+", "");
    }
}
