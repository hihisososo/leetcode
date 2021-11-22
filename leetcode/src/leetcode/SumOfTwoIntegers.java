package leetcode;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(new SumOfTwoIntegers().getSum(a, b));
    }

    public int getSum(int a, int b) {
        String aBs = Integer.toBinaryString(a);
        String bBs = Integer.toBinaryString(b);

        int length = aBs.length() > bBs.length() ? aBs.length()
                : bBs.length();
        if (aBs.length() > bBs.length()) {
            while (length > bBs.length()) {
                bBs = "0" + bBs;
            }
        } else {
            while (length > aBs.length()) {
                aBs = "0" + aBs;
            }
        }

        boolean carry = false;
        StringBuffer sb = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            char aChar = getChar(i, aBs);
            char bChar = getChar(i, bBs);

            if (aChar == '1' && bChar == '1') {
                if (carry) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                carry = true;
            } else if ((aChar == '1' && bChar == '0') || (aChar == '0' && bChar == '1')) {
                if (carry) {
                    carry = true;
                    sb.append("0");
                } else {
                    carry = false;
                    sb.append("1");
                }
            } else {
                if (carry) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                carry = false;
            }
        }
        if (carry) {
            sb.append("1");
        }
        String str = sb.reverse().toString();
        System.out.println(str.length());
        if(str.length() > 32){
            str = str.substring(1);
        }
        if(str.length() == 32 && str.startsWith("1")){
            str = "-" + str;
        }
        return Integer.parseInt(str, 2);
    }

    private char getChar(int i, String s) {
        if (s.length() <= i) {
            return '0';
        }

        return s.charAt(i);
    }
}
