package DynamicProgramming;

import java.util.Arrays;

public class CherryPickup2 {

    // memoization
    private int solve(int i, int j1, int j2, int m, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }
        if (i == grid.length - 1) {
            if (j1 == j2) return grid[i][j1];
            else {
                return grid[i][j1] + grid[i][j2];
            }
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = (int) -1e9;
        for (int col1 = -1; col1 <= 1; col1++) {
            for (int col2 = -1; col2 <= 1; col2++) {
                int value = 0;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += solve(i + 1, j1 + col1, j2 + col2, m, grid, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }

    // memoization
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for (int[][] arr : dp) {
            for (int[] row : arr)
                Arrays.fill(row, -1);
        }
        return solve(0, 0, m - 1, m, grid, dp);
    }

    // tabulation
    public int cherryPickupTabulation(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) dp[n - 1][j1][j2] = grid[n - 1][j1];
                else {
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i>= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = (int) -1e9;
                    for (int col1 = -1; col1 <= 1; col1++) {
                        for (int col2 = -1; col2 <= 1; col2++) {
                            int value = 0;

                            if (j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];

                            if (j1 + col1 >= 0 && j1 + col1 < m && j2 + col2 >= 0 && j2 + col2 < m) {
                                value += dp[i + 1][j1 + col1][ j2 + col2];
                            }
                            else value += -1e9;
                            max = Math.max(max, value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    public static void main(String[] args) {

    }
}
