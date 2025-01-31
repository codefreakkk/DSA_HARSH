package REVISION.stack;

import java.util.*;

public class LargestRectangleInHistogram {

    public int[] nearestSmallerToRight(int[] heights, int n) {
        int[] nums = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = n - 1; i >= 0; i--) {
            int num = heights[i];
            while (stack.peek() != -1 && heights[stack.peek()] >= num) {
                stack.pop();
            }
            nums[i] = stack.peek();
            stack.push(i);
        }
        return nums;
    }

    public int[] nearestSmallerToLeft(int[] heights, int n) {
        int[] nums = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            int num = heights[i];
            while (stack.peek() != -1 && heights[stack.peek()] >= num) {
                stack.pop();
            }
            nums[i] = stack.peek();
            stack.push(i);
        }
        return nums;
    }

    public int largestRectangle(int[] heights) {
        int n = heights.length;

        int[] nsr = nearestSmallerToRight(heights, n);
        int[] nsl = nearestSmallerToLeft(heights, n);

        int ans = -1;
        for (int i = 0; i < n; i++) {
            int length = heights[i];

            if (nsr[i] == -1) {
                nsr[i] = n;
            }

            int breadth = nsr[i] - nsl[i] - 1;
            ans = Math.max(ans, length * breadth);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram o = new LargestRectangleInHistogram();
        System.out.println(o.largestRectangle(new int[]{2,4}));
    }

}
