package leetcode.year_2022.november;

public class Maximum69Number {
    public static void main(String[] args) {
        System.out.println(new Maximum69Number().maximum69Number(9669));
        System.out.println(new Maximum69Number().maximum69Number(9996));
        System.out.println(new Maximum69Number().maximum69Number(9999));
    }

    public int maximum69Number(int num) {
        char[] numStr = String.valueOf(num).toCharArray();
        for (int i = 0; i < numStr.length; i++) {
            if (numStr[i] == '6') {
                numStr[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(numStr));
    }
}
