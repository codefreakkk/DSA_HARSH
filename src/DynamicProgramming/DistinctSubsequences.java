package DynamicProgramming;
import java.util.*;

public class DistinctSubsequences {

    // memoization
    private int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            int left = solve(i - 1, j - 1, s1, s2, dp);
            int right = solve(i - 1, j, s1, s2, dp);
            return dp[i][j] = left + right;
        }
        return dp[i][j] = solve(i - 1, j, s1, s2, dp);
    }

    // memoization
    public int numDistinct(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, m - 1, s1, s2, dp);
    }


    // tabulation
    public int numDistanceTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }


    // tabulation + 1D Space-Optimization
    public int numDistanceTabulationSpaceOptimization(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    prev[j] = prev[j - 1] + prev[j];
                }
            }
        }
        return prev[m];
    }

    public static void main(String[] args) {

    }
}
