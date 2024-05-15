package leetcode.year_2022.october;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(3));
        System.out.println(new IntegerToRoman().intToRoman(10));
        System.out.println(new IntegerToRoman().intToRoman(58));
        System.out.println(new IntegerToRoman().intToRoman(1994));
    }

    public String intToRoman(int num) {
        String[][] s = new String[][]{{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"M", "MM", "MMM"}};

        String result = "";
        int idx = 0;
        String numStr = String.valueOf(num);
        for (int i = numStr.length() - 1; i >= 0; i--) {
            int numIdx = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if (numIdx == 0) {
                idx++;
                continue;
            }
            String expression = s[idx++][numIdx - 1];
            result = expression + result;
        }
        return result;
    }
}
