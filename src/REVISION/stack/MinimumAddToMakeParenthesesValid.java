package REVISION.stack;
import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeStringValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')' && !stack.isEmpty()) {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }


    public static void main(String[] args) {

    }
}
