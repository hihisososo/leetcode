package leetcode.year_2022.november;

import java.util.Stack;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        System.out.println(new MakeTheStringGreat().makeGood("leEeetcode"));
        System.out.println(new MakeTheStringGreat().makeGood("abBAcC"));
        System.out.println(new MakeTheStringGreat().makeGood("NAanorRoOrROwnTNW"));
    }

    public String makeGood(String s) {
        if (s.length() < 2) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && notGood(stack.peek(), chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();

    }

    private boolean notGood(char a, char b) {
        return ((a - 32 == b) || (b - 32 == a));
    }
}
