package leetcode.year_2022.april;

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(new ZigzagConversion().convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            if (row == 0 || row == numRows - 1) {
                sb.append(getChar(row, numRows, s));
                continue;
            }
            sb.append(getDown(row, numRows, s, row));
        }
        return sb.toString();
    }

    private String getDown(int idx, int numRows, String s, int row) {
        if (idx >= s.length()) {
            return "";
        }

        int nextIdx = (numRows - row - 1) * 2 + idx;
        return String.valueOf(s.charAt(idx)) + getUp(nextIdx, numRows, s, row);
    }

    private String getUp(int idx, int numRows, String s, int row) {
        if (idx >= s.length()) {
            return "";
        }

        int nextIdx = (row) * 2 + idx;
        return String.valueOf(s.charAt(idx)) + getDown(nextIdx, numRows, s, row);
    }

    private String getChar(int idx, int numRows, String s) {
        if (idx >= s.length()) {
            return "";
        }

        int nextIdx = idx + (numRows * 2) - 2;
        return String.valueOf(s.charAt(idx)) + getChar(nextIdx, numRows, s);
    }

}
