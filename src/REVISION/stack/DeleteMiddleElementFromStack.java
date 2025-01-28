package REVISION.stack;
import java.util.Stack;
public class DeleteMiddleElementFromStack {

    public void solve(int count, int n, Stack<Integer> stack) {
        if (count == (n / 2)) {
            stack.pop();
            return;
        }
        int poppedValue = stack.pop();
        solve(count + 1, n, stack);
        stack.push(poppedValue);
    }

    public void deleteMiddle(Stack<Integer> stack) {
        int n = stack.size();
        solve(0, n, stack);
    }


    public static void main(String[] args) {

    }

}
