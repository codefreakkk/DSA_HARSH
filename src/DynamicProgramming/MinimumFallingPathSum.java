package DynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSum {

    // memoization
    private int solve(int i, int j, int m, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= m) return (int) 1e9;
        if (i == 0) return matrix[0][j];
        if (dp[i][j] != -1) return dp[i][j];

        int min = (int) 1e9;
        for (int col = -1; col <= 1; col++) {
            int result = matrix[i][j] + solve(i - 1, j + col, m, matrix, dp);
            min = Math.min(min, result);
        }
        return dp[i][j] = min;
    }

    // memoization
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int[] row : dp) Arrays.fill(row, -1);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, solve(n - 1, i, m, matrix, dp));
        }
        return min;
    }

    // tabulation
    public int minFallingPathSumTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++)
            dp[0][i] = matrix[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int upLeft = matrix[i][j];
                if (j > 0) upLeft += dp[i - 1][j - 1];
                else upLeft = (int) 1e9;

                int upRight = matrix[i][j];
                if (j < m - 1) upRight += dp[i - 1][j + 1];
                else upRight = (int) 1e9;

                dp[i][j] = Math.min(up, Math.min(upLeft, upRight));
            }
        }

        // return min value
        int min = (int) 1e9;
        for (int i = 0; i < m; i++)
            min = Math.min(min, dp[n - 1][i]);

        return min;
    }

    // tabulation + spaceOptimization
    public int minFallingPathSumTabulationSpaceOptimization(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];

        for (int i = 0; i < m; i++)
            prev[i] = matrix[0][i];

        for (int i = 1; i < n; i++) {
            int[] current = new int[m];
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev[j];

                int upLeft = matrix[i][j];
                if (j > 0) upLeft += prev[j - 1];
                else upLeft = (int) 1e9;

                int upRight = matrix[i][j];
                if (j < m - 1) upRight += prev[j + 1];
                else upRight = (int) 1e9;

                current[j] = Math.min(up, Math.min(upLeft, upRight));
            }
            prev = current;
        }

        // return min value
        int min = (int) 1e9;
        for (int i = 0; i < m; i++)
            min = Math.min(min, prev[i]);

        return min;
    }

    public static void main(String[] args) {

    }
}
