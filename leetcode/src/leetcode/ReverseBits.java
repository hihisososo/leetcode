package leetcode;

public class ReverseBits {
    public int reverseBits(int n) {
        String binaryStr = Integer.toBinaryString(n);
        while (binaryStr.length() != 32) {
            binaryStr = "0" + binaryStr;
        }
        String reverseStr = "";
        for (int i = binaryStr.length() - 1; i >= 0; i--) {
            if (binaryStr.charAt(i) == '0') {
                reverseStr += '0';
            } else {
                reverseStr += '1';
            }
        }
        return Integer.parseUnsignedInt(reverseStr, 2);
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.println(new ReverseBits().reverseBits(n));
    }
}
