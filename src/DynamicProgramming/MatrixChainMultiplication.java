package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {

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

    public int mcm(int[] nums, int n) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(1, n - 1, nums, dp);
    }


    public static void main(String[] args) {

    }
}
