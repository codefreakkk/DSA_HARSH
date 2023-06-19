package POTD_LEETCODE;

import java.util.Arrays;

public class NumberOfIncreasingPathInAGrid {

    private int MOD = (int) 1e9 + 7;

    private boolean isNotValid(int row, int col, int prev, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] <= prev) {
            return true;
        }
        return false;
    }

    private int dfs(int row, int col, int prev, int[][] grid, int[][] dp) {
        if (isNotValid(row, col, prev, grid)) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int count = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            count += dfs(newRow, newCol, grid[row][col], grid, dp);
        }
        return dp[row][col] = (count + 1) % MOD;
    }

    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        int paths = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paths = (paths + dfs(i, j, -1, grid, dp)) % MOD;
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        NumberOfIncreasingPathInAGrid o = new NumberOfIncreasingPathInAGrid();
        int[][] grid = {{1, 1},{3, 4}};
        System.out.println(o.countPaths(grid));
    }
}
