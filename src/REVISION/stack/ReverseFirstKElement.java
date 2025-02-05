package REVISION.stack;
import java.util.*;

public class ReverseFirstKElement {

    public Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {
        int n = queue.size();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < n - k; i++) {
            queue.offer(queue.poll());
        }
        return queue;
    }

    public static void main(String[] args) {

    }
}
