package Greedy;

import java.util.*;

public class ParenthesesChecker {
    public static boolean checkParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            }
            else if (stack.isEmpty()) return false;
            else if (i == ')') {
                if (stack.peek() == '(') stack.pop();
                else return false;
            }
            else if (i == ']') {
                if (stack.peek() == '[') stack.pop();
                else return false;
            }
            else {
                if (stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "{([]}";
        System.out.println(checkParentheses(s));
    }
}
