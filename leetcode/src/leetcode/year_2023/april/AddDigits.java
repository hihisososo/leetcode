package leetcode.year_2023.april;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
        System.out.println(new AddDigits().addDigits(0));
    }

    public int addDigits(int num) {
        String numStr = String.valueOf(num);
        while (numStr.length() != 1) {
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
            }
            numStr = String.valueOf(sum);
        }
        return Integer.parseInt(numStr);
    }
}
