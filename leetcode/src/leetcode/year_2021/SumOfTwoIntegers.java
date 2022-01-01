package leetcode.year_2021;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(new SumOfTwoIntegers().getSum(a, b));
    }

    public int getSum(int a, int b) {
        String aBs = Integer.toBinaryString(a);
        String bBs = Integer.toBinaryString(b);

        aBs = paddingZero(aBs, 32);
        bBs = paddingZero(bBs, 32);

        boolean carry = false;
        StringBuffer sb = new StringBuffer();
        for (int i = aBs.length() - 1; i >= 0; i--) {
            sb.append(getSumStr(aBs.charAt(i), bBs.charAt(i), carry));
            carry = isCarry(aBs.charAt(i), bBs.charAt(i), carry);
        }
        String result = sb.reverse().toString().substring(0, 32);
        if (result.startsWith("1")) {
            result = result.substring(1);
            StringBuffer reSb = new StringBuffer();
            for (int i = result.length() - 1; i >= 0; i--) {
                reSb.append(result.charAt(i) == '1' ? '0' : '1');
            }
            return -(Integer.parseInt(reSb.reverse().toString(), 2) + 1);
        } else {
            return Integer.parseInt(result, 2);
        }

    }

    private boolean isCarry(char charA, char charB, boolean carry) {
        int cnt = 0;
        if (charA == '1') {
            cnt++;
        }
        if (charB == '1') {
            cnt++;
        }
        if (carry) {
            cnt++;
        }

        return cnt > 1;
    }

    private int getSumStr(char charA, char charB, boolean carry) {
        int cnt = 0;
        if (charA == '1') {
            cnt++;
        }
        if (charB == '1') {
            cnt++;
        }
        if (carry) {
            cnt++;
        }

        return cnt % 2 == 0 ? 0 : 1;
    }

    private void twoComplement(int a, int b) {
    }

    private String paddingZero(String str, int length) {
        while (str.length() < length) {
            str = "0" + str;
        }
        return str;
    }

}
