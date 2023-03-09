package DynamicProgramming;

import java.util.Arrays;

public class GridUniquePaths2 {
    private int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i >= 0 && j >= 0 && grid[i][j] == 1)
            return 0;

        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);
        return dp[i][j] = up + left;
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : grid) Arrays.fill(row, -1);
        return solve(n - 1, m - 1, grid, dp);
    }

    // tabulation
    public int uniquePathsWithObstaclesTabulation(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // tabulation + space optimization
    public int uniquePathsWithObstaclesTabulationSpaceOptimization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];

        for (int i = 0; i < n; i++) {
            int[] current = new int[m];
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) current[j] = 0;
                else if (i == 0 && j == 0) current[j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[j];
                    if (j > 0) left = current[j - 1];
                    current[j] = up + left;
                }
            }
            dp = current;
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {

    }
}
