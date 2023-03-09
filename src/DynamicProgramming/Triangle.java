package DynamicProgramming;

import java.util.*;

public class Triangle {

    // memoization
    private int solve(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
        if (i == n - 1) return triangle.get(n - 1).get(j);
        if (dp[i][j] != -1) return dp[i][j];

        int down = triangle.get(i).get(j) + solve(i + 1, j, n, triangle, dp);
        int right = triangle.get(i).get(j) + solve(i + 1, j + 1, n, triangle, dp);
        return dp[i][j] = Math.min(down, right);
    }

    // memoization
    public int minTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 0, n, triangle, dp);
    }

    // tabulation
    public int minTotalTabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int right = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }

    // tabulation + spaceOptimization
    public int minTotalTabulationSpaceOptimization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] front = new int[n];
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            front[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] current = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + front[j];
                int right = triangle.get(i).get(j) + front[j + 1];
                current[j] = Math.min(down, right);
            }
            front = current;
        }
        return front[0];
    }

    public static void main(String[] args) {

    }
}
