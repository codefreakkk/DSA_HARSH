package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {

    // memoization
    private static int solve(int i, int j, int[] nums, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int mini = (int) 1e9;

        // partition loop
        for (int k = i; k < j; k++) {
            int steps = nums[i - 1] * nums[k] * nums[j];
            steps += solve(i, k, nums, dp);
            steps += solve(k + 1, j, nums, dp);
            mini = Math.min(mini, steps);
        }
        return dp[i][j] = mini;
    }

    // memoization
    public int mcm(int[] nums, int n) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(1, n - 1, nums, dp);
    }

    // tabulation
    public int mcmTabulation(int[] nums, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 0;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int mini = (int) 1e9;
                for (int k = i; k < j; k++) {
                    int steps = nums[i - 1] * nums[k] * nums[j];
                    steps += dp[i][k] + dp[k + 1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {

    }
}

