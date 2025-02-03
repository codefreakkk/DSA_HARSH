package REVISION.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StockSpan {

    class Pair {
        int key, index;
        public Pair(int key, int index) {
            this.key = key;
            this.index = index;
        }
    }

    Stack<Pair> stack;
    int index;

    public StockSpan() {
        this.stack = new Stack<Pair>();
        this.index = -1;
    }

    public int next(int price) {
        index += 1;

        while (!stack.isEmpty() && stack.peek().key <= price) {
            stack.pop();
        }

        int ans = stack.isEmpty() ? - 1 : index - stack.peek().index;
        stack.push(new Pair(price , index));
        return ans;
    }

    public static void main(String[] args) {

    }
}
