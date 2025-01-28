package REVISION.stack;
import java.util.*;

public class ReverseStack {

    private void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int poppedValue = stack.pop();
        insertAtBottom(stack, value);
        stack.push(poppedValue);
    }

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int value = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, value);
    }

    public static void main(String[] args) {

    }

}
