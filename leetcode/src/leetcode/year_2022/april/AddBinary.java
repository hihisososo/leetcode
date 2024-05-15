package leetcode.year_2022.april;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
        System.out.println(new AddBinary().addBinary("11", "1"));
        System.out.println(new AddBinary().addBinary("", ""));
    }

    public String addBinary(String a, String b) {
        int maxIdx = Math.max(a.length(), b.length());
        a = addZero(a, maxIdx);
        b = addZero(b, maxIdx);

        int carry = 0;
        String result = "";
        for (int i = maxIdx - 1; i >= 0; i--) {
            int sum = getInt(a, i) + getInt(b, i) + carry;

            carry = sum / 2;
            result = (sum % 2) + result;
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

    private String addZero(String s, int maxIdx) {
        while (s.length() < maxIdx) {
            s = "0" + s;
        }
        return s;
    }

    private int getInt(String s, int i) {
        if (i >= s.length()) {
            return 0;
        }
        return s.charAt(i) == '1' ? 1 : 0;
    }
}
