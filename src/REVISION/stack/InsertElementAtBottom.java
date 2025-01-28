package REVISION.stack;
import java.util.*;

public class InsertElementAtBottom {
    private void solve(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int poppedValue = stack.pop();
        solve(stack, x);
        stack.push(poppedValue);
    }

    public Stack<Integer> insertAtBottom(Stack<Integer> stack, int x) {
        solve(stack, x);
        return stack;
    }

}
