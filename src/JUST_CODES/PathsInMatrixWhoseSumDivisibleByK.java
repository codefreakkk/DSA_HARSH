package JUST_CODES;

import java.util.Arrays;

public class PathsInMatrixWhoseSumDivisibleByK {

    private int MOD = (int) 1e9+7;

    private int solve(int[][] grid, int sum, int row, int col, int k, int[][][] dp) {
        if (row == 0 && col == 0) {
            if (sum % k == 0) return 1;
            return 0;
        }

        if (dp[row][col][sum] != -1) {
            return dp[row][col][sum];
        }

        int left = 0, right = 0;
        if (row - 1 >= 0 && col >= 0) {
            left = solve(grid, (sum + grid[row - 1][col]) % k, row - 1, col, k, dp);
        }
        if (col - 1 >= 0 && row >= 0) {
            right = solve(grid, (sum + grid[row][col - 1]) % k, row, col - 1, k, dp);
        }

        return dp[row][col][sum] = (left + right) % MOD;
    }

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int[][] nums : dp) {
            for (int[] num : nums) Arrays.fill(num, -1);
        }

        return solve(grid, grid[n - 1][m - 1] % k, n - 1, m - 1, k, dp);
    }


    public static void main(String[] args) {

    }
}
