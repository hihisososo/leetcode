package leetcode.year_2023.january;

import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(new ValidParentheses().isValid("(]"));
    System.out.println(new ValidParentheses().isValid("()[]{}"));
    System.out.println(new ValidParentheses().isValid("()[]{}"));
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty()) {
          return false;
        }
        Character pop = stack.pop();
        if (pop != '(' && c == ')') {
          return false;
        } else if (pop != '[' && c == ']') {
          return false;
        } else if (pop != '{' && c == '}') {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
