package REVISION.stack;
import java.util.*;

public class NearestSmallerElementToLeft {

    public int[] nearestSmallerElementToLeft(int[] nums, int n) {
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (stack.peek() >= num) {
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(num);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
