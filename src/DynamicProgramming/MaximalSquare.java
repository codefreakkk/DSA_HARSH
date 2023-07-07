package DynamicProgramming;
import java.util.*;

public class MaximalSquare {
    private int max = 0;

    private int solve(int i, int j, char[][] matrix, int[][] dp) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j + 1, matrix, dp);
        int diagonal = solve(i + 1, j + 1, matrix, dp);
        int bottom = solve(i + 1, j, matrix, dp);

        if (matrix[i][j] == '1') {
            int ans = 1 + Math.min(right, Math.min(diagonal, bottom));
            max = Math.max(max, ans);
            return dp[i][j] = ans;
        }
        else return dp[i][j] = 0;
    }

    public int tabulation(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];

        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int right = dp[i][j + 1];
                int diagonal = dp[i + 1][j + 1];
                int bottom = dp[i + 1][j];

                if (matrix[i][j] == '1') {
                    int ans = 1 + Math.min(right, Math.min(diagonal, bottom));
                    max = Math.max(ans, max);
                    dp[i][j] = ans;
                }
            }
        }
        return max * max;
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[][] dp = new int[n + 1][m + 1];
        for (int[] dpRow : dp) Arrays.fill(dpRow, -1);

        solve(0, 0, matrix, dp);
        return max * max;
    }

    public static void main(String[] args) {

    }
}
