package leetcode.year_2022.september;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public static void main(String[] args) {
        System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(12));
    }

    public int concatenatedBinary(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String str = Integer.toBinaryString(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1') {
                    result = (result * 2 + 1) % 1000000007;
                } else {
                    result = (result * 2) % 1000000007;
                }
            }
        }
        return result;
    }
}
