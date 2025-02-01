package REVISION.stack;
import java.util.*;

public class SumOfSubarrayMinimum {

    private int[] nextSmallerToLeft(int[] nums, int n) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] > num) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private int[] nextSmallerToRight(int[] nums, int n) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] <= num) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] nums) {
        int n = nums.length, total = 0;
        int MOD = (int) 1e9+7;

        int[] nsl = nextSmallerToLeft(nums, n);
        int[] nsr = nextSmallerToRight(nums, n);

        for (int i = 0; i < n; i++) {
            int left = i - nsl[i];
            int right = nsr[i] - i;

            total = (total + left * right * nums[i]) % MOD;
        }
        return total;
    }


    public static void main(String[] args) {

    }

}
