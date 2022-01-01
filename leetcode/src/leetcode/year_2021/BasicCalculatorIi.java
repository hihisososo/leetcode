package leetcode.year_2021;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        String s = "1+1+1";
        System.out.println(new BasicCalculatorIi().calculate(s));
    }

    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        Matcher matcher = Pattern.compile("(\\d+|\\+|\\-|\\*|\\/)").matcher(s);
        while (matcher.find()) {
            String token = matcher.group();
            if (isOperator(token)) {
                switch (token) {
                    case "+":
                    case "-":
                        if (stack.size() == 1) {
                            stack.push(token);
                        } else {
                            consumeAll(stack);
                            stack.push(token);
                        }
                        break;
                    case "*":
                    case "/":
                        int a = Integer.parseInt(stack.pop());
                        matcher.find();
                        int b = Integer.parseInt(matcher.group());
                        if (token.equals("*")) {
                            stack.push(String.valueOf(a * b));
                        } else {
                            stack.push(String.valueOf(a / b));
                        }
                        break;
                }
            }else{
                stack.push(token);
            }
        }
        consumeAll(stack);
        return Integer.parseInt(stack.pop());
    }

    private void consumeAll(Stack<String> stack) {
        while (stack.size() > 1) {
            int a = Integer.parseInt(stack.pop());
            String oper = stack.pop();
            int b = Integer.parseInt(stack.pop());
            if (oper.equals("+")) {
                stack.push(String.valueOf(a + b));
            } else {
                stack.push(String.valueOf(b - a));
            }
        }
    }

    private boolean isOperator(String token) {
        return token.matches("(\\+|\\-|\\*|\\/)");
    }
}
