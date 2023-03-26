package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    // memoization
    private int solve(int i, int j, String str1, String str2, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) return dp[i][j];

        if (str1.charAt(i) == str2.charAt(j)) {
            return dp[i][j] = solve(i - 1, j - 1, str1, str2, dp);
        }
        int insert = solve(i - 1, j, str1, str2, dp);
        int delete = solve(i, j - 1, str1, str2, dp);
        int replace = solve(i - 1, j - 1, str1, str2, dp);

        int min = 1 + Math.min(insert, Math.min(delete, replace));
        return dp[i][j] = min;
    }


    // memoization
    public int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, m - 1, str1, str2, dp);
    }

    // tabulation
    public int minDistanceTabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    int insert = dp[i - 1][j];
                    int delete = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];

                    int min = 1 + Math.min(insert, Math.min(delete, replace));
                    dp[i][j] = min;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

    }
}
