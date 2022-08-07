package leetcode.year_2022.august;

public class TernaryExpressionParser {
    public static void main(String[] args) {
        String expression1 = "T?2:3";
        System.out.println(new TernaryExpressionParser().parseTernary(expression1));
        String expression2 = "F?1:T?4:5";
        System.out.println(new TernaryExpressionParser().parseTernary(expression2));
        String expression3 = "T?T?F:5:3";
        System.out.println(new TernaryExpressionParser().parseTernary(expression3));
    }

    public String parseTernary(String expression) {
        if (expression.length() == 1) {
            return expression;
        }
        if (expression.startsWith("T")) {
            return parseTernary(getLeft(expression));
        } else if (expression.startsWith("F")) {
            return parseTernary(getRight(expression));
        }
        return "";
    }

    private String getLeft(String expression) {
        int colonIndex = getColonIndex(expression);
        return expression.substring(2, colonIndex);
    }

    private String getRight(String expression) {
        int colonIndex = getColonIndex(expression);
        return expression.substring(colonIndex+1);
    }

    private int getColonIndex(String expression) {
        int questionMarkCnt = 0;
        int colonCnt = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') {
                questionMarkCnt++;
            } else if (expression.charAt(i) == ':') {
                colonCnt++;
            }
            if (questionMarkCnt > 0 && questionMarkCnt == colonCnt) {
                return i;
            }
        }
        System.out.println(expression);
        return -1;
    }
}
