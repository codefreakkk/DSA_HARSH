package REVISION.stack;

import java.util.Stack;

public class ValidParentheses {

    private boolean checkBracket(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (checkBracket(ch)) {
                stack.push(ch);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if (top == '{' && ch == '}') {
                    stack.pop();
                } else if (top == '(' && ch == ')') {
                    stack.pop();
                } else if (top == '[' && ch == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

    }
}
