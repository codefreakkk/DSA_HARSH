package DynamicProgramming;

import java.util.*;

public class MaximumRectangularAreaWithAll1 {

    private int lra(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length, maxArea = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || height[stack.peek()] >= height[i])) {
                int h = height[stack.pop()];
                int width = 0;
                if (stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public int maxRectangle(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '1') matrix[i][j] = 1;
                else matrix[i][j] = 0;
            }
        }

        int[] height = new int[m];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) height[j]++;
                else height[j] = 0;
            }
            int area = lra(height);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
