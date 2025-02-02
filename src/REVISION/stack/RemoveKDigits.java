package REVISION.stack;

import java.util.*;

public class RemoveKDigits {

    public String removeKDigits(String num, int k) {
        int n = num.length();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int value = num.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() > value && k > 0) {
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || value != 0 ) stack.push(value);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {

    }

}
