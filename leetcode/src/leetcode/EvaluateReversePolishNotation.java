package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                stack.push(operation(stack.pop(), stack.pop(), tokens[i]));
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    private Integer operation(Integer pop, Integer pop1, String token) {
        if (token.equals("+")) {
            return pop1 + pop;
        } else if (token.equals("-")) {
            return pop1 - pop;
        } else if (token.equals("*")) {
            return pop1 * pop;
        } else {
            return pop1 / pop;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

}
