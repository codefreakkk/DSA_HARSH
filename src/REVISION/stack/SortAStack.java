package REVISION.stack;
import java.util.Stack;

public class SortAStack {

    private void sort(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || !stack.isEmpty() && stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int poppedValue = stack.pop();
        sort(stack, value);
        stack.push(poppedValue);
    }

    private void solve(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int value = stack.pop();
        solve(stack);
        sort(stack, value);
    }

    public Stack<Integer> sort(Stack<Integer> stack) {
        solve(stack);
        return stack;
    }


    public static void main(String[] args) {

    }
}
