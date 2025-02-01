package REVISION.stack;
import java.util.Stack;

public class NextGreaterElement2 {

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[n - 1]);

        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            int value = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= value) {
                stack.pop();
            }
            if (i < n) {
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(value);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
