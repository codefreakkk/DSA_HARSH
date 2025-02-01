package REVISION.stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else if (val >= min) {
            stack.push(val);
        } else {
            if (val == Integer.MIN_VALUE) {
                stack.push(val);
                min = val;
            } else {
                stack.push(2 * val - min);
                min = val;
            }
        }
    }

    public void pop() {
        int x = stack.peek();
        if (x >= min) {
            stack.pop();
            if (x == Integer.MIN_VALUE) {
                min = stack.peek();
            }
        } else {
            min = 2 * min - x;
            stack.pop();
        }
    }

    public int top() {
        int value = stack.peek();
        if (value < min) {
            return min;
        } else {
            return value;
        }
    }

    public int getMin() {
        return min;
    }
}
