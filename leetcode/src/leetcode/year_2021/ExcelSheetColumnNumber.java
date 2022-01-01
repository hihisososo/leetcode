package leetcode.year_2021;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String columnTitle = "AB";
        System.out.println(new ExcelSheetColumnNumber().titleToNumber(columnTitle));
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            result += Math.pow(26, columnTitle.length() - 1 - i) * (columnTitle.charAt(i) - 64);
        }
        return result;
    }
}
