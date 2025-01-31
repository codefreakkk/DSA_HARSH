package REVISION.stack;

import java.util.Stack;

public class MaximumRectangle {

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

    public int maximumRectangle(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = matrix[i][j] - '0';
            }
        }

        int ans = largestRectangle(grid[0]);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    grid[i][j] += grid[i - 1][j];
                }
            }
            ans = Math.max(ans, largestRectangle(grid[i]));
        }
        return ans;
    }


    public static void main(String[] args) {

    }

}
