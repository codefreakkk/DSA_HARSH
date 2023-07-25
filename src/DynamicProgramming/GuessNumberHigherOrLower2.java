package DynamicProgramming;
import java.util.*;

public class GuessNumberHigherOrLower2 {

    // memoization
    private int solve(int start, int end, int[][] dp) {
        if (start >= end) return 0;

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int lower = solve(start, i - 1, dp);
            int higher = solve(i + 1, end, dp);
            ans = Math.min(ans, i + Math.max(lower, higher));
        }
        return dp[start][end] = ans;
    }

    // tabulation
    public int tabulation(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int start = n; start >= 1; start--) {
            for (int end = start; end <= n; end++) {

                if (start == end) continue;

                int ans = Integer.MAX_VALUE;
                for (int i = start; i <= end; i++) {
                    int lower = dp[start][i - 1];
                    int higher = dp[i + 1][end];
                    ans = Math.min(ans, i + Math.max(lower, higher));
                }
                dp[start][end] = ans;
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }
        return solve(1, n, dp);
    }


    public static void main(String[] args) {

    }
}
