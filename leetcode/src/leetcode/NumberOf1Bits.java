package leetcode;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = -3;
        System.out.println(new NumberOf1Bits().hammingWeight(n));
    }

    public int hammingWeight(int n) {
        String binaryStr = Integer.toBinaryString(n);

        int cnt = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
